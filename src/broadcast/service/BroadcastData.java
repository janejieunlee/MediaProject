package broadcast.service;

import broadcast.model.Broadcast;

public class BroadcastData {

	private Broadcast broadcast;

	public BroadcastData(Broadcast broadcast) {
		this.broadcast = broadcast;
	}

	public Broadcast getBroadcast() {
		return broadcast;
	}
}
