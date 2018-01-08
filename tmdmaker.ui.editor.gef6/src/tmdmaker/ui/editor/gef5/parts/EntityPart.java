package tmdmaker.ui.editor.gef5.parts;

import java.beans.PropertyChangeListener;
import java.util.Collections;
import java.util.List;

import org.eclipse.gef.geometry.planar.Rectangle;
import org.eclipse.gef.mvc.fx.parts.AbstractContentPart;
import org.eclipse.gef.mvc.fx.parts.ITransformableContentPart;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.SetMultimap;

import javafx.scene.transform.Affine;
import javafx.scene.transform.Translate;
import tmdmaker.ui.editor.gef5.model.Entity;
import tmdmaker.ui.editor.gef5.visuals.EntityShape;

public class EntityPart extends AbstractContentPart<EntityShape> implements ITransformableContentPart<EntityShape> {

	private final PropertyChangeListener listener = new PropertyChangeListener() {
		public void propertyChange(java.beans.PropertyChangeEvent evt) {
			if (evt.getPropertyName().equals(Entity.PROPERTY_CONSTRAINT)) {
				refreshVisual();
			}
		};
	};

	@Override
	protected void doActivate() {
		super.doActivate();
		getContent().addPropertyChangeListener(listener);

	}

	@Override
	protected void doDeactivate() {
		getContent().removePropertyChangeListener(listener);
		super.doDeactivate();
	}

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
		EntityShape shape = new EntityShape();
		return shape;
	}

	@Override
	protected void doRefreshVisual(EntityShape visual) {
		Entity e = getContent();
		visual.update(e);
		setVisualTransform(getContentTransform());
	}

	@Override
	public Entity getContent() {
		return (Entity) super.getContent();
	}

	@Override
	public Affine getContentTransform() {
		Rectangle rect = getContent().getConstraint();
		return new Affine(new Translate(rect.getX(), rect.getY()));
	}

	@Override
	public void setContentTransform(Affine totalTransform) {
		Rectangle bounds = getContent().getConstraint().getCopy();
		bounds.setX(totalTransform.getTx());
		bounds.setY(totalTransform.getTy());
		getContent().setConstraint(bounds);
	}
}
