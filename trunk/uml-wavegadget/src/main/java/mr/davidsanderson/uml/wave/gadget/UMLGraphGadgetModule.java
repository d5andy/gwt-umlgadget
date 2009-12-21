package mr.davidsanderson.uml.wave.gadget;

import mr.davidsanderson.uml.client.GraphEventBus;
import mr.davidsanderson.uml.client.GraphModel;
import mr.davidsanderson.uml.client.RetrieveServer;
import mr.davidsanderson.uml.client.UMLGraphHelper;
import mr.davidsanderson.uml.client.impl.EditorPanelImpl;
import mr.davidsanderson.uml.client.impl.GraphEventBusImpl;
import mr.davidsanderson.uml.client.impl.GraphMainPanelImpl;
import mr.davidsanderson.uml.client.impl.GraphModelImpl;
import mr.davidsanderson.uml.client.impl.GraphPopupMenuImpl;
import mr.davidsanderson.uml.client.impl.GraphSurfaceImpl;
import mr.davidsanderson.uml.client.impl.MessagePanelImpl;
import mr.davidsanderson.uml.client.impl.UMLGraphHelperImpl;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Singleton;
import com.google.inject.name.Names;

public class UMLGraphGadgetModule extends AbstractGinModule {
	
	@Override
	protected void configure() {
		bind(GraphEventBus.class).to(GraphEventBusImpl.class).in(Singleton.class);
		bind(UMLGraphHelper.class).to(UMLGraphHelperImpl.class).in(Singleton.class);
		bind(GraphModel.class).to(GraphModelImpl.class).in(Singleton.class);
		bind(GraphMainPanelImpl.class).in(Singleton.class);
		
		bind(Widget.class).annotatedWith(Names.named("GraphSurface")).to(GraphSurfaceImpl.class);
		bind(Widget.class).annotatedWith(Names.named("UMLEditorPanel")).to(EditorPanelImpl.class);
		bind(Widget.class).annotatedWith(Names.named("MessagePanel")).to(MessagePanelImpl.class);
		bind(PopupPanel.class).annotatedWith(Names.named("GraphPopupMenu")).to(GraphPopupMenuImpl.class);
		bind(RetrieveServer.class);		
		bind(WaveStateHandler.class);
		bind(ResizeContainerHandler.class);
		
	}

}
