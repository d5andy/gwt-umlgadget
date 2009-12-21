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

import mr.davidsanderson.uml.client.GraphEventBus;
import mr.davidsanderson.uml.client.GraphModel;
import mr.davidsanderson.uml.client.RetrieveServer;
import mr.davidsanderson.uml.client.impl.GraphMainPanelImpl;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

/**
 * @author dsand
 *
 */
@GinModules(UMLGraphGadgetModule.class)
public interface UMLGraphGadgetInjector extends Ginjector {
	/**
	 * get the main UI panel.
	 * @return
	 */
	GraphMainPanelImpl getGraphEventMainPanel();
	
	
	/**
	 * get the RPC server retriever implementation.
	 * @return
	 */
	RetrieveServer getRetriever();
	
	/**
	 * Get the application event bus. 
	 * @return
	 */
	GraphEventBus getEventBus();
	
	/**
	 * get the graph data model.
	 * @return
	 */
	GraphModel getGraphModel();
	
	/**
	 * @return
	 */
	ResizeContainerHandler getResizeContainer();
	
	/**
	 * @return
	 */
	WaveStateHandler getWaveStateHandler();

}
