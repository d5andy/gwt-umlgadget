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

import mr.davidsanderson.uml.client.GraphEvent;
import mr.davidsanderson.uml.client.GraphEventBus;
import mr.davidsanderson.uml.client.GraphEvent.GraphEventType;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.inject.Inject;

public class GraphPopupMenuImpl  extends PopupPanel {

private static final String origin = GraphPopupMenuImpl.class.getName();

/**
 * constructor.
 */
@Inject
public GraphPopupMenuImpl(final GraphEventBus graphEventBus) {
	super(true);
	Log.debug("GraphPopupMenu : constructor");
	this.setStyleName("popup");
	MenuBar popupMenuBar = new MenuBar(true);
	MenuItem alertItem = new MenuItem("Edit ModSL UML", true, new Command() {

		@Override
		public void execute() {
			Log.debug("GraphPopupMenu : show ModSL UML fire event.");
			graphEventBus.fireEvent(new GraphEvent(origin, GraphEventType.EDITOR_OPEN));
			Log.debug("GraphPopupMenu : show ModSL UML hide.");
			GraphPopupMenuImpl.this.hide();
		}
		
	});
	alertItem.addStyleName("popup-item");
	popupMenuBar.addItem(alertItem);
	MenuItem saveItem = new MenuItem("Save as image", true, new Command() {

		@Override
		public void execute() {
			Log.debug("GraphPopupMenu : show ModSL UML fire event.");
			graphEventBus.fireEvent(new GraphEvent(origin, GraphEventType.SAVE));
			Log.debug("GraphPopupMenu : show ModSL UML hide.");
			GraphPopupMenuImpl.this.hide();
		}
		
	});
	saveItem.addStyleName("popup-item");
//	popupMenuBar.addItem(saveItem);
	MenuItem msgItem = new MenuItem("Help - View Messages", true, new Command() {

		@Override
		public void execute() {
			Log.debug("GraphPopupMenu : show ModSL UML fire event.");
			graphEventBus.fireEvent(new GraphEvent(origin, GraphEventType.MSG_OPEN));
			Log.debug("GraphPopupMenu : show ModSL UML hide.");
			GraphPopupMenuImpl.this.hide();
		}
		
	});
	msgItem.addStyleName("popup-item");
	popupMenuBar.addItem(msgItem);		
	popupMenuBar.setVisible(true);
	this.add(popupMenuBar);
			
}

}