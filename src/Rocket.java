public class Rocket implements SpaceShip {
	private int rocketCost;
	private double rocketWeight;
	private int maxWeight;
	
	// success of launching
	public boolean launch() {
		return true;
	}
	
	// success of landing
	public boolean land() {
		return true;
	}
	
	public double getRocketWeight() {
		return rocketWeight;
	}
	
	public void setRocketWeight(double weight) {
		rocketWeight = weight;
	}
	
	public int getMaxWeight() {
		return maxWeight;
	}
	
	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}
	
	public int getCost() {
		return rocketCost;
	}
	
	public void setCost(int cost) {
		rocketCost = cost;
	}
	
	// can the rocket carry such item (will it not exceed the weight limit)
	public boolean canCarry(Item item) {
		if (rocketWeight + item.getWeight() <= maxWeight) {
			return true;
		} else {
			return false;
		}
	}
	
	// update current weight of the rocket
	public void carry(Item item) {
		rocketWeight += item.getWeight();
	}
	
}
