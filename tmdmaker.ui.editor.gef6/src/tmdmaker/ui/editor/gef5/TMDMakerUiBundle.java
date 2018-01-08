package tmdmaker.ui.editor.gef5;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class TMDMakerUiBundle extends AbstractUIPlugin {
	// The plug-in ID
	public static final String PLUGIN_ID = "tmdmaker.ui.editor.gef4"; //$NON-NLS-1$

	// The shared instance
	private static TMDMakerUiBundle plugin;

	public TMDMakerUiBundle() {
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

	public static TMDMakerUiBundle getDefault() {
		return plugin;
	}
}
