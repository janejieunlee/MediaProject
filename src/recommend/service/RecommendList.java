package recommend.service;

import java.util.List;

import recommend.model.Recommendation;

public class RecommendList {
	private List<Recommendation> item;
	
	public RecommendList(List<Recommendation> item){
		this.item = item;
	}
	
	public List<Recommendation> getItem() {
		return item;
	}
}
