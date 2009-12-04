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

import gwt.g2d.client.graphics.KnownColor;
import gwt.g2d.client.graphics.Surface;
import gwt.g2d.client.math.Vector2;

import java.util.Map;

import mr.davidsanderson.uml.client.GraphEvent.GraphEventType;
import mr.davidsanderson.uml.core.render.FontMetrics;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

/**
 * @author dsand
 *
 */
public class GraphSurface extends Surface {
	
	private static final String origin = GraphSurface.class.getName();
	
	private String xmlContent;
	private Map<String, String> styles;
	
	private GraphPopupMenu popupMenu;

	/**
	 * GraphSurface.
	 */
	public GraphSurface() {
		super(600,600);
//		setSize("100%", "100%");
		FontMetrics.initialise(getCanvas());
		Log.debug("GraphSurface : constructor");
		String text = "Starting....";
		
		Vector2 position = new Vector2(30, 30);
		this.setStrokeStyle(KnownColor.BLACK).strokeText(text, position)
				.setFillStyle(KnownColor.BLACK).fillText(text, position);

		Log.debug("GraphSurface : new GraphPopupMenu");
		
		popupMenu = new GraphPopupMenu();
		addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				Log.debug("GraphSurface : onClick show popup");
				int x = event.getNativeEvent().getClientX();
				int y = event.getNativeEvent().getClientY();
				GraphSurface.this.popupMenu.setPopupPosition(x, y);
				GraphSurface.this.popupMenu.show();
			}
			
		});
		GraphEventBus.get().addHandler(eventHandler, GraphEvent.getType());
	}
	
	private GraphEventHandler eventHandler = new GraphEventHandler(){

		@Override
		public void onContentChangedEvent(GraphEvent event) {
			Log.debug("GraphSurface.eventHandler.onContentChangedEvent : set content and draw.");
			GraphSurface.this.xmlContent = event.getUmlContent(); 
			GraphSurface.this.draw();
		}

		@Override
		public void onEdit(GraphEvent event) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onService(GraphEvent event) {
			// TODO Auto-generated method stub
			if (event.getEventType().equals(GraphEventType.SERVICE_SUCCESS)) {
				UMLGraph graph = event.getGraph();
				if (graph.styles != null && !graph.styles.isEmpty()) {
					Log.debug("GraphSurface.eventHandler.onServiceSucess : set styles and draw.");
					GraphSurface.this.styles = graph.styles; 
					GraphSurface.this.draw();			
				} else {
					Log.debug("GraphSurface.eventHandler.onServiceSucess : graph.styles empty or null.");
				}
			}
			
		}
		
	};	
	
	public void draw() {
		Log.debug("GraphSurface.draw");
		if (xmlContent != null && !xmlContent.equals("") && styles != null) {
			Log.debug("GraphSurface.draw clear surface");
			this.clear();
			Log.debug("GraphSurface.draw UMLGraphHelper.drawDiagram");
			new UMLGraphHelper().drawDiagram(xmlContent, styles, this);
			int height = this.getHeight();
			int width = this.getWidth();
			Log.debug("GraphSurface.draw " + width + "width "+ height + " height");
			GraphEventBus.get().fireEvent(new GraphEvent(origin, GraphEventType.GRAPH_RESIZE, height, width));
		} else if (xmlContent != null && !xmlContent.equals("")) {
			Log.debug("GraphSurface.draw : xmlContent empty or null.");
		} else if (styles != null && !styles.isEmpty()) {
			Log.debug("GraphSurface.draw : styles empty or null.");
		}
		
	}

}
