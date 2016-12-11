package broadcast.service;

import java.util.Map;

public class RegisterRequest {
	private String name;
	private String picture;
	private String broadcaster;
	private String productName;
	private int lowPrice; 
	private int ctgId; 
	
	public RegisterRequest(String name, String picture, String broadcaster,
			String productName, int lowPrice, int ctgId){
		this.name = name;
		this.picture = picture;
		this.broadcaster = broadcaster;
		this.productName = productName;
		this.lowPrice = lowPrice;
		this.ctgId = ctgId;
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
	
	public void validate(Map<String, Boolean> errors){
		if(name == null || name.trim().isEmpty()){
			errors.put("name",Boolean.TRUE);
		}
	}
	
}
