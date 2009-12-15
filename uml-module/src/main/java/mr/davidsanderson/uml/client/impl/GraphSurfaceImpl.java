package mr.davidsanderson.uml.client.impl;

import gwt.g2d.client.graphics.KnownColor;
import gwt.g2d.client.graphics.Surface;
import gwt.g2d.client.math.Vector2;

import java.util.Map;

import mr.davidsanderson.uml.client.GraphEvent;
import mr.davidsanderson.uml.client.GraphEventBus;
import mr.davidsanderson.uml.client.GraphEventHandler;
import mr.davidsanderson.uml.client.UMLGraph;
import mr.davidsanderson.uml.client.UMLGraphHelper;
import mr.davidsanderson.uml.client.GraphEvent.GraphEventType;
import mr.davidsanderson.uml.core.render.FontMetrics;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.inject.Inject;
import com.google.inject.name.Named;

public class GraphSurfaceImpl extends Surface {
	
	private static final String origin = GraphSurfaceImpl.class.getName();
	
	private String xmlContent;
	private Map<String, String> styles;
	
	private GraphEventBus graphEventBus;
	private UMLGraphHelper graphHelper;

	/**
	 * GraphSurface.
	 */
	@Inject
	public GraphSurfaceImpl(@Named("GraphPopupMenu") final PopupPanel popupMenu, UMLGraphHelper graphHelper,
			GraphEventBus graphEventBus			
			) {
		super(400,400);
		this.graphEventBus = graphEventBus;
		this.graphHelper = graphHelper;
//		setSize("100%", "100%");
		FontMetrics.initialise(getCanvas());
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
			Log.debug("GraphSurface.eventHandler.onContentChangedEvent : set content and draw.");
			GraphSurfaceImpl.this.xmlContent = event.getUmlContent(); 
			GraphSurfaceImpl.this.draw();
		}

		@Override
		public void onEdit(GraphEvent event) {
			// TODO Auto-generated method stub
			if (event.getEventType().equals(GraphEventType.SAVE)) {
				Window.alert("To be implemented");
//				Window.open(getCanvas()., arg1, arg2)
			}
			
		}

		@Override
		public void onService(GraphEvent event) {
			// TODO Auto-generated method stub
			if (event.getEventType().equals(GraphEventType.SERVICE_SUCCESS)) {
				UMLGraph graph = event.getGraph();
				if (graph.styles != null && !graph.styles.isEmpty()) {
					Log.debug("GraphSurface.eventHandler.onServiceSucess : set styles and draw.");
					GraphSurfaceImpl.this.styles = graph.styles; 
					GraphSurfaceImpl.this.draw();			
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
			graphHelper.drawDiagram(xmlContent, styles, this);
			int height = this.getHeight();
			int width = this.getWidth();
			Log.debug("GraphSurface.draw " + width + "width "+ height + " height");
			graphEventBus.fireEvent(new GraphEvent(origin, GraphEventType.GRAPH_RESIZE, height, width));
		} else if (xmlContent != null && !xmlContent.equals("")) {
			Log.debug("GraphSurface.draw : xmlContent empty or null.");
		} else if (styles != null && !styles.isEmpty()) {
			Log.debug("GraphSurface.draw : styles empty or null.");
		}
		
	}

}
