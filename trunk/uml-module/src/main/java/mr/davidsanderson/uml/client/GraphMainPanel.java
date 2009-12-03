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

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.ui.ScrollPanel;


/**
 * @author dsand
 *
 */
public class GraphMainPanel extends ScrollPanel {
	
	private GraphSurface graphSurface;
	private UMLEditorPanel umlEditorPanel;

	/**
	 * constructor.
	 */
	public GraphMainPanel() {
		super();
		this.setSize("100%", "100%");
		Log.debug("GraphMainPanel : new GraphSurface");
		graphSurface = new GraphSurface();
		Log.debug("GraphMainPanel : new UMLEditorPanel");
		umlEditorPanel = new UMLEditorPanel();
		
		Log.debug("GraphMainPanel : add graphSurface.");
		add(graphSurface);
		GraphEventBus.get().addHandler(new GraphEventHandler() {

			@Override
			public void onContentChangedEvent(GraphEvent event) {
			}

			@Override
			public void onEdit(GraphEvent event) {
				switch (event.getEventType()) {
				case EDITOR_OPEN :
					Log.debug("GraphMainPanel.onEditorOpen switch");
					GraphMainPanel.this.remove(graphSurface);
					GraphMainPanel.this.add(umlEditorPanel);
					break;
				case EDITOR_CLOSE :
					Log.debug("GraphMainPanel.onEditorClose switch");
					GraphMainPanel.this.remove(umlEditorPanel);
					GraphMainPanel.this.add(graphSurface);
					break;
				}
				
			}

			@Override
			public void onService(GraphEvent event) {
			}
			
		}, GraphEvent.getType());
	}

}
