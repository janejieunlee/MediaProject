package recommend.model;

public class Recommendation {

	private int viewer_id;
	private int broadcast_id;
	private int read_cnt;
	
	public Recommendation(int viewer_id, int broadcast_id, int read_cnt) {
		this.viewer_id = viewer_id;
		this.broadcast_id = broadcast_id;
		this.read_cnt = read_cnt;
	}
	
	public int getViewer_id() {
		return viewer_id;
	}
	
	public int getBroadcast_id() {
		return broadcast_id;
	}
	
	public int getRead_cnt() {
		return read_cnt;
	}
	
}
