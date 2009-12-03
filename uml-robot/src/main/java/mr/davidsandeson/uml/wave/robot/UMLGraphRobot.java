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
package mr.davidsandeson.uml.wave.robot;

import java.util.List;
import java.util.logging.Logger;

//import org.apache.log4j.Logger;

import com.google.wave.api.AbstractRobotServlet;
import com.google.wave.api.Blip;
import com.google.wave.api.Event;
import com.google.wave.api.Gadget;
import com.google.wave.api.GadgetView;
import com.google.wave.api.RobotMessageBundle;
import com.google.wave.api.TextView;
import com.google.wave.api.Wavelet;


/**
 * @author dsand
 * 
 */
public class UMLGraphRobot extends AbstractRobotServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8376139623645152337L;
	Logger logger = Logger.getLogger(UMLGraphRobot.class.getName());
	static final String gadgetUrl = "http://umlgadget.appspot.com/umlapplication/org.modsl.wave.gadget.UMLGraphGadget.gadget.xml";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.wave.api.AbstractRobotServlet#processEvents(com.google.wave
	 * .api.RobotMessageBundle)
	 */
	@Override
	public void processEvents(RobotMessageBundle bundle) {
		Wavelet wavelet = bundle.getWavelet();

		if (bundle.wasSelfAdded()) {
			onRobotAdded(wavelet);
		}

		for (Event e : bundle.getBlipSubmittedEvents()) {
			
			onDocumentChanged(wavelet, e);
		}
	}

	private void onRobotAdded(Wavelet wavelet) {
		logger.info("Added to wavelet " + wavelet.getWaveId() + " " + wavelet.getWaveletId());
		Blip blip = wavelet.appendBlip();
		TextView textView = blip.getDocument();
		textView.replace("Create UML diagrams using the ModSL syntax... insert #!UML to start diagram");
	}

	private void onDocumentChanged(Wavelet wavelet, Event e) {
		logger.info("document changed " + wavelet.getWaveId() + " " + wavelet.getWaveletId());
		Blip blip = e.getBlip();
		TextView document = blip.getDocument();
		String text = document.getText();
		if (text.startsWith("#!UML")) {
			text = text.replaceFirst("#!UML", "");
			List<Blip> children = blip.getChildren();
			Gadget oldgadget = null;
			
			GadgetView gadgetView = document.getGadgetView();
			
			oldgadget = gadgetView.getGadget(gadgetUrl);
			
			logger.info("create new gadget");
			Gadget newgadget = new Gadget(gadgetUrl);
			
			if (oldgadget != null) {
				logger.info("delete");
				gadgetView.delete(oldgadget);
			} 
			logger.info("add");
			gadgetView.append(newgadget);
			
			if (newgadget != null) {
				logger.info("set uml " + text.length());
				newgadget.setField("uml", text);
			}
		}
	}

}
