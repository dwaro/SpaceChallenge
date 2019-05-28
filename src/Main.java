import java.io.FileNotFoundException;
//import java.nio.file.Path;
//import java.nio.file.Paths;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Simulation simulation = new Simulation();
		
		//U1
		ArrayList<U1> u1p1 = simulation.loadU1("./src/phase-1.txt");
		ArrayList<U1> u1p2 = simulation.loadU1("./src/phase-2.txt");
		int u1budget = simulation.runSimulationU1(u1p1);
		u1budget += simulation.runSimulationU1(u1p2);
		
		
		//U2
		ArrayList<U2> u2p1 = simulation.loadU2("./src/phase-1.txt");
		ArrayList<U2> u2p2 = simulation.loadU2("./src/phase-2.txt");
		int u2budget = simulation.runSimulationU2(u2p1);
		u2budget += simulation.runSimulationU2(u2p2);
		
		System.out.println();
		System.out.println("U1 Rocket Expense: " + String.valueOf(u1budget));
		System.out.println("==================================");
		System.out.println("U2 Rocket Expense: " + String.valueOf(u2budget));
		
	}

}
