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
import com.google.gwt.event.shared.GwtEvent;

/**
 * @author dsand
 *
 */
public class GraphEvent extends GwtEvent<GraphEventHandler> {
	
	private static final Type<GraphEventHandler> TYPE = new Type<GraphEventHandler>();
	
	public enum GraphEventType {
		EDITOR_CLOSE, EDITOR_OPEN, GRAPH_OPEN, 
		CONTENT_CHANGED,  
		SERVICE_SUCCESS, SERVICE_FAIL, 
		GRAPH_RESIZE, 
		SAVE, 
		MSG_OPEN, MSG_CLOSE, MSG_ADD, MSG_LOAD, MSG_CLEAR
	}
	
	private String umlContent;
	private UMLGraph graph;
	private String origin;
	GraphEventType type;
	private int height;
	private int width;
	
	
	public GraphEvent(String origin, GraphEventType type) {
		this.origin = origin;
		this.type = type;
	}
	public GraphEvent(String origin, GraphEventType type, int height, int width) {
		this.origin = origin;
		this.type = type;
		this.setHeight(height);
		this.setWidth(width);
	}	
	
	public GraphEvent(String origin, String umlContent, GraphEventType type) {
		this.origin = origin;
		this.setUmlContent(umlContent);
		this.type = type;
	}
	
	public GraphEvent(String origin, UMLGraph graph, GraphEventType type) {
		this.origin = origin;
		this.setGraph(graph);
		this.type = type;
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.google.gwt.event.shared.GwtEvent#dispatch(com.google.gwt.event.shared.EventHandler)
	 */
	@Override
	protected void dispatch(GraphEventHandler handler) {
		// TODO Auto-generated method stub
		Log.debug("GraphEvent.dispatch : " + type);
		switch (type) {
		case MSG_OPEN: case MSG_CLOSE: case EDITOR_CLOSE: case EDITOR_OPEN: case GRAPH_RESIZE: case SAVE: 			
			handler.onEdit(this);
			break;
		case CONTENT_CHANGED: case MSG_ADD: case MSG_LOAD: case MSG_CLEAR: 
			handler.onContentChangedEvent(this);
			break;
		case SERVICE_FAIL: case SERVICE_SUCCESS:
			handler.onService(this);
			break;
		default:
			break;
		}
	}
	
	public GraphEventType getEventType() {
		return type;
	}
	
	public static Type<GraphEventHandler> getType() {
		return TYPE;
	}

	@Override
	public Type<GraphEventHandler> getAssociatedType() {
		// TODO Auto-generated method stub
		return TYPE;
	}

	public void setUmlContent(String umlContent) {
		this.umlContent = umlContent;
	}

	public String getUmlContent() {
		return umlContent;
	}

	public void setGraph(UMLGraph graph) {
		this.graph = graph;
	}

	public UMLGraph getGraph() {
		return graph;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getOrigin() {
		return origin;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getHeight() {
		return height;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getWidth() {
		return width;
	}
	
	

}
