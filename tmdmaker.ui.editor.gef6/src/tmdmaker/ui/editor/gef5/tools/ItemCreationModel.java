package tmdmaker.ui.editor.gef5.tools;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import tmdmaker.ui.editor.gef5.parts.EntityPart;

public class ItemCreationModel {
	public enum Type {
		None, Entity, Connection;
	}

	private ObjectProperty<Type> typeProperty = new SimpleObjectProperty<Type>(Type.None);

	private ObjectProperty<EntityPart> sourceProperty = new SimpleObjectProperty<>();

	public Type getType() {
		return typeProperty.get();
	}

	public void setType(Type type) {
		this.typeProperty.set(type);
	}

	public ObjectProperty<Type> getTypeProperty() {
		return typeProperty;
	}

	public void setSource(EntityPart source) {
		this.sourceProperty.setValue(source);
	}

	public EntityPart getSource() {
		return sourceProperty.getValue();
	}

	public ObjectProperty<EntityPart> getSourceProperty() {
		return sourceProperty;
	}
}
