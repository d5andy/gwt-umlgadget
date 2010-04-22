package mr.davidsanderson.uml.application.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;

public class ExporterEntryPoint implements EntryPoint {

//	private static final String origin = ExporterEntryPoint.class.getName();
	
	@Override
	public void onModuleLoad() {
		try {
//			UMLGraphApplication application = new UMLGraphApplication();
//			application.initalise();
			GWT.create(UMLGraphApplication.class);
//			ExporterUtil.exportAll();
//			Exporter exporter = 
//			exporter.export();
			Window.alert("success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Window.alert(e.getMessage());
		} 

	}

}
