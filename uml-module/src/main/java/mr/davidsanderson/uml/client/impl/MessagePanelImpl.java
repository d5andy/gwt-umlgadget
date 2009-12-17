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
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.inject.Inject;

/**
 * @author dsand
 *
 */
public class MessagePanelImpl extends DockPanel implements GraphEventHandler {

	private static final String origin = MessagePanelImpl.class.getName();
	
	private static String messagePanelHtml = "<div id=\"MessagePanel\"></div>";
	private static String messageDivStart = "<div name=\"Message\">";
	private static String messageDivEnd = "</div>";
	
	private static String helpTxtStart = "<div id=\"wikicontent\" style=\"padding:0 3em 1.2em 0\">";
	private static String helpTextMid =  "<h1><a name=\"gwt-uml\"/>gwt-uml</h1><h2><a name=\"Text_to_UML_Diagram_Wave_gadget\"/>Text to UML Diagram Wave gadget</h2><p>A UML gadget based on <a href=\"http://code.google.com/p/modsl/\" rel=\"nofollow\">ModSL</a> which allows users to draw UML diagrams in Wave using the <a href=\"http://code.google.com/p/modsl/\" rel=\"nofollow\">ModSL</a> syntax for UML. </p><p>This project also makes use of several open source GWT projects: <ul><li><a href=\"https://code.google.com/p/cobogwave/\" rel=\"nofollow\">cobogwave</a>. </li><li><a href=\"https://code.google.com/p/gwt-g2d/\" rel=\"nofollow\">gwt-g2d</a>. </li><li><a href=\"https://code.google.com/p/gwtx/\" rel=\"nofollow\">gwtx</a>. </li><li><a href=\"https://code.google.com/p/gwt-log/\" rel=\"nofollow\">gwt-log</a>. </li></ul></p><p>Also makes extensive use of the google apis for Wave Gadgets and GWT. </p><p>(This conversion allows the application hosted by google app engine) </p><h2><a name=\"How-to_use:\"/>How-to use:</h2><p>The project is intended to be used in Google Wave and renders UML diagrams based on the text entered either into the Wave or directly into the Gadget. </p><p>A guide to the text based UML syntax can be found <a href=\"http://code.google.com/p/modsl/wiki/LanguageSyntax\" rel=\"nofollow\">here</a>. </p><p>The Wave Gadget is currently hosted on Google Appengine at: <a href=\"http://umlgadget.appspot.com\" rel=\"nofollow\">http://umlgadget.appspot.com</a> The Wave Robot is currently hosted on Google Appending at: <a href=\"http://umlgraphrobot.appspot.com/umlapplication/umlGraphService\" rel=\"nofollow\">http://umlgraphrobot.appspot.com/umlapplication/umlGraphService</a> </p><h3><a name=\"Use_the_Robot\"/>Use the Robot</h3><ol><li>Add the address &quot;umlgraphrobot@appspot.com&quot; as a contact </li><li>Add the contact to your wave </li><li><tt>#!UML</tt> triggers the robot into action - inserts the gadget and passes the text to the gadget to parse and render </li></ol><h3><a name=\"Use_the_Gadget\"/>Use the Gadget</h3><ol><li>Click into the wavelet then select &quot;add gadget&quot; from the wavelet tool bar. </li><li>Enter the gadget <a href=\"http://umlgadget.appspot.com\" rel=\"nofollow\">url</a> </li><li>Once the gadget is initialised right click on the gadget area and &quot;Edit ModSL UML&quot; add your UML text. </li><li><strong>Alternatively</strong> use the <a href=\"http://umlgadget.appspot.com/manifest.xml\" rel=\"nofollow\">extension installer</a> to add a link to the toolbar directly to the gadget. </li></ol><h2><a name=\"How-to_Build\"/>How-to Build</h2><ol><li>Run <tt>mvn install</tt> at the root level. </li><li>Import into Eclipse as <strong>Maven</strong> projects (use the <a href=\"http://m2eclipse.sonatype.org/update/\" rel=\"nofollow\">maven plugin</a> </li><li>From their you can configure the appengine settings and deploy to your preferred env. </li><li>If you wish to view the gadget in the google sandbox run <tt>uml-application/mvn install gwt:run</tt> </li></ol><h3><a name=\"Gotchas\"/>Gotchas</h3><ol><li>remove the gwt-dev jar from the war/lib folder before deployment to appengine </li><li>copy the gwt-log jar to the war/lib folder </li></ol><h2><a name=\"Thanks_to\"/>Thanks to</h2><p><strong><tt>gwt-gadget</tt></strong> is based on <strong><tt>ModSL</tt></strong> project, so thanks to the project and its team. </p>"; 
	private static String helpTextEnd =  "</div>";

