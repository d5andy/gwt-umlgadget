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
package mr.davidsanderson.uml.wave.gadget;

import mr.davidsanderson.uml.client.GraphMainPanel;
import mr.davidsanderson.uml.client.RetrieveServer;
import mr.davidsanderson.uml.client.UMLGraphService;
import mr.davidsanderson.uml.client.UMLGraphServiceAsync;

import org.cobogw.gwt.waveapi.gadget.client.WaveGadget;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.GWT;
import com.google.gwt.gadgets.client.Gadget;
import com.google.gwt.gadgets.client.UserPreferences;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
@Gadget.ModulePrefs(title = "umlgadget", height = 400)
public class UMLGraphGadget extends WaveGadget<UserPreferences> {


	@Override
	protected void init(UserPreferences preferences) {
		
		Log.debug("UMLGraphGadget.init : create UI");
		RootPanel.get().add(new GraphMainPanel());
		Log.debug("UMLGraphGadget.init : new RetrieveServer");
		new RetrieveServer((UMLGraphServiceAsync) GWT.create(UMLGraphService.class));
		Log.debug("UMLGraphGadget.init : new WaveStateHandler");
		new WaveStateHandler(getWave());
	}

	static {
		disableStats();
	}


	private static native void disableStats() /*-{
		$wnd.$stats = null;
	}-*/;

}
