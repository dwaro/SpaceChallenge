
public class U2 extends Rocket {
	//Chance of launch explosion = 4% * (cargo carried / cargo limit)
	//Chance of landing crash = 8% * (cargo carried / cargo limit)
	private double chanceOfLaunchCrash;
	private double chanceOfLandCrash;
	private double randomLaunch;
	private double randomLand;
	
	U2() {
		super.setMaxWeight(29);
		super.setCost(120);
		super.setRocketWeight(18);
	}
	
	public boolean launch() {
		randomLaunch = Math.random() * 8;
		chanceOfLaunchCrash = 4 * (super.getRocketWeight() / super.getMaxWeight());
		if (chanceOfLaunchCrash > randomLaunch) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean land() {
		randomLand = Math.random() * 16;
		chanceOfLandCrash = 8 * (super.getRocketWeight() / super.getMaxWeight());
		if (chanceOfLandCrash > randomLand) {
			return false;
		} else {
			return true;
		}
	}
}