	private HTMLPanel htmlPanel;
	
	private GraphEventBus graphEventBus;

	/**
	 * @param graphEventBus
	 */
	@Inject
	public MessagePanelImpl(final GraphEventBus graphEventBus) {	
		this.graphEventBus = graphEventBus;
		HorizontalPanel buttonPanel = new HorizontalPanel();
		buttonPanel.setHorizontalAlignment(HorizontalPanel.ALIGN_RIGHT);
		buttonPanel.setSpacing(10);
		Button okBtn = new Button(new HTML("Ok").toString(),
				new ClickHandler() {

					@Override
					public void onClick(ClickEvent arg0) {
						
						Log.debug("MessagePanel.okBtn.onClick : fire event close editor");
						graphEventBus.fireEvent(new GraphEvent(origin, GraphEventType.MSG_CLOSE));
						Log.debug("MessagePanel.okBtn.onClick : fire content changed");
					}
				});
		Button clearBtn = new Button(new HTML("Clear").toString(),
				new ClickHandler() {
					public void onClick(ClickEvent arg0) {
						Log.debug("MessagePanel.Clear.onClick : clears");
						clear();
					}
				});
		Button helpBtn = new Button(new HTML("Help").toString(),
				new ClickHandler() {
					public void onClick(ClickEvent arg0) {
						
						Log.debug("MessagePanel.Help.onClick : show help");
						addMessage(helpTxtStart + helpTextMid + helpTextEnd);
					}
				});
		buttonPanel.add(okBtn);
		buttonPanel.add(clearBtn);		
		buttonPanel.add(helpBtn);		
		
		
		htmlPanel = new HTMLPanel(messagePanelHtml);
		htmlPanel.setSize("100%", "100%");
		
		this.add(htmlPanel, DockPanel.CENTER);
		this.add(buttonPanel, DockPanel.SOUTH);
		this.setCellHorizontalAlignment(buttonPanel, DockPanel.ALIGN_CENTER);
		this.setCellVerticalAlignment(buttonPanel, DockPanel.ALIGN_BOTTOM);
		this.setCellHeight(htmlPanel, "99%");
		this.setCellHorizontalAlignment(htmlPanel, DockPanel.ALIGN_LEFT);
		this.setCellVerticalAlignment(htmlPanel, DockPanel.ALIGN_MIDDLE);		
		
		addMessage(messageDivStart + "Welcome begin modelling by clicking ok." + messageDivEnd);
	}
	
	public void addMessage(String msg) {
		Element elementById = htmlPanel.getElementById("MessagePanel");
		String innerHTML = elementById.getInnerHTML();
		innerHTML += msg;
		elementById.setInnerHTML(innerHTML);
	}
	
	public void clear() {
		Element elementById = htmlPanel.getElementById("MessagePanel");
		elementById.setInnerHTML("");
		Log.debug("MessagePanel.clear : clear messages.");
		graphEventBus.fireEvent(new GraphEvent(origin, GraphEventType.MSG_CLEAR));
	}

	/* (non-Javadoc)
	 * @see mr.davidsanderson.uml.client.GraphEventHandler#onContentChangedEvent(mr.davidsanderson.uml.client.GraphEvent)
	 */
	@Override
	public void onContentChangedEvent(GraphEvent event) {
		// TODO Auto-generated method stub
		switch(event.getEventType()) {
		case MSG_ADD: case MSG_LOAD: 
			addMessage(messageDivStart + event.getUmlContent() + messageDivEnd);
			break;
		default : 
			break;
		}
		
	}

	/* (non-Javadoc)
	 * @see mr.davidsanderson.uml.client.GraphEventHandler#onEdit(mr.davidsanderson.uml.client.GraphEvent)
	 */
	@Override
	public void onEdit(GraphEvent event) {
	}

	/* (non-Javadoc)
	 * @see mr.davidsanderson.uml.client.GraphEventHandler#onService(mr.davidsanderson.uml.client.GraphEvent)
	 */
	@Override
	public void onService(GraphEvent event) {
		if (event.getEventType().equals(GraphEventType.SERVICE_FAIL)) {
			addMessage("ERROR : call failed");
		}
		
	}

}