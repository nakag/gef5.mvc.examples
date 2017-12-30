package tmdmaker.ui.editor.gef5;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class TMDMakerUIBundle extends AbstractUIPlugin {
	// The plug-in ID
	public static final String PLUGIN_ID = "tmdmaker.ui.editor.gef2"; //$NON-NLS-1$

	// The shared instance
	private static TMDMakerUIBundle plugin;

	public TMDMakerUIBundle() {
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	public static TMDMakerUIBundle getDefault() {
		return plugin;
	}
}
