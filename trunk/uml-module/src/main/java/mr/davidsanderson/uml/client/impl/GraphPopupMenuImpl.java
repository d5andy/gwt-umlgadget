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
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class GraphPopupMenuImpl extends PopupPanel {

	private static final String origin = GraphPopupMenuImpl.class.getName();

	interface MyUiBinder extends UiBinder<Widget, GraphPopupMenuImpl> {
	}

	private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);
	@UiField
	MenuItem edit;
	@UiField
	MenuItem image;
	@UiField
	MenuItem msgs;
	GraphEventBus graphEventBus;

	/**
	 * constructor.
	 */
	@Inject
	public GraphPopupMenuImpl(final GraphEventBus graphEventBus) {
		super(true);
		this.graphEventBus = graphEventBus;
		this.setStyleName("popup");
		setWidget(uiBinder.createAndBindUi(this));
		edit.setCommand(editCommand);
		image.setCommand(imageCommand);
		msgs.setCommand(msgsCommand);
	}
	
	Command editCommand = new Command() {

		@Override
		public void execute() {
			Log.debug("GraphPopupMenu : show ModSL UML fire event.");
			graphEventBus.fireEvent(new GraphEvent(origin,
					GraphEventType.EDITOR_OPEN));
			Log.debug("GraphPopupMenu : show ModSL UML hide.");
			GraphPopupMenuImpl.this.hide();
		}
		
	};
	Command imageCommand = new Command() {

		@Override
		public void execute() {
			Log.debug("GraphPopupMenu : show ModSL UML fire event.");
			graphEventBus.fireEvent(new GraphEvent(origin, GraphEventType.SAVE));
			Log.debug("GraphPopupMenu : show ModSL UML hide.");
			GraphPopupMenuImpl.this.hide();
		}
		
	};
	Command msgsCommand = new Command() {

		@Override
		public void execute() {
			Log.debug("GraphPopupMenu : show ModSL UML fire event.");
			graphEventBus.fireEvent(new GraphEvent(origin, GraphEventType.MSG_OPEN));
			Log.debug("GraphPopupMenu : show ModSL UML hide.");
			GraphPopupMenuImpl.this.hide();
		}
		
	};	

}