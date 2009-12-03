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
package mr.davidsanderson.uml.server;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import mr.davidsanderson.uml.client.UMLGraph;
import mr.davidsanderson.uml.client.UMLGraphService;
import mr.davidsanderson.uml.core.render.StylePropLoader;

import org.modsl.core.lang.uml.UMLMetaType;

import com.google.gwt.user.server.rpc.RPCServletUtils;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * UMLGraphServiceImpl an implementation of the UML graph service compatible with 
 * GWT RPC.
 * 
 * @author dsand
 * 
 */
public class UMLGraphServiceImpl extends RemoteServiceServlet implements
		UMLGraphService {
	
	Logger logger = Logger.getLogger(UMLGraphServiceImpl.class.getName());

	/**
	 * 
	 */
	private static final long serialVersionUID = 8990423684172200388L;

	/* (non-Javadoc)
	 * @see org.modsl.gwt.client.UMLGraphService#getUMLStyles()
	 */
	@Override
	public UMLGraph getUMLStyles() {
		logger.info("UMLGraphServiceImpl.getUMLStyles : populate style props");
		StylePropLoader stl = new StylePropLoader();
		stl.load("cfg/uml:cfg", "uml", UMLMetaType.class);
		logger.info("UMLGraphServiceImpl.getUMLStyles : return graph");
		return new UMLGraph(stl.getProps());
	}

	
	@Override
	protected String readContent(HttpServletRequest request)
			throws ServletException, IOException {
		return RPCServletUtils.readContentAsUtf8(request, false);
	}

}
