package tmdmaker.ui.editor.gef5;

import org.eclipse.gef.common.adapt.AdapterKey;
import org.eclipse.gef.common.adapt.inject.AdapterMaps;
import org.eclipse.gef.mvc.fx.MvcFxModule;
import org.eclipse.gef.mvc.fx.handlers.FocusAndSelectOnClickHandler;
import org.eclipse.gef.mvc.fx.handlers.HoverOnHoverHandler;
import org.eclipse.gef.mvc.fx.handlers.TranslateSelectedOnDragHandler;
import org.eclipse.gef.mvc.fx.parts.DefaultHoverFeedbackPartFactory;
import org.eclipse.gef.mvc.fx.parts.DefaultSelectionFeedbackPartFactory;
import org.eclipse.gef.mvc.fx.parts.DefaultSelectionHandlePartFactory;
import org.eclipse.gef.mvc.fx.parts.IContentPartFactory;
import org.eclipse.gef.mvc.fx.policies.TransformPolicy;
import org.eclipse.gef.mvc.fx.providers.ShapeBoundsProvider;
import org.eclipse.gef.mvc.fx.providers.ShapeOutlineProvider;

import com.google.inject.multibindings.MapBinder;

import tmdmaker.ui.editor.gef5.anchors.AnchorProvider;
import tmdmaker.ui.editor.gef5.behaviors.CreateFeedbackBehavior;
import tmdmaker.ui.editor.gef5.handlers.CreateNewConnectionClickHandler;
import tmdmaker.ui.editor.gef5.handlers.CreateNewEntityOnClickHandler;
import tmdmaker.ui.editor.gef5.handlers.MyPanOnStrokeHandler;
import tmdmaker.ui.editor.gef5.parts.EntityPart;
import tmdmaker.ui.editor.gef5.parts.TMDModelPartFactory;
import tmdmaker.ui.editor.gef5.parts.feedback.TMDFeedbackPartFactory;
import tmdmaker.ui.editor.gef5.tools.ItemCreationModel;

public class TMDMakerModule extends MvcFxModule {

	@Override
	protected void bindAbstractContentPartAdapters(MapBinder<AdapterKey<?>, Object> adapterMapBinder) {
		super.bindAbstractContentPartAdapters(adapterMapBinder);

		adapterMapBinder.addBinding(AdapterKey.defaultRole()).to(FocusAndSelectOnClickHandler.class);

		adapterMapBinder.addBinding(AdapterKey.defaultRole()).to(HoverOnHoverHandler.class);
	}

	protected void bindEntityPartAdapters(MapBinder<AdapterKey<?>, Object> adapterMapBinder) {
		adapterMapBinder
				.addBinding(AdapterKey.role(DefaultSelectionFeedbackPartFactory.SELECTION_FEEDBACK_GEOMETRY_PROVIDER))
				.to(ShapeBoundsProvider.class);

		// geometry provider for selection handles
		adapterMapBinder
				.addBinding(AdapterKey.role(DefaultSelectionHandlePartFactory.SELECTION_HANDLES_GEOMETRY_PROVIDER))
				.to(ShapeOutlineProvider.class);

		adapterMapBinder
				.addBinding(
						AdapterKey.role(DefaultSelectionFeedbackPartFactory.SELECTION_LINK_FEEDBACK_GEOMETRY_PROVIDER))
				.to(ShapeOutlineProvider.class);

		// geometry provider for hover feedback
		adapterMapBinder.addBinding(AdapterKey.role(DefaultHoverFeedbackPartFactory.HOVER_FEEDBACK_GEOMETRY_PROVIDER))
				.to(ShapeOutlineProvider.class);

		// register resize/transform policies (writing changes also to
		// model)
		adapterMapBinder.addBinding(AdapterKey.defaultRole()).to(TransformPolicy.class);

		// interaction policies to relocate on drag (including anchored
		// elements, which are linked)
		adapterMapBinder.addBinding(AdapterKey.defaultRole()).to(TranslateSelectedOnDragHandler.class);

		adapterMapBinder.addBinding(AdapterKey.defaultRole()).to(CreateNewConnectionClickHandler.class);

		adapterMapBinder.addBinding(AdapterKey.defaultRole()).to(AnchorProvider.class);
		
		adapterMapBinder.addBinding(AdapterKey.defaultRole()).to(ShapeOutlineProvider.class);

	}

	@Override
	protected void configure() {
		super.configure();
		bindIContentPartFactory();

		bindEntityPartAdapters(AdapterMaps.getAdapterMapBinder(binder(), EntityPart.class));
	}

	protected void bindIContentPartFactory() {
		binder().bind(IContentPartFactory.class).to(TMDModelPartFactory.class);
	}

	@Override
	protected void bindIViewerAdaptersForContentViewer(MapBinder<AdapterKey<?>, Object> adapterMapBinder) {
		super.bindIViewerAdaptersForContentViewer(adapterMapBinder);
		adapterMapBinder.addBinding(AdapterKey.defaultRole()).to(ItemCreationModel.class);
		adapterMapBinder.addBinding(AdapterKey.role(CreateFeedbackBehavior.CREATE_FEEDBACK_PART_FACTORY))
				.to(TMDFeedbackPartFactory.class);
//		adapterMapBinder.addBinding(AdapterKey.defaultRole()).to(ViewportPolicy.class);
	}

	@Override
	protected void bindIRootPartAdaptersForContentViewer(MapBinder<AdapterKey<?>, Object> adapterMapBinder) {
		super.bindIRootPartAdaptersForContentViewer(adapterMapBinder);
		adapterMapBinder.addBinding(AdapterKey.defaultRole()).to(CreateNewEntityOnClickHandler.class);
		adapterMapBinder.addBinding(AdapterKey.defaultRole()).to(CreateFeedbackBehavior.class);
//		adapterMapBinder.addBinding(AdapterKey.defaultRole()).to(CreateNewConnectionClickHandler.class);
	}

	@Override
	protected void bindPanOnTypeHandlerAsIRootPartAdapter(MapBinder<AdapterKey<?>, Object> adapterMapBinder) {
	adapterMapBinder.addBinding(AdapterKey.defaultRole())
			.to(MyPanOnStrokeHandler.class);
	}

}
