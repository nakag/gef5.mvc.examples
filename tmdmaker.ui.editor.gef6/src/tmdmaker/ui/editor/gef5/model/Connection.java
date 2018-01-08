package tmdmaker.ui.editor.gef5.model;

public class Connection extends AbstractModel {
	private Entity source;
	private Entity target;



	public Connection(Entity source, Entity target) {
		this.source = source;
		this.target = target;
	}

	public void connect() {
		attachSource();
		attachTarget();
	}

	public void disconnect() {
		detachSource();
		detachTarget();
	}

	public void attachSource() {
		if (!source.getSourceConnections().contains(this)) {
			source.addSourceConnection(this);
		}
	}

	public void attachTarget() {
		if (!target.getTargetConnections().contains(this)) {
			target.addTargetConnection(this);
		}
	}

	public void detachSource() {
		if (source != null) {
			source.removeSourceConnection(this);
		}
	}

	public void detachTarget() {
		if (target != null) {
			target.removeTargetConnection(this);
		}
	}

	public boolean isConnected() {
		return source != null && source.getSourceConnections().contains(this) && target != null
				&& target.getTargetConnections().contains(this);
	}

	public Entity getSource() {
		return source;
	}

	public Entity getTarget() {
		return target;
	}
}
