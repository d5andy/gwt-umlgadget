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

import java.util.HashMap;

import mr.davidsanderson.uml.client.GraphEvent;
import mr.davidsanderson.uml.client.GraphEventBus;
import mr.davidsanderson.uml.client.GraphEventHandler;
import mr.davidsanderson.uml.client.GraphEvent.GraphEventType;

import org.cobogw.gwt.waveapi.gadget.client.StateUpdateEvent;
import org.cobogw.gwt.waveapi.gadget.client.StateUpdateEventHandler;
import org.cobogw.gwt.waveapi.gadget.client.WaveFeature;

import com.allen_sauer.gwt.log.client.Log;
import com.google.inject.Inject;

/**
 * @author dsand
 *
 */
public class WaveStateHandler implements StateUpdateEventHandler {
	private static final String origin = WaveStateHandler.class.getName();
	private static final String umlKey = "uml";
	private static final String stylesKey = "styles";
	private static final String demo = "class diagram self {\n" +
	"\t abstract class AbstractElement {\n " +
	"\t\tname;\n\t\tparent;\n\t\ttype;\n\t\tabstract accept(AbstractVisitor);\n\t}\n" +
	"\tabstract class AbstractBox extends AbstractElement {\n" +
	"\t\tpos; \n\t\tdisp; \n\t\tsize;\n\t}\n	" +
	"\tclass Edge extends AbstractElement {\n" +
	"\t\tlabels;\n\t\tbends;\n\t\tnode1; \n\t\tnode2;\n\t}\n	" +
	"\n\tclass Bend extends AbstractBox {	}\n" +
	"\tclass Graph extends AbstractBox {\n\t\treqSize; \n\t\tlabels; " +
	"\n\t\t1->*(Edge); \n\t\t1->*(Node);\n\t}\n	" +
	"\tclass Node extends AbstractBox {\n\t\tconnectedEdges; \n\t\tlabels;	\n\t}\n}\n";	
	
	private WaveFeature waveFeature;
	private GraphEventBus graphEventBus;
	/**
	 * @param waveFeature : WaveFeature
	 */
	@Inject
	public WaveStateHandler(GraphEventBus graphEventBus) {
		Log.debug("WaveStateHandler : constructor.");
		this.graphEventBus = graphEventBus;
		graphEventBus.addHandler(eventHandler, GraphEvent.getType());
	}
	
	public void init(WaveFeature waveFeature) {
		this.waveFeature = waveFeature;
		waveFeature.addStateUpdateEventHandler(this);
		Log.debug("WaveStateHandler : waveFeature.getState");
		String uml = waveFeature.getState().get(umlKey);
		if (uml != null && !uml.equals("")) {
			Log.debug("WaveStateHandler : Found state");
			fireContentChanged(uml);
		} else if (uml == null) {
			Log.debug("WaveStateHandler : Submit demo state");
			waveFeature.getState().submitValue(umlKey, demo);
		}
	}

	/* (non-Javadoc)
	 * @see org.cobogw.gwt.waveapi.gadget.client.StateUpdateEventHandler#onUpdate(org.cobogw.gwt.waveapi.gadget.client.StateUpdateEvent)
	 */
	@Override
	public void onUpdate(StateUpdateEvent event) {
		Log.debug("WaveStateHandler.onUpdate : received state event");
		String uml = this.waveFeature.getState().get(umlKey);
		fireContentChanged(uml);
		
	}
	
	private void fireContentChanged(String uml) {
		graphEventBus.fireEvent(new GraphEvent(origin, uml, GraphEventType.CONTENT_CHANGED));
	}
	
	private GraphEventHandler eventHandler = new GraphEventHandler(){

		@Override
		public void onContentChangedEvent(GraphEvent event) {
			Log.debug("WaveStateHandler.eventHandler.onContentChangedEvent : hit");
			if (!event.getOrigin().equals(WaveStateHandler.origin)) {
				if (waveFeature != null) {
					
					Log.debug("WaveStateHandler.eventHandler.onContentChangedEvent : wasn't me");
					String content = waveFeature.getState().get(umlKey);
					if (content != null) {
						Log.debug("WaveStateHandler.eventHandler.onContentChangedEvent : submit delta");
						HashMap<String, String> map = new HashMap<String, String>();
						map.put(umlKey, event.getUmlContent());					
						waveFeature.getState().submitDelta(map);
					} else {
						Log.debug("WaveStateHandler.eventHandler.onContentChangedEvent : submit value");
						waveFeature.getState().submitValue(umlKey, event.getUmlContent());
					}
				} else {
					Log.debug("WaveStateHandler.eventHandler.onContentChangedEvent : wave feature not enabled");
				}
			}
		}

		@Override
		public void onEdit(GraphEvent event) {
			// Not interested...
		}

		@Override
		public void onService(GraphEvent event) {
			if (event.getEventType().equals(GraphEventType.SERVICE_SUCCESS)) {
				HashMap<String, String> styles = event.getGraph().getStyles();
				// do something here...
			}
			
			
		}
		
	};	

}
