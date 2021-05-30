package com.skilldistillery.jets.entity;

public class F22 extends Jet implements FighterActivities {
	private int numMissiles;

	public F22() {
	}
	
	public F22(String model, int speed, int range, int price, int numMissiles) {
		super(model, speed, range, price);
		this.numMissiles = numMissiles;
	}

	public void activateWeaponSystems() {
		System.out.println("Weapon systems activated.");
	}

	public int getNumMissiles() {
		return numMissiles;
	}

	public void setNumMissiles(int numMissiles) {
		this.numMissiles = numMissiles;
	}
	

}
