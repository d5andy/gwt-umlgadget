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

import mr.davidsanderson.uml.client.GraphEvent;
import mr.davidsanderson.uml.client.GraphEventBus;
import mr.davidsanderson.uml.client.GraphEventHandler;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author dsand
 *
 */
public class GraphMainPanelImpl extends ScrollPanel {
	
	/**
	 * constructor.
	 */
	@Inject
	public GraphMainPanelImpl(@Named("GraphSurface") final Widget graphSurface, @Named("UMLEditorPanel") final Widget umlEditorPanel, 
			@Named("MessagePanel") final Widget messagePanel, final GraphEventBus graphEventBus) {
		super();
		this.setSize("100%", "100%");
		
		Log.debug("GraphMainPanel : add graphSurface.");
		add(messagePanel);
		graphEventBus.addHandler(new GraphEventHandler() {

			@Override
			public void onContentChangedEvent(GraphEvent event) {
			}

			@Override
			public void onEdit(GraphEvent event) {
				switch (event.getEventType()) {
				case EDITOR_OPEN :
					Log.debug("GraphMainPanel.onEdit switch");
					GraphMainPanelImpl.this.remove(GraphMainPanelImpl.this.getWidget());
					GraphMainPanelImpl.this.add(umlEditorPanel);
					break;
				case EDITOR_CLOSE :
					Log.debug("GraphMainPanel.onEdit switch");
					GraphMainPanelImpl.this.remove(GraphMainPanelImpl.this.getWidget());
					GraphMainPanelImpl.this.add(graphSurface);
					break;
				case MSG_CLOSE :
					Log.debug("GraphMainPanel.onEdit switch");
					GraphMainPanelImpl.this.remove(GraphMainPanelImpl.this.getWidget());
					GraphMainPanelImpl.this.add(graphSurface);
					break;
				case MSG_OPEN :
					Log.debug("GraphMainPanel.onEdit switch");
					GraphMainPanelImpl.this.remove(GraphMainPanelImpl.this.getWidget());
					GraphMainPanelImpl.this.add(messagePanel);
					break;
				default :
					break;
					
				}
				
			}

			@Override
			public void onService(GraphEvent event) {
			}
			
		}, GraphEvent.getType());
	}

}