package tmdmaker.ui.editor.gef5.behaviors;

import org.eclipse.gef.mvc.fx.behaviors.AbstractBehavior;
import org.eclipse.gef.mvc.fx.parts.IFeedbackPartFactory;
import org.eclipse.gef.mvc.fx.viewer.IViewer;

import tmdmaker.ui.editor.gef5.tools.ItemCreationModel;

public class CreateFeedbackBehavior extends AbstractBehavior {
	public static final String CREATE_FEEDBACK_PART_FACTORY = "CREATE_FEEDBACK_PART_FACTORY";

	@Override
	protected void doActivate() {
		ItemCreationModel model = getHost().getRoot().getViewer().getAdapter(ItemCreationModel.class);
		model.getSourceProperty().addListener((o, oldValue, newValue) -> {
			if (newValue == null) {
				clearFeedback();
			} else {
				addFeedback(newValue);
			}
		});

		super.doActivate();
	}

	@Override
	protected IFeedbackPartFactory getFeedbackPartFactory(IViewer viewer) {
		return getFeedbackPartFactory(viewer, CREATE_FEEDBACK_PART_FACTORY);
	}
}
