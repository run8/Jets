package com.skilldistillery.jets.entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class AirField {
	private List<Jet> jets = new ArrayList<Jet>();

	public static void main(String[] args) {
		AirField af = new AirField();
		af.readFileGenerateJetsList("jets.txt");
	}

	public AirField() {

	}

	public AirField(List<Jet> jets) {
		super();
		this.jets = jets;
	}

	public List<Jet> getJets() {
		return jets;
	}

//	public void setJets(Jet[] jets) {
//		this.jets = jets;
//	}

	public List<Jet> readFileGenerateJetsList(String fileName) {

		try {
//			jets = new
			BufferedReader file = new BufferedReader(new FileReader(fileName));
			String line;
			while ((line = file.readLine()) != null) {
				String[] jetData = line.split(", ");
				if (jetData[0].equals("F22")) {
//					System.out.println(line);
					String model = jetData[0];
					int speed = Integer.parseInt(jetData[1]);
					int range = Integer.parseInt(jetData[2]);
					int price = Integer.parseInt(jetData[3]);
					int numMissiles = Integer.parseInt(jetData[4]);
					F22 f22 = new F22(model, speed, range, price, numMissiles);
					jets.add(f22);
				} else if (jetData[0].equals("tanker")) {
					String model = jetData[0];
					int speed = Integer.parseInt(jetData[1]);
					int range = Integer.parseInt(jetData[2]);
					int price = Integer.parseInt(jetData[3]);
					int refuelCapacity = Integer.parseInt(jetData[4]);
					Tanker tanker = new Tanker(model, speed, range, price, refuelCapacity);
					jets.add(tanker);

				} else {
					String model = jetData[0];
					int speed = Integer.parseInt(jetData[1]);
					int range = Integer.parseInt(jetData[2]);
					int price = Integer.parseInt(jetData[3]);
					Jet jet = new JetImplement(model, speed, range, price);
					jets.add(jet);
				}
			}
			file.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return jets;
	}
}
