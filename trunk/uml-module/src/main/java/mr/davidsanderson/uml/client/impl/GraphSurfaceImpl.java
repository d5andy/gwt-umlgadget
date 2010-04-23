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

import gwt.g2d.client.graphics.KnownColor;
import gwt.g2d.client.graphics.Surface;
import gwt.g2d.client.math.Vector2;

import java.util.HashMap;

import mr.davidsanderson.uml.client.GraphEvent;
import mr.davidsanderson.uml.client.GraphEventBus;
import mr.davidsanderson.uml.client.GraphEventHandler;
import mr.davidsanderson.uml.client.GraphModel;
import mr.davidsanderson.uml.client.UMLGraph;
import mr.davidsanderson.uml.client.UMLGraphHelper;
import mr.davidsanderson.uml.client.GraphEvent.GraphEventType;
import mr.davidsanderson.uml.core.render.FontMetrics;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author dsand
 *
 */
public class GraphSurfaceImpl extends Surface {
	
	private GraphModel model;
	private UMLGraphHelper graphHelper;

	/**
	 * GraphSurface.
	 */
	@Inject
	public GraphSurfaceImpl(@Named("GraphPopupMenu") final PopupPanel popupMenu, UMLGraphHelper graphHelper,
			GraphEventBus graphEventBus, GraphModel model) {
		super(400,400);
		this.graphHelper = graphHelper;
		this.model = model;
//		setSize("100%", "100%");
		FontMetrics.initialise(getContext());
		
		
		Log.debug("GraphSurface : constructor");
		String text = "Starting....";
		
		Vector2 position = new Vector2(30, 30);
		this.setStrokeStyle(KnownColor.BLACK).strokeText(text, position)
				.setFillStyle(KnownColor.BLACK).fillText(text, position);

		Log.debug("GraphSurface : new GraphPopupMenu");
		
		addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				Log.debug("GraphSurface : onClick show popup");
				int x = event.getNativeEvent().getClientX();
				int y = event.getNativeEvent().getClientY();
				popupMenu.setPopupPosition(x, y);
				popupMenu.show();
			}
			
		});
		graphEventBus.addHandler(eventHandler, GraphEvent.getType());
	}
	
	private GraphEventHandler eventHandler = new GraphEventHandler(){

		@Override
		public void onContentChangedEvent(GraphEvent event) {
			if (event.getEventType().equals(GraphEventType.CONTENT_CHANGED)) {
				Log.debug("GraphSurface.eventHandler.onContentChangedEvent : set content and draw.");
				GraphSurfaceImpl.this.draw(event.getUmlContent());
			}
		}

		@Override
		public void onEdit(GraphEvent event) {
			// TODO Auto-generated method stub
			if (event.getEventType().equals(GraphEventType.SAVE)) {
				
				PopupPanel imagePanel = new PopupPanel();
				imagePanel.clear();
                imagePanel.add(new Image(getCanvas().toDataURL()));
                imagePanel.setAutoHideEnabled(true);
                imagePanel.show();
			}
		}

		@Override
		public void onService(GraphEvent event) {
			// TODO Auto-generated method stub
			if (event.getEventType().equals(GraphEventType.SERVICE_SUCCESS)) {
				UMLGraph graph = event.getGraph();
				if (graph.styles != null && !graph.styles.isEmpty()) {
					Log.debug("GraphSurface.eventHandler.onServiceSucess : set styles and draw.");
					GraphSurfaceImpl.this.draw(graph.styles);			
				} else {
					Log.debug("GraphSurface.eventHandler.onServiceSucess : graph.styles empty or null.");
				}
			}
		}
	};	
	
	public void draw() {
		this.draw(model.getModel(), model.getStyles());
	}
	
	public void draw(HashMap<String, String> styles) {
		draw(model.getModel(), styles);
	}
	public void draw(String modsl) {
		draw(modsl, model.getStyles());
	}
	
	public void draw(final String xmlContent, final HashMap<String, String> styles) {
		Log.debug("GraphSurface.draw");
		if (xmlContent != null && !xmlContent.equals("") && styles != null) {
			Log.debug("GraphSurface.draw clear surface");
			this.clear();
			Log.debug("GraphSurface.draw UMLGraphHelper.drawDiagram");
			graphHelper.drawDiagram(xmlContent, styles, GraphSurfaceImpl.this);
		} else if (xmlContent != null && !xmlContent.equals("")) {
			Log.debug("GraphSurface.draw : xmlContent empty or null.");
		} else if (styles != null && !styles.isEmpty()) {
			Log.debug("GraphSurface.draw : styles empty or null.");
		}
		
	}

}
