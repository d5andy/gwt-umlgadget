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

/**
 * @author dsand
 *
 */
public class UMLGraphClientModule extends AbstractGinModule {

	/* (non-Javadoc)
	 * @see com.google.gwt.inject.client.AbstractGinModule#configure()
	 */
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

	}

}
