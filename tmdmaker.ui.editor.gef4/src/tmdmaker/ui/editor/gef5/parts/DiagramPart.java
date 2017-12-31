package tmdmaker.ui.editor.gef5.parts;

import java.util.List;

import org.eclipse.gef.mvc.fx.parts.AbstractContentPart;
import org.eclipse.gef.mvc.fx.parts.IVisualPart;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.SetMultimap;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import tmdmaker.ui.editor.gef5.model.Diagram;
import tmdmaker.ui.editor.gef5.model.Entity;

public class DiagramPart extends AbstractContentPart<Group> {
	@Override
	public Diagram getContent() {
		return (Diagram) super.getContent();
	}

	@Override
	protected Group doCreateVisual() {
		return new Group();
	}

	@Override
	protected void doRefreshVisual(Group visual) {
	}

	@Override
	public List<? extends Entity> doGetContentChildren() {
		return getContent().getChildren();
	}

	@Override
	protected void doAddChildVisual(IVisualPart<? extends Node> child, int index) {
		ObservableList<Node> children = getVisual().getChildren();
		Node visual = child.getVisual();
		children.add(visual);
	}

	@Override
	public SetMultimap<? extends Object, String> doGetContentAnchorages() {
		return HashMultimap.create();
	}

	@Override
	protected void doRemoveChildVisual(IVisualPart<? extends Node> child, int index) {
		ObservableList<Node> children = getVisual().getChildren();
		children.remove(index);
	}
}
