import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class Simulation {
	
	private int expenses;
	
	Simulation() {
		expenses = 0;
	}
	
	// This method loads all items from a text file and returns an ArrayList of items
	private ArrayList<Item> loadItems(String filePath) throws FileNotFoundException {
		File itemsFile = new File(filePath);
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(itemsFile);
		
		ArrayList<Item> itemList = new ArrayList<Item>(); 
		
		while (scanner.hasNextLine()) {
			Item item = new Item();
			String [] line = scanner.nextLine().split("=");
			item.setName(line[0]);
			item.setWeight((Double.parseDouble(line[1])/1000));
			
			itemList.add(item);
		}
		return itemList;
	}
	
	public ArrayList<U1> loadU1(String filepath) throws FileNotFoundException {
		ArrayList<Item> items = loadItems(filepath);
		ArrayList<U1> rocketList = new ArrayList<U1>();
		
		for (int i=0; i < items.size(); i++) {
			U1 newRocket = new U1();
			for (int j=i; j < items.size(); j++) {
				if ((newRocket.getRocketWeight() + items.get(j).getWeight()) <= newRocket.getMaxWeight()) {
					newRocket.setRocketWeight(newRocket.getRocketWeight() + items.get(j).getWeight());
					i++;
				} else {
					i--;
					break;
				}
			}
			rocketList.add(newRocket);
		}
		return rocketList;
	}
	
	public ArrayList<U2> loadU2(String filepath) throws FileNotFoundException {
		ArrayList<Item> items = loadItems(filepath);
		ArrayList<U2> rocketList = new ArrayList<U2>();
		
		for (int i=0; i < items.size(); i++) {
			U2 newRocket = new U2();
			for (int j=i; j < items.size(); j++) {
				if ((newRocket.getRocketWeight() + items.get(j).getWeight()) <= newRocket.getMaxWeight()) {
					newRocket.setRocketWeight(newRocket.getRocketWeight() + items.get(j).getWeight());
					i++;
				} else {
					i--;
					break;
				}
			}
			rocketList.add(newRocket);
		}
		
		return rocketList;
	}
	
	public int runSimulationU1(ArrayList<U1> rocketList) {
		expenses = 0;
		for (U1 rocket: rocketList) {
			expenses += performSimU1(rocket, 0);
			expenses += rocket.getCost();
		}
		return expenses;
	}
	
	private int performSimU1(U1 rocket, int expenses) {
		int budget = expenses;
		while (!rocket.launch()) {
			budget += rocket.getCost();
		}
		while (!rocket.land()) {
			budget += rocket.getCost();
			performSimU1(rocket, budget);
		}
		return budget;
	}
	
	public int runSimulationU2(ArrayList<U2> rocketList) {
		expenses = 0;
		for (U2 rocket: rocketList) {
			expenses += performSimU2(rocket, 0);
			expenses += rocket.getCost();
		}
		return expenses;
	}
	
	private int performSimU2(U2 rocket, int expenses) {
		int budget = expenses;
		while (!rocket.launch()) {
			budget += rocket.getCost();
		}
		while (!rocket.land()) {
			budget += rocket.getCost();
			performSimU2(rocket, budget);
		}
		return budget;
	}
	
}
