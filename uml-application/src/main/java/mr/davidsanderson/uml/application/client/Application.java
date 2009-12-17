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
package mr.davidsanderson.uml.application.client;


import com.google.gwt.core.client.EntryPoint;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Application implements EntryPoint {
	
	private static final String origin = Application.class.getName();

	static String demo = "class diagram self {\n"
			+ "\t abstract class AbstractElement {\n "
			+ "\t\tname;\n\t\tparent;\n\t\ttype;\n\t\tabstract accept(AbstractVisitor);\n\t}\n"
			+ "\tabstract class AbstractBox extends AbstractElement {\n"
			+ "\t\tpos; \n\t\tdisp; \n\t\tsize;\n\t}\n	"
			+ "\tclass Edge extends AbstractElement {\n"
			+ "\t\tlabels;\n\t\tbends;\n\t\tnode1; \n\t\tnode2;\n\t}\n	"
			+ "\n\tclass Bend extends AbstractBox {	}\n"
			+ "\tclass Graph extends AbstractBox {\n\t\treqSize; \n\t\tlabels; "
			+ "\n\t\t1->*(Edge); \n\t\t1->*(Node);\n\t}\n	"
			+ "\tclass Node extends AbstractBox {\n\t\tconnectedEdges; \n\t\tlabels;	\n\t}\n}\n";

	public void onModuleLoad() {
		new UMLGraphApplication().initalise();
	}

}