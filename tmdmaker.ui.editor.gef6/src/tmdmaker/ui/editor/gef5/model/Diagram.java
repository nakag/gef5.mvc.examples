package tmdmaker.ui.editor.gef5.model;

import java.util.ArrayList;
import java.util.List;

public class Diagram {
	private List<AbstractModel> children = new ArrayList<>();

	public List<AbstractModel> getChildren() {
		return children;
	}

	public void add(AbstractModel entity) {
		this.children.add(entity);
	}

	public void remove(AbstractModel entity) {
		this.children.remove(entity);
	}
}
