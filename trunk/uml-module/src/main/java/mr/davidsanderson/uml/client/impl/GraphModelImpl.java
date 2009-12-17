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

import java.util.HashMap;

import mr.davidsanderson.uml.client.GraphEvent;
import mr.davidsanderson.uml.client.GraphEventBus;
import mr.davidsanderson.uml.client.GraphEventHandler;
import mr.davidsanderson.uml.client.GraphModel;
import mr.davidsanderson.uml.client.UMLGraph;
import mr.davidsanderson.uml.client.GraphEvent.GraphEventType;

import com.google.inject.Inject;

/**
 * @author dsand
 * 
 */
public class GraphModelImpl implements GraphModel, GraphEventHandler {

	private HashMap<String, String> styles;
	private String uml;

	/**
	 * GraphModelImpl.
	 * 
	 * @param graphEventBus
	 */
	@Inject
	public GraphModelImpl(GraphEventBus graphEventBus) {
		graphEventBus.addHandler(this, GraphEvent.getType());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mr.davidsanderson.uml.client.GraphModel#getModel()
	 */
	@Override
	public String getModel() {
		// TODO Auto-generated method stub
		return uml;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mr.davidsanderson.uml.client.GraphModel#getStyles()
	 */
	@Override
	public HashMap<String, String> getStyles() {
		// TODO Auto-generated method stub
		return styles;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mr.davidsanderson.uml.client.GraphEventHandler#onContentChangedEvent(
	 * mr.davidsanderson.uml.client.GraphEvent)
	 */
	@Override
	public void onContentChangedEvent(GraphEvent event) {
		if (event.getEventType().equals(GraphEventType.CONTENT_CHANGED)) {
			this.uml = event.getUmlContent();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mr.davidsanderson.uml.client.GraphEventHandler#onEdit(mr.davidsanderson
	 * .uml.client.GraphEvent)
	 */
	@Override
	public void onEdit(GraphEvent event) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mr.davidsanderson.uml.client.GraphEventHandler#onService(mr.davidsanderson
	 * .uml.client.GraphEvent)
	 */
	@Override
	public void onService(GraphEvent event) {
		if (event.getEventType().equals(GraphEventType.SERVICE_SUCCESS)) {
			UMLGraph graph = event.getGraph();
			if (graph.styles != null && !graph.styles.isEmpty()) {
				this.styles = graph.styles;
			}
		}
	}

}
