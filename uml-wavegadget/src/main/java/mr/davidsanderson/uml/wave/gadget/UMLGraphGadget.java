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

import mr.davidsanderson.uml.client.RetrieveServer;
import mr.davidsanderson.uml.client.UMLGraphService;
import mr.davidsanderson.uml.client.UMLGraphServiceAsync;

import org.cobogw.gwt.waveapi.gadget.client.WaveGadget;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.GWT;
import com.google.gwt.gadgets.client.DynamicHeightFeature;
import com.google.gwt.gadgets.client.Gadget;
import com.google.gwt.gadgets.client.NeedsDynamicHeight;
import com.google.gwt.gadgets.client.UserPreferences;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
@Gadget.ModulePrefs(title = "umlgadget", height = 400)
public class UMLGraphGadget extends WaveGadget<UserPreferences> implements
		NeedsDynamicHeight {
	DynamicHeightFeature feature;

	@Override
	protected void init(UserPreferences preferences) {
		Log.debug("UMLGraphGadget.init : create UI");
		UMLGraphGadgetInjector injector = GWT
				.create(UMLGraphGadgetInjector.class);

		ResizeContainerHandler resizeContainer = injector.getResizeContainer();
		resizeContainer.init(feature);

		RetrieveServer retriever = injector.getRetriever();
		Log.debug("UMLGraphGadget.init : new RetrieveServer");
		retriever
				.init((UMLGraphServiceAsync) GWT.create(UMLGraphService.class));

		
		feature.getContentDiv().add(injector.getGraphEventMainPanel());

		WaveStateHandler waveStateHandler = injector.getWaveStateHandler();
		Log.debug("UMLGraphGadget.init : new WaveStateHandler");
		waveStateHandler.init(getWave());
	}

	static {
		disableStats();
	}

	private static native void disableStats() /*-{
		$wnd.$stats = null;
	}-*/;

	@Override
	public void initializeFeature(DynamicHeightFeature feature) {
		// TODO Auto-generated method stub
		this.feature = feature;
	}

}
