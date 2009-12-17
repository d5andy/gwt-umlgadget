package mr.davidsanderson.uml.application.client;

import org.timepedia.exporter.client.Exporter;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;

public class ExporterEntryPoint implements EntryPoint {

	private static final String origin = ExporterEntryPoint.class.getName();
	
	@Override
	public void onModuleLoad() {
		try {
			Exporter exporter = GWT.create(UMLGraphApplication.class);
			exporter.export();
			Window.alert("success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Window.alert(e.getMessage());
		} 

	}

}
