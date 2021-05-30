package com.skilldistillery.jets.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.entity.AirField;
import com.skilldistillery.jets.entity.F22;
import com.skilldistillery.jets.entity.Jet;
import com.skilldistillery.jets.entity.JetImplement;
import com.skilldistillery.jets.entity.Tanker;

public class JetsApplication {

	public static void main(String[] args) {
		JetsApplication jetApp = new JetsApplication();
		jetApp.run();

	}

	public void run() {
		boolean quit = false;
		Scanner scanner = new Scanner(System.in);
		AirField af = new AirField();
		af.readFileGenerateJetsList("jets.txt");
		List<Jet> jetList = af.getJets();

		while (!quit) {
			presentMenu();
			int menuSelection = scanner.nextInt();
			switch (menuSelection) {
			case 1:
				listFleet(jetList);
				break;
			case 2:
				flyAllJets(jetList);
				break;
			case 3:
				ViewFastestJet(jetList);
				break;
			case 4:
				viewLongestRangeJet(jetList);
				break;
			case 5:
				viewAllTankerActivities(jetList);
				break;
			case 6:
				viewFighterActivities(jetList);
				break;
			case 7:
				addJetToFleet(scanner, jetList);
				break;
			case 8:
				removeJetFromFleet(scanner, jetList);
				break;
			case 9:
				quit = quit();
				break;
			default:
				break;
			}
		}

		scanner.close();
	}

	public void listFleet(List<Jet> jetList) {
		for (Jet jet : jetList) {
			System.out.println(jet.toString());
		}
		System.out.println("////////////////////////////////////////////////////\n");
	}

	public void flyAllJets(List<Jet> jetList) {
		for (Jet jet : jetList) {
			jet.fly();
			System.out.println("////////////////////////////////////////////////////\n");
		}
	}

	public void ViewFastestJet(List<Jet> jetList) {
		Jet fastest = new JetImplement();

		for (Jet jet : jetList) {
			if (jet.getSpeed() > fastest.getSpeed()) {
				fastest = jet;
			}
		}
		System.out.println("Fastest jet: " + fastest.toString());
		System.out.println("////////////////////////////////////////////////////\n");
	}

	public void viewLongestRangeJet(List<Jet> jetList) {
		Jet longestRange = new JetImplement();

		for (Jet jet : jetList) {
			if (jet.getRange() > longestRange.getRange()) {
				longestRange = jet;
			}
		}
		System.out.println("Longest range jet: " + longestRange.toString());
		System.out.println("////////////////////////////////////////////////////\n");
	}

	public void viewAllTankerActivities(List<Jet> jetList) {
		for (Jet jet : jetList) {
			if (jet instanceof Tanker) {
				((Tanker) jet).refuelAJet();
			}
		}
		System.out.println("////////////////////////////////////////////////////\n");
	}

	public void viewFighterActivities(List<Jet> jetList) {
		for (Jet jet : jetList) {
			if (jet instanceof F22) {
				((F22) jet).activateWeaponSystems();
			}
		}
		System.out.println("////////////////////////////////////////////////////\n");
	}

	public void addJetToFleet(Scanner scanner, List<Jet> jetList) {
		System.out.println("Enter the jet model: ");
		String model = scanner.next();
		System.out.println("Enter max speed in MPH: ");
		int speed = scanner.nextInt();
		System.out.println("Enter range: ");
		int range = scanner.nextInt();
		System.out.println("Enter dollar price: ");
		int price = scanner.nextInt();
		JetImplement jet = new JetImplement(model, speed, range, price);
		jetList.add(jet);
		System.out.println("Jet added to fleet: " + jet.toString());
		System.out.println("////////////////////////////////////////////////////\n");
	}

	public void removeJetFromFleet(Scanner scanner, List<Jet> jetList) {
		System.out.println("Select the jet to remove from fleet.");
		int num = 1;
		for (Jet jet : jetList) {
			System.out.println(num + " " + jet.toString());
			num++;
		}
		System.out.println("////////////////////////////////////////////////////\n");
		int selection = scanner.nextInt();
		System.out.println("Jet removed from fleet: " + jetList.remove(selection - 1));
//		jetList.remove(selection);
		System.out.println("////////////////////////////////////////////////////\n");
	}

	public boolean quit() {
		System.out.println("Goodbye!");
		return true;
	}

	public void presentMenu() {
		System.out.println("1. List Fleet\n" + "2. Fly all jets\n" + "3. View fastest jet\n"
				+ "4. View jet with longest range\n" + "5. View tankers in action\n" + "6. View fighters in action\n"
				+ "7. Add a jet to the fleet\n" + "8. Remove a jet from the fleet\n" + "9. Quit"
				+ "////////////////////////////////////////////////////\n");
	}

}
