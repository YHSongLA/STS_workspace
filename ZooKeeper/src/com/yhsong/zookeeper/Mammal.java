package com.yhsong.zookeeper;

public class Mammal {
	// Member Variables
	protected int energyLevel;
	
	// Full Constructor
	public Mammal(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	// Empty Constructor
	public Mammal() {
		this.energyLevel = 50;
	}
	// Getter / Setter / Other Methods
	public int getEnergyLevel() {
		return energyLevel;
	}
	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	
	
}
