package com.yhsong.zookeeper;

public class Gorilla extends Mammal{
	// Constructors
	public Gorilla() {
		super();
	}
	
	public Gorilla(int energyLevel) {
		super(energyLevel);
	}
	
	// Getter | Setter | Other Methods
	public int throwSomething() {
		energyLevel -= 5;
		System.out.println("Throws poop! " + ("Energy Level: " + energyLevel));
		return energyLevel;
	}
	
	public int eatBananas() {
		energyLevel += 10;
		System.out.println("Eats Banana~ " + ("Energy Level: " + energyLevel));
		return energyLevel;
	}
	
	public int climb() {
		energyLevel -= 10;
		System.out.println("Climbs a tree " + ("Energy Level: " + energyLevel));
		return energyLevel;
	}
}
