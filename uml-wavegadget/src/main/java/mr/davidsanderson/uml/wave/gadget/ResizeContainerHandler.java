package mr.davidsanderson.uml.wave.gadget;



import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.gadgets.client.DynamicHeightFeature;

import mr.davidsanderson.uml.client.GraphEvent;
import mr.davidsanderson.uml.client.GraphEventBus;
import mr.davidsanderson.uml.client.GraphEventHandler;
import mr.davidsanderson.uml.client.GraphEvent.GraphEventType;

public class ResizeContainerHandler implements GraphEventHandler {
	DynamicHeightFeature feature;
	
	public ResizeContainerHandler(DynamicHeightFeature feature) {
		this.feature = feature;
		GraphEventBus.get().addHandler(this, GraphEvent.getType());
	}

	@Override
	public void onContentChangedEvent(GraphEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEdit(GraphEvent event) {
		// TODO Auto-generated method stub
		if (event.getEventType().equals(GraphEventType.GRAPH_RESIZE)) {
			Log.debug("Resize the root Panel");
//			feature.getContentDiv().setPixelSize(event.getWidth(), event.getHeight());
//			feature.getContentDiv().setSize("100%", "100%");
			feature.adjustHeight();			
		} else {
			Log.debug("Miss " + event.getEventType());
		}
		
	}

	@Override
	public void onService(GraphEvent event) {
		// TODO Auto-generated method stub
		
	}

}
