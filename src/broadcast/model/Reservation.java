package broadcast.model;

public class Reservation {
	private Integer broadcastId;
	private String name;
	// private String picture;
	private String date;
	private String time;
	private String broadcaster;
	private String productName;
	private int lowPrice;
	private int ctgId;

	public Reservation(Integer broadcastId, String name, String date, String time, String broadcaster,
			String productName, int lowPrice, int ctgId) {
		this.broadcastId = broadcastId;
		this.name = name;
		// this.picture = picture;
		this.date = date;
		this.time = time;
		this.broadcaster = broadcaster;
		this.productName = productName;
		this.lowPrice = lowPrice;
		this.ctgId = ctgId;
	}

	public Integer getBroadcastId() {
		return broadcastId;
	}

	public String getName() {
		return name;
	}

	public String getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}

	public String getBroadcaster() {
		return broadcaster;
	}

	public String getProductName() {
		return productName;
	}

	public int getLowPrice() {
		return lowPrice;
	}

	public int getCtgId() {
		return ctgId;
	}

}
