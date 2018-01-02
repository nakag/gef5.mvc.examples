package tmdmaker.ui.editor.gef5.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.geometry.planar.Rectangle;

import javafx.scene.paint.Color;

public class Entity {
	public static final String PROPERTY_CONSTRAINT = "constraint";

	private Color color = Color.LIGHTSKYBLUE;
	private String name;
	private List<String> attributes = new ArrayList<>();
	private Rectangle constraint = new Rectangle();
	private PropertyChangeSupport listeners = new PropertyChangeSupport(this);

	public Entity() {
		this("顧客", 10, 10);
	}

	public Entity(String name, double x, double y) {
		this.name = name;
		constraint = new Rectangle(x, y, 0, 0);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Rectangle getConstraint() {
		return constraint.getCopy();
	}

	public void setColor(Color color) {
		this.color = color;
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

	public void setConstraint(Rectangle constraint) {
		Rectangle old = this.constraint;
		this.constraint = constraint;
		listeners.firePropertyChange(PROPERTY_CONSTRAINT, old, constraint);
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		this.listeners.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		this.listeners.removePropertyChangeListener(listener);
	}
}
