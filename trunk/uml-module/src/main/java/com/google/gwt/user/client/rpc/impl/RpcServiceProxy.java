/*
 * Copyright 2008 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.gwt.user.client.rpc.impl;

import com.google.gwt.http.client.Request;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.InvocationException;
import com.google.gwt.user.client.rpc.SerializationException;

/**
 * Superclass for client-side
 * {@link com.google.gwt.user.client.rpc.RemoteService RemoteService} proxies.
 * 
 * For internal use only.
 */
public class RpcServiceProxy extends RemoteServiceProxy {

	  protected RpcServiceProxy(String moduleBaseURL,
	      String remoteServiceRelativePath, String serializationPolicyName,
	      Serializer serializer) {
	    super(moduleBaseURL, remoteServiceRelativePath, serializationPolicyName,
	        serializer);
	  }

	  static boolean isReturnValue(String encodedResponse) {
	     return encodedResponse.startsWith("//OK");
	   }

	   /**
	    * Return <code>true</code> if the encoded response contains a checked
	    * exception that was thrown by the method invocation.
	    * 
	    * @param encodedResponse
	    * @return <code>true</code> if the encoded response contains a checked
	    *         exception that was thrown by the method invocation
	    */
	   static boolean isThrownException(String encodedResponse) {
	     return encodedResponse.startsWith("//EX");
	   }

	  public static final String RPC_PAYLOAD_PARAM="rpcpayload";
	  
	  @Override
	  protected <t> Request doInvoke(
	      final RequestCallbackAdapter.ResponseReader responseReader, String methodName, int invocationCount,
	      String requestData, final AsyncCallback<t> tAsyncCallback) {

	    try {
	      makeRequest(getServiceEntryPoint(), "text/x-gwt-rpc; charset=utf-8", requestData, new AsyncCallback<String>() {
	        public void onFailure(Throwable throwable) {
	           tAsyncCallback.onFailure(new InvocationException("Unable to initiate the asynchronous service invocation -- check the network connection. in the failure" + throwable.getMessage()));
	        }

	        public void onSuccess(String encodedResponse) {
	          try {
	            if(isReturnValue(encodedResponse)) {
	              tAsyncCallback.onSuccess((t) responseReader.read(createStreamReader(encodedResponse)));
	            }
	            else if(isThrownException(encodedResponse)) {
	              tAsyncCallback.onFailure((Throwable)responseReader.read(createStreamReader(encodedResponse)));
	              
	            }
	            else {
	              tAsyncCallback.onFailure(new InvocationException("Unknown return value type"));
	            }
	          } catch (SerializationException e) {
	            tAsyncCallback.onFailure(new InvocationException("Failure deserializing object "+e));
	          }
	        }

	      });
	    } catch (Exception ex) {
	      InvocationException iex = new InvocationException(
	          "Unable to initiate the asynchronous service invocation -- check the network connection. at the do invoke." ,
	          ex);
	      tAsyncCallback.onFailure(iex);
	    } finally {
	      if (RemoteServiceProxy.isStatsAvailable()
	          && RemoteServiceProxy.stats(RemoteServiceProxy.bytesStat(methodName,
	          invocationCount, requestData.length(), "requestSent"))) {
	      }
	    }
	    return null;
	  }

	  private native void makeRequest(String serviceEntryPoint, String contentType,
	      String requestData, AsyncCallback tAsyncCallback) /*-{
		var params = {};
		params[gadgets.io.RequestParameters.CONTENT_TYPE] = gadgets.io.ContentType.TEXT;

		//params[gadgets.io.RequestParameters.AUTHORIZATION]=gadgets.io.AuthorizationType.SIGNED;
		params[gadgets.io.RequestParameters.METHOD]=gadgets.io.MethodType.GET;
        alert(serviceEntryPoint);
		gadgets.io.makeRequest(serviceEntryPoint+"?"+@com.google.gwt.user.client.rpc.impl.RpcServiceProxy::RPC_PAYLOAD_PARAM+"="+encodeURIComponent(requestData), function(resp) { 
		    if(resp.errors && resp.errors.length > 0) {
		    	alert(resp.errors);
		      tAsyncCallback.@com.google.gwt.user.client.rpc.AsyncCallback::onFailure(Ljava/lang/Throwable;)(resp.errors[0])
		    }
		    else {
		    tAsyncCallback.@com.google.gwt.user.client.rpc.AsyncCallback::onSuccess(Ljava/lang/Object;)(resp.text);
		    }
		}, params);
	}-*/;
	
}
