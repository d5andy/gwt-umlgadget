package mr.davidsanderson.uml.application.client;

import java.util.HashMap;

import mr.davidsanderson.uml.client.GraphEvent;
import mr.davidsanderson.uml.client.UMLGraph;
import mr.davidsanderson.uml.client.UMLGraphInjector;
import mr.davidsanderson.uml.client.GraphEvent.GraphEventType;

import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.RootPanel;

@ExportPackage("gwt")
public class UMLGraphApplication implements Exportable {
	
	private static final String origin = "mrdavidsanderson.UMLGraphApplication";
	
	@Export
	public void initalise() {
		UMLGraphInjector injector = GWT.create(UMLGraphInjector.class);
		RootPanel.get().add(injector.getGraphEventMainPanel());
		
		RootPanel params = RootPanel.get("styles.uml");
		if (params != null) {
			Log.debug("found styles.uml");
			HashMap<String, String> map = new HashMap<String, String>(); 
			NodeList<Element> elementsByTagName = params.getElement().getElementsByTagName("entry");
			for (int i = 0; i < elementsByTagName.getLength(); i++) {
				Element item = elementsByTagName.getItem(i);
				map.put(item.getAttribute("key"), item.getInnerText());
			}
			injector.getEventBus().fireEvent(new GraphEvent(origin,new UMLGraph(map), GraphEventType.SERVICE_SUCCESS));
						
		}	
		
		Log.debug("get modsl.uml");
		params = RootPanel.get("modsl.uml");
		if (params != null) {
			String value = DOM.getInnerText(params.getElement());
			
			injector.getEventBus().fireEvent(new GraphEvent(origin,value, GraphEventType.CONTENT_CHANGED));
		}
	}

}
