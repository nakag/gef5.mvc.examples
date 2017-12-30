package tmdmaker.ui.editor.gef5.model;

import org.eclipse.gef.geometry.planar.Rectangle;

public class Entity {
	public Rectangle rect = new Rectangle();
	private String name = "Hello GEF5 Eclipse Editor!";
	
	public Entity() {
		rect.setBounds(10, 10, 100, 100);
	}

	public Rectangle getRect() {
		return rect;
	}
	
	public String getName() {
		return name;
	}
}
