package tmdmaker.ui.editor.gef5.anchors;

import org.eclipse.gef.common.adapt.IAdaptable;
import org.eclipse.gef.fx.anchors.DynamicAnchor;
import org.eclipse.gef.fx.anchors.DynamicAnchor.AnchorageReferenceGeometry;
import org.eclipse.gef.fx.anchors.IAnchor;
import org.eclipse.gef.geometry.planar.IGeometry;
import org.eclipse.gef.mvc.fx.parts.IVisualPart;

import com.google.common.reflect.TypeToken;
import com.google.inject.Provider;

import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.scene.Node;

public class AnchorProvider extends IAdaptable.Bound.Impl<IVisualPart<? extends Node>> implements Provider<IAnchor> {
	private DynamicAnchor anchor;

	@Override
	public ReadOnlyObjectProperty<IVisualPart<? extends Node>> adaptableProperty() {
		return null;
	}

	@Override
	public IAnchor get() {
		if (anchor == null) {

			Node anchorage = getAdaptable().getVisual();
			anchor = new DynamicAnchor(anchorage);
			anchor.getComputationParameter(AnchorageReferenceGeometry.class).bind(new ObjectBinding<IGeometry>() {
				{
					bind(anchorage.layoutBoundsProperty());
				}

				@Override
				protected IGeometry computeValue() {
					@SuppressWarnings("serial")
					Provider<IGeometry> geomProvider = getAdaptable().getAdapter(new TypeToken<Provider<IGeometry>>() {
					});
					return geomProvider.get();
				}

			});
		}

		return anchor;
	}

}
