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
package mr.davidsanderson.uml.core.render;

import gwt.g2d.client.graphics.canvas.Context;

public class FontMetrics {

	private static FontMetrics instance;
	private Context canvas;

	private FontMetrics(Context canvas) {
		this.canvas = canvas;
	}
	
	public static void initialise(Context canvas) {
		instance = new FontMetrics(canvas);
	}
	
	public static double getStringLength(String measureTxt, String font) {
		if (instance != null) {
			instance.canvas.setFont(font);
			return instance.canvas.measureText(measureTxt);
		}
		return 0.0;
	}
	
	
	


}
