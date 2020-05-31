package pkg;

public class ConstructionCostEstimate {
	public int calculateCost(String material, int area, boolean automated) {
		if(material.equals("standard materials")) {
			return 1200*area;
		}
		else if(material.equals("above standard materials")) {
			return 1500*area;
		}
		else if(material.equals("high standard materials") && automated == true) {
			return 2500*area;
		}
		else if(material.equals("high standard materials")) {
			return 1800*area;
		}
		else
			return 0;
	}

}
