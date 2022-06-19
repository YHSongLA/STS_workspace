package com.yhsong.zookeeper;

public class Bat extends Mammal {
	// Constructors
	public Bat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bat(int energyLevel) {
		super(energyLevel);
		// TODO Auto-generated constructor stub 
	}
	// Getter | Setter
	public int fly() {
		energyLevel -= 50;
		System.out.println("Flap flap flap " + ("Energy Level: " + energyLevel));
		return energyLevel;
	}
	
	public int eatHumans() {
		energyLevel += 25;
		System.out.println("Slurp! " + ("Energy Level: " + energyLevel));
		return energyLevel;
	}
	
	public int attackTown() {
		energyLevel -= 100;
		System.out.println("The town is on Fire! " + ("Energy Level: " + energyLevel));
		return energyLevel;
	}
}
