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
import mr.davidsanderson.uml.client.GraphEventHandler;
import mr.davidsanderson.uml.client.GraphEvent.GraphEventType;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.inject.Inject;

public class EditorPanelImpl extends DockPanel {

	private TextArea textArea;
	private static final String origin = EditorPanelImpl.class.getName();
	private boolean editing = false;
	private GraphEventBus graphEventBus;

	/**
	 * 
	 */
	@Inject
	public EditorPanelImpl(final GraphEventBus graphEventBus) {
		Log.debug("UMLEditorPanel : start");
		this.graphEventBus = graphEventBus;
		graphEventBus.addHandler(eventHandler, GraphEvent.getType());
		// set editor
		this.setSpacing(5);
		this.setSize("100%", "100%");
		this.textArea = new TextArea();
		this.textArea.setSize("100%", "100%");

		HorizontalPanel buttonPanel = new HorizontalPanel();
		buttonPanel.setHorizontalAlignment(HorizontalPanel.ALIGN_RIGHT);
		buttonPanel.setSpacing(10);

		Button okBtn = new Button(new HTML("Ok").toString(),
				new ClickHandler() {

					@Override
					public void onClick(ClickEvent arg0) {
						EditorPanelImpl.this.editing = false;
						Log.debug("UMLEditorPanel.okBtn.onClick : fire event close editor");
						graphEventBus.fireEvent(new GraphEvent(origin, GraphEventType.EDITOR_CLOSE));
						Log.debug("UMLEditorPanel.okBtn.onClick : fire content changed");
						graphEventBus.fireEvent(new GraphEvent(origin, textArea.getText(),
								GraphEventType.CONTENT_CHANGED));
					}
				});
		Button cancelBtn = new Button(new HTML("Cancel").toString(),
				new ClickHandler() {
					public void onClick(ClickEvent arg0) {
						EditorPanelImpl.this.editing = false;
						Log.debug("UMLEditorPanel.cancelBtn.onClick : fire event close editor");
						graphEventBus.fireEvent(new GraphEvent(origin, GraphEventType.EDITOR_CLOSE));
					}
				});
		buttonPanel.add(okBtn);
		buttonPanel.add(cancelBtn);

		this.add(textArea, DockPanel.CENTER);
		this.add(buttonPanel, DockPanel.SOUTH);
		this.setCellHorizontalAlignment(buttonPanel, DockPanel.ALIGN_CENTER);
		this.setCellVerticalAlignment(buttonPanel, DockPanel.ALIGN_BOTTOM);
		this.setCellHeight(textArea, "99%");
		this.setCellHorizontalAlignment(textArea, DockPanel.ALIGN_LEFT);
		this.setCellVerticalAlignment(textArea, DockPanel.ALIGN_MIDDLE);
	}
	
	private GraphEventHandler eventHandler = new GraphEventHandler(){

		@Override
		public void onContentChangedEvent(GraphEvent event) {
			Log.debug("UMLEditorPanel.eventHandler.onContentChangedEvent : set text area.");		
			
			if (editing) {
				Log.debug("UMLEditorPanel.eventHandler.onContentChangedEvent : we are editing so ignore?....");
				new EditingDialog(event.getUmlContent()).show();
			} else {
				Log.debug("UMLEditorPanel.eventHandler.onContentChangedEvent : we are not editing");
				textArea.setText(event.getUmlContent());
			}
		}

		@Override
		public void onEdit(GraphEvent event) {
			if (event.getEventType().equals(GraphEventType.EDITOR_OPEN)) {
				EditorPanelImpl.this.editing = true;
			}
		}

		@Override
		public void onService(GraphEvent event) {
		}
		
	};
	
	private class EditingDialog extends DialogBox {
		
		public EditingDialog(final String umlContent) {
			HorizontalPanel buttonPanel = new HorizontalPanel();
			buttonPanel.setHorizontalAlignment(HorizontalPanel.ALIGN_RIGHT);
			buttonPanel.setSpacing(10);
			Button yesBtn = new Button("Yes", new ClickHandler() {

				@Override
				public void onClick(ClickEvent arg0) {
					EditingDialog.this.hide();
					
					EditorPanelImpl.this.textArea.setText(umlContent);
					
				}
				
			});
			buttonPanel.add(yesBtn);
			Button noBtn = new Button("No", new ClickHandler() {

				@Override
				public void onClick(ClickEvent arg0) {
					EditingDialog.this.hide();
				}
				
			});
			buttonPanel.add(noBtn);
			
			this.add(buttonPanel);
			this.setText("The UML content has been updated, replace editor contents?");
			this.setModal(true);
		}
		
	}
	
	
		
}
