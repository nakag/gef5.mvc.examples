package tmdmaker.ui.editor.gef5.parts;

import java.util.Collections;
import java.util.List;

import org.eclipse.gef.mvc.fx.parts.AbstractContentPart;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.SetMultimap;

import tmdmaker.ui.editor.gef5.model.Entity;
import tmdmaker.ui.editor.gef5.visuals.EntityShape;

public class EntityPart extends AbstractContentPart<EntityShape> {

	@Override
	protected SetMultimap<? extends Object, String> doGetContentAnchorages() {
		return HashMultimap.create();
	}

	@Override
	protected List<? extends Object> doGetContentChildren() {
		return Collections.emptyList();
	}

	@Override
	protected EntityShape doCreateVisual() {
		EntityShape visual = createVisual();
		doRefreshVisual(visual);
		return visual;
	}

	@Override
	protected void doRefreshVisual(EntityShape visual) {
		Entity e = (Entity) getContent();
		visual.setLayoutX(e.getRect().getX());
		visual.setLayoutY(e.getRect().getY());

		visual.setEntityName(e.getName());
	}

	protected EntityShape createVisual() {
		return new EntityShape();
	}

}
