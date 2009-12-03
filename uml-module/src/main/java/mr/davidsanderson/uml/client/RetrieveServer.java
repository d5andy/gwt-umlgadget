/**
 * Copyright 2009 David Sanderson <mr.davidsanderson@gmail.com>
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
package mr.davidsanderson.uml.client;

import mr.davidsanderson.uml.client.GraphEvent.GraphEventType;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @author dsand
 *
 */
public class RetrieveServer implements AsyncCallback<UMLGraph> {
	
	private static final String origin = RetrieveServer.class.getName();
	
	public RetrieveServer(UMLGraphServiceAsync service) {
		Log.debug("RetrieveServer : service.getUMLGraph");
		service.getUMLStyles(this);
		
	}

	/* (non-Javadoc)
	 * @see com.google.gwt.user.client.rpc.AsyncCallback#onFailure(java.lang.Throwable)
	 */
	@Override
	public void onFailure(Throwable err) {
		Log.debug("RetrieveServer.onFailure : fire event");
		GraphEventBus.get().fireEvent(new GraphEvent(origin, GraphEventType.SERVICE_FAIL));
		
	}

	/* (non-Javadoc)
	 * @see com.google.gwt.user.client.rpc.AsyncCallback#onSuccess(java.lang.Object)
	 */
	@Override
	public void onSuccess(UMLGraph graph) {
		Log.debug("RetrieveServer.onSuccess : fire event");
		GraphEventBus.get().fireEvent(new GraphEvent(origin, graph, GraphEventType.SERVICE_SUCCESS));
		
	}
	
	

}
