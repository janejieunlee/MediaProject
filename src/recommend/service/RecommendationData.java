package recommend.service;

import recommend.model.Recommendation;

public class RecommendationData {

	private Recommendation recommendation;
	
	public RecommendationData(Recommendation recommendation) {
		this.recommendation = recommendation;
	}
	
	public Recommendation getRecommendation() {
		return recommendation;
	}
}
