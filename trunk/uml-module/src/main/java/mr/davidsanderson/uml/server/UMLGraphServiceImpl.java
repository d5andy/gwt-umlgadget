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

import mr.davidsanderson.uml.client.UMLGraph;
import mr.davidsanderson.uml.client.UMLGraphService;
import mr.davidsanderson.uml.core.render.StylePropLoader;

import org.modsl.core.lang.uml.UMLMetaType;

import com.google.gwt.user.server.rpc.GadgetServiceServlet;

/**
 * @author dsand
 *
 */
public class UMLGraphServiceImpl extends GadgetServiceServlet implements
		UMLGraphService {
	
	private static StylePropLoader stl;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4696653903537941786L;

	@Override
	public UMLGraph getUMLStyles() {
		return new UMLGraph(getStl().getProps());
	}
	
	private static StylePropLoader getStl() {
		if (stl == null) {
			stl = new StylePropLoader();
			stl.load("cfg/uml:cfg", "uml", UMLMetaType.class);
		}
		return stl;
	}
}
