package tmdmaker.ui.editor.gef5.visuals;

import org.eclipse.gef.fx.nodes.Connection;
import org.eclipse.gef.fx.nodes.OrthogonalRouter;

public class ConnectionShape extends Connection {

	public ConnectionShape() {
		routerProperty().set(new OrthogonalRouter());
	}

}
