package mr.davidsanderson.uml.core.render;

import java.util.HashMap;

import org.modsl.core.agt.model.MetaType;
import org.modsl.core.cfg.PropLoader;

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

}