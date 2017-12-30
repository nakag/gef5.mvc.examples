package tmdmaker.ui.editor.gef5.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.geometry.planar.Rectangle;

import javafx.scene.paint.Color;

public class Entity {
	private Rectangle rect = new Rectangle();
	private Color color = Color.LIGHTSKYBLUE;
	private String name;
	private List<String> attributes = new ArrayList<>();

	public Entity() {
		this("顧客", 10, 10);
	}

	public Entity(String name, double x, double y) {
		this.name = name;
		rect.setBounds(x, y, -1, -1);
	}

	public String getName() {
		return name;
	}

	public Rectangle getRect() {
		return rect;
	}

	public Color getColor() {
		return color;
	}

	public void addAttribute(String attribute) {
		this.attributes.add(attribute);
	}

	public void removeAttribute(String attribute) {
		this.attributes.remove(attribute);
	}
	
	public List<String> getAttributes() {
		return this.attributes;
	}
}
