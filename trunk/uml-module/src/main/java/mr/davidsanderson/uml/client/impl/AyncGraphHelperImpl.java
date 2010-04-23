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
package mr.davidsanderson.uml.client.impl;

import gwt.g2d.client.graphics.Surface;

import java.util.Map;

import mr.davidsanderson.uml.client.GraphEventBus;

//import com.google.gwt.core.client.GWT;
//import com.google.gwt.core.client.RunAsyncCallback;
import com.google.inject.Inject;

/**
 * An async version of the graph helper - allows the initial download size to be smaller....
 * @author dsand
 *
 */
public class AyncGraphHelperImpl extends UMLGraphHelperImpl {

	/**
	 * @param graphEventBus
	 */
	@Inject
	public AyncGraphHelperImpl(GraphEventBus graphEventBus) {
		super(graphEventBus);
	}
	
	/* (non-Javadoc)
	 * @see mr.davidsanderson.uml.client.impl.UMLGraphHelperImpl#drawDiagram(java.lang.String, java.util.Map, gwt.g2d.client.graphics.Surface)
	 */
	@Override
	public void drawDiagram(final String xmlContent, final Map<String, String> styles,
			final Surface surface) {
//		GWT.runAsync(new RunAsyncCallback() {
//
//			@Override
//			public void onFailure(Throwable arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void onSuccess() {
//				// TODO Auto-generated method stub
//				AyncGraphHelperImpl.super.drawDiagram(xmlContent, styles, surface);
//			}
//		});		
		
	}

}
