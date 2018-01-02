package tmdmaker.ui.editor.gef5.tools;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class ItemCreationModel {
	public enum Type {
		None, Entity
	}

	private ObjectProperty<Type> typeProperty = new SimpleObjectProperty<Type>(Type.None);

	public Type getType() {
		return typeProperty.get();
	}

	public void setType(Type type) {
		this.typeProperty.set(type);
	}

	public ObjectProperty<Type> getTypeProperty() {
		return typeProperty;
	}

}
