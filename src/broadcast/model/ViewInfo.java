package broadcast.model;

public class ViewInfo {

	private String memberId;
	private Integer broadcastId;
	private int read_cnt;

	public ViewInfo(String memberId, Integer broadcastId, int read_cnt) {
		this.memberId = memberId;
		this.broadcastId = broadcastId;
		this.read_cnt = read_cnt;
	}

	public String getMemberId() {
		return memberId;
	}

	public Integer getBroadcastId() {
		return broadcastId;
	}

	public int getRead_cnt() {
		return read_cnt;
	}

}
