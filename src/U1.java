
public class U1 extends Rocket {
	//Chance of launch explosion = 5% * (cargo carried / cargo limit)
	//Chance of landing crash = 1% * (cargo carried / cargo limit)
	private double chanceOfLaunchCrash;
	private double chanceOfLandCrash;
	private double randomLaunch;
	private double randomLand;
	
	U1() {
		super.setMaxWeight(18);
		super.setCost(100);
		super.setRocketWeight(10);
	}
	
	public boolean launch() {
		randomLaunch = Math.random() * 10;
		chanceOfLaunchCrash = 5 * (super.getRocketWeight() / super.getMaxWeight());
		if (chanceOfLaunchCrash > randomLaunch) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean land() {
		randomLand = Math.random() * 2;
		chanceOfLandCrash = 1 * (super.getRocketWeight() / super.getMaxWeight());
		if (chanceOfLandCrash > randomLand) {
			return false;
		} else {
			return true;
		}
	}
	
}
