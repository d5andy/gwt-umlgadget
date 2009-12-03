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

import mr.davidsanderson.uml.client.GraphEvent.GraphEventType;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.PopupPanel;

/**
 * @author dsand
 *
 */
public class GraphPopupMenu extends PopupPanel {
	
	private static final String origin = GraphPopupMenu.class.getName();
	
	/**
	 * constructor.
	 */
	public GraphPopupMenu() {
		super(true);
		Log.debug("GraphPopupMenu : constructor");
		this.setStyleName("popup");
		MenuBar popupMenuBar = new MenuBar(true);
		MenuItem alertItem = new MenuItem("Show ModSL UML", true, new Command() {

			@Override
			public void execute() {
				Log.debug("GraphPopupMenu : show ModSL UML fire event.");
				GraphEventBus.get().fireEvent(new GraphEvent(origin, GraphEventType.EDITOR_OPEN));
				Log.debug("GraphPopupMenu : show ModSL UML hide.");
				GraphPopupMenu.this.hide();
			}
			
		});
		alertItem.addStyleName("popup-item");
		popupMenuBar.addItem(alertItem);
		popupMenuBar.setVisible(true);
		this.add(popupMenuBar);
				
	}

}
