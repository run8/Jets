package com.skilldistillery.jets.entity;

public class Tanker extends Jet implements TankerActivities {
	private int refuelCapacity;
	
	public Tanker(String model, int speed, int range, int price, int refuelCapacity) {
		super(model, speed, range, price);
		this.refuelCapacity = refuelCapacity;
	}

	public Tanker() {
	}

	@Override
	public void refuelAJet() {
		System.out.println("Conducting aerial refueling.");
	}

	public int getRefuelCapacity() {
		return refuelCapacity;
	}

	public void setRefuelCapacity(int numFlares) {
		this.refuelCapacity = numFlares;
	}

}
