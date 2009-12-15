package mr.davidsanderson.uml.client;

import mr.davidsanderson.uml.client.impl.GraphMainPanelImpl;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

@GinModules(UMLGraphClientModule.class)
public interface UMLGraphInjector extends Ginjector {
	
	GraphMainPanelImpl getGraphEventMainPanel();
	
	RetrieveServer getRetriever();
	
	GraphEventBus getEventBus();
	
	UMLGraphServiceAsync getGraphService();
	
	

}
