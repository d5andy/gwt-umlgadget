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

import java.util.HashMap;

import com.google.gwt.user.client.rpc.IsSerializable;

public class UMLGraph implements IsSerializable {
	HashMap<String, String> styles;
	
	public UMLGraph() {
		
	}
	
	public UMLGraph(HashMap<String, String> styles) {
		super();
		this.styles = styles;
	}



	/**
	 * @return the styles
	 */
	public HashMap<String, String> getStyles() {
		return styles;
	}

	/**
	 * @param styles the styles to set
	 */
	public void setStyles(HashMap<String, String> styles) {
		this.styles = styles;
	}
	
	

}
