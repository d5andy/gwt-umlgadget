package com.google.gwt.user.server.rpc;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gwt.user.client.rpc.impl.RpcServiceProxy;

public class GadgetServiceServlet extends RemoteServiceServlet {

	  /**
	 * 
	 */
	private static final long serialVersionUID = 3315749683757673831L;

	@Override
	  protected void doGet(HttpServletRequest httpServletRequest,
	      HttpServletResponse httpServletResponse)
	      throws ServletException, IOException {
	    doPost(httpServletRequest, httpServletResponse);
	  }

	  @Override
	  protected String readContent(HttpServletRequest httpServletRequest)
	      throws ServletException, IOException {
	    String str = httpServletRequest.getMethod().equals("POST") ? RPCServletUtils
	        .readContentAsUtf8(httpServletRequest, false) : httpServletRequest
	        .getParameter(RpcServiceProxy.RPC_PAYLOAD_PARAM);
	    String ustr = URLDecoder.decode(str);
	    return ustr;
	  }	

}
