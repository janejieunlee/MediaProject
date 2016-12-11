package broadcast.service;

import java.util.Map;

public class ReserveRequest {
	private String name;
	private String picture;
	private String broadcaster;
	private String productName;
	private int lowPrice;
	private int ctgId;
	private String date;
	private String time;

	
	public ReserveRequest(String name, String picture, String broadcaster, 
			String productName, int lowPrice, int ctgId, String date, String time){
		this.name = name;
		this.picture = picture;
		this.broadcaster = broadcaster;
		this.productName = productName;
		this.lowPrice = lowPrice;
		this.ctgId = ctgId;
		this.date = date;
		this.time = time;
	}
	
	public String getName() {
		return name;
	}
	
	
	public String getPicture() {
		return picture;
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
	
	
	public String getDate() {
		return date;
	}
	
	
	public String getTime() {
		return time;
	}
	
	public void validate(Map<String, Boolean> errors){
		if(name == null || name.trim().isEmpty()){
			errors.put("broadcastName",Boolean.TRUE);
		}
	}
}
