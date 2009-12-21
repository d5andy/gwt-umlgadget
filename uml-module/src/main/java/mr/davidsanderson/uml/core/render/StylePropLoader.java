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

import java.util.HashMap;

import org.modsl.core.agt.model.MetaType;
import org.modsl.core.cfg.PropLoader;

/**
 * @author dsand
 *
 */
public class StylePropLoader extends StyleLoader {
	
	PropLoader propLoader;

	public StylePropLoader() {
		super();
	}

	public void load(String path, String name, Class<? extends MetaType> metaTypeClass) {
	
		propLoader = new PropLoader(path, name, true);
	    propLoader.load();
	
	    load(metaTypeClass, propLoader.getProps());
	
	}
	
	public HashMap<String, String> getProps() {
		return propLoader.getProps();		
	}
	
//	public static void main(String[] args) {
//		StylePropLoader stl = new StylePropLoader();
//		stl.load("cfg/uml:cfg", "uml", UMLMetaType.class);
//		try {
//			stl.propLoader.p.storeToXML(new FileOutputStream(File.createTempFile("styles", "uml")), "");
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}