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
package mr.davidsanderson.uml.wave.gadget;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.gadgets.client.DynamicHeightFeature;
import com.google.inject.Inject;

import mr.davidsanderson.uml.client.GraphEvent;
import mr.davidsanderson.uml.client.GraphEventBus;
import mr.davidsanderson.uml.client.GraphEventHandler;
import mr.davidsanderson.uml.client.GraphEvent.GraphEventType;

/**
 * @author dsand
 *
 */
public class ResizeContainerHandler implements GraphEventHandler {
	DynamicHeightFeature feature;

	@Inject
	public ResizeContainerHandler(GraphEventBus graphEventBus) {
		graphEventBus.addHandler(this, GraphEvent.getType());
	}
	
	public void init(DynamicHeightFeature feature) {
		this.feature = feature;
	}

	@Override
	public void onContentChangedEvent(GraphEvent event) {
	}

	@Override
	public void onEdit(GraphEvent event) {
		if (feature != null) {
			if (event.getEventType().equals(GraphEventType.GRAPH_RESIZE)) {
				Log.debug("Resize the root Panel");
				feature.adjustHeight();			
			} else {
				Log.debug("Miss " + event.getEventType());
			}
			
		} else {
			Log.debug("feature not enabled " + event.getEventType());
		}
		
	}

	@Override
	public void onService(GraphEvent event) {
	}

}
