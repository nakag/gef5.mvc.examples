package tmdmaker.ui.editor.gef5.handlers;

import org.eclipse.gef.geometry.planar.Rectangle;
import org.eclipse.gef.mvc.fx.handlers.AbstractHandler;
import org.eclipse.gef.mvc.fx.handlers.IOnClickHandler;
import org.eclipse.gef.mvc.fx.parts.IContentPart;
import org.eclipse.gef.mvc.fx.parts.IRootPart;
import org.eclipse.gef.mvc.fx.parts.IVisualPart;
import org.eclipse.gef.mvc.fx.policies.CreationPolicy;
import org.eclipse.gef.mvc.fx.viewer.IViewer;

import com.google.common.collect.HashMultimap;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import tmdmaker.ui.editor.gef5.model.Entity;
import tmdmaker.ui.editor.gef5.parts.DiagramPart;
import tmdmaker.ui.editor.gef5.tools.ItemCreationModel;
import tmdmaker.ui.editor.gef5.tools.ItemCreationModel.Type;

public class CreateNewEntityOnClickHandler extends AbstractHandler implements IOnClickHandler {

	@Override
	public void click(MouseEvent e) {
		if (!e.isPrimaryButtonDown()) {
			return;
		}

		IViewer viewer = getHost().getRoot().getViewer();
		ItemCreationModel creationModel = viewer.getAdapter(ItemCreationModel.class);
		if (creationModel == null) {
			System.out.println("creationModel is null");
			return;
		}
		
		if (creationModel.getType() != Type.Entity) {
			System.out.println("creationModel.getType() is not Entity:" + creationModel.getType());
			creationModel.setSource(null);
			return;
		}
		IVisualPart<? extends Node> part = viewer.getRootPart().getChildrenUnmodifiable().get(0);
		System.out.println(part);
		
		if (part instanceof DiagramPart) {
			Point2D mouseInLocal = part.getVisual().sceneToLocal(e.getSceneX(), e.getSceneY());
			
			Entity entity = new Entity();
			entity.setName("new entity");
			entity.setColor(Color.ALICEBLUE);
			entity.setConstraint(new Rectangle(mouseInLocal.getX(), mouseInLocal.getY(), 0, 0));
			
			IRootPart<? extends Node> root = getHost().getRoot();
			CreationPolicy creationPolicy = root.getAdapter(CreationPolicy.class);
			init(creationPolicy);
			creationPolicy.create(entity, part, HashMultimap.<IContentPart<? extends Node>, String>create());
			
			commit(creationPolicy);
		}
		creationModel.setType(Type.None);

		
	}

}
