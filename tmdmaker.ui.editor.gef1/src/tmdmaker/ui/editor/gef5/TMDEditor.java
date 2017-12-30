package tmdmaker.ui.editor.gef5;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.mvc.fx.ui.parts.AbstractFXEditor;
import org.eclipse.ui.IEditorInput;

import com.google.inject.Guice;
import com.google.inject.util.Modules;

import tmdmaker.ui.editor.gef5.model.Entity;

public class TMDEditor extends AbstractFXEditor {

	public TMDEditor() {
		super(Guice.createInjector(Modules.override(new TMDMakerModule()).with(new TMDMakerUiModule())));
		getContentViewer().getContents().setAll(createContents());
	}

	protected List<? extends Object> createContents() {
		return Collections.singletonList(new Entity());
	}

	@Override
	protected void setInput(IEditorInput input) {
		super.setInput(input);
		setPartName(input.getName());

	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isSaveAsAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

}
