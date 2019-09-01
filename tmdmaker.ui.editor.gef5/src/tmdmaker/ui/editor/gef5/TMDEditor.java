package tmdmaker.ui.editor.gef5;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.mvc.fx.ui.parts.AbstractFXEditor;
import org.eclipse.ui.IEditorInput;

import com.google.inject.Guice;
import com.google.inject.util.Modules;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import tmdmaker.ui.editor.gef5.model.Diagram;
import tmdmaker.ui.editor.gef5.model.Entity;
import tmdmaker.ui.editor.gef5.tools.ItemCreationModel;
import tmdmaker.ui.editor.gef5.tools.ItemCreationModel.Type;

public class TMDEditor extends AbstractFXEditor {
	Diagram diagram;

	public TMDEditor() {
		super(Guice.createInjector(Modules.override(new TMDMakerModule()).with(new TMDMakerUiModule())));
		getContentViewer().getContents().setAll(createContents());
	}

	protected List<? extends Object> createContents() {
		if (diagram == null) {
			diagram = new Diagram();
			diagram.add(new Entity("顧客", 20, 20));
			Entity e2 = new Entity("商品", 30, 100);
			e2.addAttribute("単価");
			e2.addAttribute("単価区分");
			diagram.add(e2);
		}

		return Collections.singletonList(diagram);
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

	@Override
	protected void hookViewers() {
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(getContentViewer().getCanvas());
		borderPane.setRight(createToolPalette());
		getCanvas().setScene(new Scene(borderPane));
	}
	private static final Image CREATION_ICON = new Image(TMDEditor.class.getClassLoader().getResourceAsStream("icon/new_entity.gif"));

	private Node createToolPalette() {
		ItemCreationModel creationModel = getContentViewer().getAdapter(ItemCreationModel.class);
		ToggleGroup toggleGroup = new ToggleGroup();
		ImageView imageView = new ImageView(CREATION_ICON);
		ToggleButton createNode = new ToggleButton("add entity",imageView);

		// Fix Endless NPE on arrow keys.
		// TODO: Try to bind palette to FocusModel.
		createNode.setFocusTraversable(false);

		createNode.setToggleGroup(toggleGroup);
		createNode.selectedProperty().addListener((e, oldValue, newValue) -> 
			creationModel.setType(newValue ? ItemCreationModel.Type.Entity : Type.None)
		);
		creationModel.getTypeProperty().addListener((e, oldValue, newValue) -> {
			if (Type.None == newValue) {
				Toggle selectedToggle = toggleGroup.getSelectedToggle();
				if (selectedToggle != null) {
					selectedToggle.setSelected(false);
				}
			}
		});
		return new VBox(20, createNode);
	}
}
