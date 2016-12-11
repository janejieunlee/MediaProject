package broadcast.model;

import java.util.Date;

public class Broadcast {
	private Integer broadcastId;
	private String name;
	private String picture;
	private Date date;
	private String broadcaster;
	private String productName;
	private int lowPrice;
	private int ctgId;

	public Broadcast(Integer broadcastId, String name, String picture, Date date, String broadcaster,
			String productName, int lowPrice, int ctgId) {
		this.broadcastId = broadcastId;
		this.name = name;
		this.picture = picture;
		this.date = date;
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

	public String getPicture() {
		return picture;
	}

	public Date getDate() {
		return date;
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
