package mr.davidsanderson.uml.wave.linker;

import java.io.File;

import com.google.gwt.core.ext.LinkerContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.linker.ArtifactSet;
import com.google.gwt.core.ext.linker.impl.StandardGeneratedResource;
import com.google.gwt.core.linker.XSLinker;
import com.google.gwt.gadgets.linker.GadgetLinker;
import com.google.gwt.gadgets.rebind.GadgetGenerator;

public final class GadgetLinkerGWT16 extends XSLinker {

	private final GadgetLinker gadgetLinker = new GadgetLinker();

	@Override
	public ArtifactSet link(TreeLogger logger, LinkerContext context,
			ArtifactSet artifacts) throws UnableToCompleteException {

		// Our eventually modified Artifact Set
		ArtifactSet as = new ArtifactSet(artifacts);

		// We are in the war directory, here we can refer 
		// to the module folder only using the module name.
		File moduleFolder = new File(context.getModuleName());

		// If we are compiling outside the Shell, this directory doesn't
		// exist
		if(moduleFolder.exists() && moduleFolder.isDirectory()) {
			// Look for the gadget manifest file into the module folder
			// generated during the compile phase.
			// This need a compile done before the first time the Shell
			// is launched
			for (String file : moduleFolder.list()) {
				// If a manifest is found is added to the list of artifact
				if (file.endsWith(".gadget.xml")) {
					as.add(new StandardGeneratedResource(GadgetGenerator.class,
							file, new File(moduleFolder, file)));
				}
			}
		}

		// Return to the original Google Gadget Linker
		return gadgetLinker.link(logger, context, as);		
	}
	
	@Override
	public ArtifactSet relink(TreeLogger logger, LinkerContext context,
			ArtifactSet newArtifacts) throws UnableToCompleteException {
		return link(logger, context, newArtifacts);
	}
}
