package tmdmaker.ui.editor.gef5.model;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.geometry.planar.Rectangle;

import com.google.common.collect.Lists;

import javafx.scene.paint.Color;

public class Entity extends AbstractModel {
	public static final String PROPERTY_CONSTRAINT = "constraint";
	public static final String PROPERTY_SOURCE_CONNECTION = "source_connection";
	public static final String PROPERTY_TARGET_CONNECTION = "target_connection";

	private Color color = Color.LIGHTSKYBLUE;
	private String name;
	private List<String> attributes = new ArrayList<>();
	private Rectangle constraint = new Rectangle();
	private List<Connection> sourceConnections = Lists.newArrayList();
	private List<Connection> targetConnections = Lists.newArrayList();

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

	public void addSourceConnection(Connection sourceConnection) {
		this.sourceConnections.add(sourceConnection);
		this.listeners.firePropertyChange(PROPERTY_SOURCE_CONNECTION, null, sourceConnection);
	}

	public void removeSourceConnection(Connection sourceConnection) {
		this.sourceConnections.remove(sourceConnection);
		this.listeners.firePropertyChange(PROPERTY_SOURCE_CONNECTION, sourceConnection, null);
	}

	public List<Connection> getSourceConnections() {
		return sourceConnections;
	}

	public void addTargetConnection(Connection targetConnection) {
		this.targetConnections.add(targetConnection);
		this.listeners.firePropertyChange(PROPERTY_TARGET_CONNECTION, null, targetConnection);
	}

	public void removeTargetConnection(Connection targetConnection) {
		this.targetConnections.remove(targetConnection);
		this.listeners.firePropertyChange(PROPERTY_TARGET_CONNECTION, targetConnection, null);
	}

	public List<Connection> getTargetConnections() {
		return targetConnections;
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		this.listeners.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		this.listeners.removePropertyChangeListener(listener);
	}
}
