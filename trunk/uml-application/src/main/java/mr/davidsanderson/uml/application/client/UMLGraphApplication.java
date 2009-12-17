package mr.davidsanderson.uml.application.client;

import mr.davidsanderson.uml.client.GraphEvent;
import mr.davidsanderson.uml.client.RetrieveServer;
import mr.davidsanderson.uml.client.UMLGraphInjector;
import mr.davidsanderson.uml.client.UMLGraphService;
import mr.davidsanderson.uml.client.UMLGraphServiceAsync;
import mr.davidsanderson.uml.client.GraphEvent.GraphEventType;

import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.RootPanel;

@ExportPackage("gwt")
@Export
public class UMLGraphApplication implements Exportable {
	
	private static final String origin = "mrdavidsanderson.UMLGraphApplication";
	
	@Export
	public void initalise() {
		UMLGraphInjector injector = GWT.create(UMLGraphInjector.class);
		RootPanel.get().add(injector.getGraphEventMainPanel());
		RetrieveServer retriever = injector.getRetriever();
		retriever.init((UMLGraphServiceAsync)GWT.create(UMLGraphService.class));
		
		Log.debug("get modsl.uml");
		RootPanel params = RootPanel.get("modsl.uml");
		if (params != null) {
			String value = DOM.getInnerText(params.getElement());
			
			injector.getEventBus().fireEvent(new GraphEvent(origin,value, GraphEventType.CONTENT_CHANGED));
		}
		
	}

}
