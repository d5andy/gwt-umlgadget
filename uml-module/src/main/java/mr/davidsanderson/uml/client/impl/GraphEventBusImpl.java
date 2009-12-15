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

import mr.davidsanderson.uml.client.GraphEventBus;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.GwtEvent.Type;

/**
 * @author dsand
 *
 */
public class GraphEventBusImpl implements GraphEventBus {
	private HandlerManager handlerManager;

	/**
	 * 
	 */
	public GraphEventBusImpl() {
		Log.debug("GraphEventBusImpl : Create");
	}

	/**
	 * Adds this handler to the widget.
	 * 
	 * @param the
	 *            type of handler to add
	 * @param type
	 *            the event type
	 * @param handler
	 *            the handler
	 * @return {@link HandlerRegistration} used to remove the handler
	 */
	// copied from GWT 1.6 Widget
	public final <H extends EventHandler> HandlerRegistration addHandler(
			final H handler, Type<H> type) {
		return ensureHandlers().addHandler(type, handler);
	}

	/**
	 * Ensures the existence of the handler manager.
	 * 
	 * @return the handler manager
	 * */
	// copied from GWT 1.6 Widget
	private HandlerManager ensureHandlers() {
		return handlerManager == null ? handlerManager = new HandlerManager(
				this) : handlerManager;
	}

	/**
	 * Fire an event.
	 */
	public void fireEvent(GwtEvent<?> event) {
		ensureHandlers().fireEvent(event);
	}

}
