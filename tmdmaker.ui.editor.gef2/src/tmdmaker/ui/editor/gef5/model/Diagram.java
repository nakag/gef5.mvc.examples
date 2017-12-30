package tmdmaker.ui.editor.gef5.model;

import java.util.ArrayList;
import java.util.List;

public class Diagram {
	private List<Entity> children = new ArrayList<>();

	public List<Entity> getChildren() {
		return children;
	}

	public void add(Entity entity) {
		this.children.add(entity);
	}

	public void remove(Entity entity) {
		this.children.remove(entity);
	}
}
