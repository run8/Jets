package com.skilldistillery.jets.entity;

public abstract class Jet {
	private String model;
	private int speed;
	private int range;
	private int price;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Jet(String model, int speed, int range, int price) {
//		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}
	
	public Jet () {
//		super();
	}

	public void fly() {
		System.out.println("Jet Info \nmodel: " + model + "\nspeed: "
				+ speed + "\nrange: " + range + "\nprice: " + price);
		System.out.println("Remaining flight minutes at " + speed + " MPH: "  + range / (speed / 60));
	}

	@Override
	public String toString() {
		return "Model: " + model + ", speed: " + speed + ", range: " + range + ", price: " + price;
	}
	
	
	
}
