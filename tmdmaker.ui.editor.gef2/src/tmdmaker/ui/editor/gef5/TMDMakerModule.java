package tmdmaker.ui.editor.gef5;

import org.eclipse.gef.mvc.fx.MvcFxModule;
import org.eclipse.gef.mvc.fx.parts.IContentPartFactory;

import tmdmaker.ui.editor.gef5.parts.TMDModelPartFactory;

public class TMDMakerModule extends MvcFxModule {

	@Override
	protected void configure() {
		super.configure();
		bindIContentPartFactory();
	}

	protected void bindIContentPartFactory() {
		binder().bind(IContentPartFactory.class).to(TMDModelPartFactory.class);
	}

}
