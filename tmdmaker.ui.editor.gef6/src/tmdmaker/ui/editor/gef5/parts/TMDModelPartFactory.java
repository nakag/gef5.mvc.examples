package tmdmaker.ui.editor.gef5.parts;

import java.util.Map;

import javax.inject.Inject;

import org.eclipse.gef.mvc.fx.parts.IContentPart;
import org.eclipse.gef.mvc.fx.parts.IContentPartFactory;

import com.google.inject.Injector;

import javafx.scene.Node;
import tmdmaker.ui.editor.gef5.model.Connection;
import tmdmaker.ui.editor.gef5.model.Diagram;
import tmdmaker.ui.editor.gef5.model.Entity;

public class TMDModelPartFactory implements IContentPartFactory {
	@Inject
	private Injector injector;

	@Override
	public IContentPart<? extends Node> createContentPart(Object content, Map<Object, Object> contextMap) {
		if (content instanceof Diagram) {
			return injector.getInstance(DiagramPart.class);
		} else if (content instanceof Entity) {
			return injector.getInstance(EntityPart.class);
		} else if (content instanceof Connection) {
			return injector.getInstance(ConnectionPart.class);
		} else {
			throw new IllegalArgumentException(content.getClass().toString());
		}
	}

}
