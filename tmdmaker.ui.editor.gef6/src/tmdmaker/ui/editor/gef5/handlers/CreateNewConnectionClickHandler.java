package tmdmaker.ui.editor.gef5.handlers;

import java.util.Collections;

import org.eclipse.gef.mvc.fx.handlers.AbstractHandler;
import org.eclipse.gef.mvc.fx.handlers.IOnClickHandler;
import org.eclipse.gef.mvc.fx.operations.ChangeSelectionOperation;
import org.eclipse.gef.mvc.fx.parts.IContentPart;
import org.eclipse.gef.mvc.fx.parts.IRootPart;
import org.eclipse.gef.mvc.fx.parts.IVisualPart;
import org.eclipse.gef.mvc.fx.policies.CreationPolicy;
import org.eclipse.gef.mvc.fx.viewer.IViewer;

import com.google.common.collect.HashMultimap;
import com.google.common.reflect.TypeToken;

import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import tmdmaker.ui.editor.gef5.model.Connection;
import tmdmaker.ui.editor.gef5.parts.DiagramPart;
import tmdmaker.ui.editor.gef5.parts.EntityPart;
import tmdmaker.ui.editor.gef5.tools.ItemCreationModel;
import tmdmaker.ui.editor.gef5.tools.ItemCreationModel.Type;

public class CreateNewConnectionClickHandler extends AbstractHandler implements IOnClickHandler {

	@Override
	public void click(MouseEvent e) {
		if (!e.isPrimaryButtonDown()) {
			return;
		}

		IViewer viewer = getHost().getRoot().getViewer();
		ItemCreationModel creationModel = viewer.getAdapter(ItemCreationModel.class);
		if (creationModel.getType() != Type.Connection) {
			return;
		}
		
		if (creationModel.getSource() == null) {
			creationModel.setSource((EntityPart) getHost());
			return;
		}
		
		EntityPart source = creationModel.getSource();
		EntityPart target = (EntityPart) getHost();
		
		// TODO: Create Recursive Relationship
		if (source == target) {
			return;
		}
		
		IVisualPart<? extends Node> part = getHost().getRoot().getChildrenUnmodifiable().get(0);
		if (part instanceof DiagramPart) {
			Connection newConnection = new Connection(source.getContent(), target.getContent());
			newConnection.connect();
			
			IRootPart<? extends Node> root = getHost().getRoot();
			@SuppressWarnings("serial")
			CreationPolicy creationPolicy = root.getAdapter(new TypeToken<CreationPolicy>() {
			});
			init(creationPolicy);
			creationPolicy.create(newConnection, part, HashMultimap.<IContentPart<? extends Node>, String>create());
			commit(creationPolicy);
			try {
				viewer.getDomain().execute(new ChangeSelectionOperation(viewer, Collections.singletonList(target)),null);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		creationModel.setSource(null);
		
	}

}
