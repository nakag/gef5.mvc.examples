package tmdmaker.ui.editor.gef5.behaviors;

import org.eclipse.gef.mvc.fx.behaviors.HoverBehavior;

import javafx.scene.control.FocusModel;
import tmdmaker.ui.editor.gef5.tools.ItemCreationModel;

public class CreateEntityBehavior extends HoverBehavior {

	
	@Override
	protected void doActivate() {
		
		FocusModel focusModel = getHost().getViewer().getAdapter(FocusModel.class);
		if (focusModel != null) {
			System.out.println("current focus is "+focusModel.getFocusedItem());
		} else {
			System.out.println("focus model is null");
		}
		ItemCreationModel model = getHost().getRoot().getViewer().getAdapter(ItemCreationModel.class);
		model.getTypeProperty().addListener((o, oldValue, newValue) -> {
			if (newValue == ItemCreationModel.Type.Entity) {
				System.out.println("create entity");
			} else {
				System.out.println("not entity");				
			}
		});
		
		super.doActivate();
	}

	@Override
	protected void doDeactivate() {
		// TODO Auto-generated method stub
		System.out.println("deactivate");
		super.doDeactivate();
	}

}
