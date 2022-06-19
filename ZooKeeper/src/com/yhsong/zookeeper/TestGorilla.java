package com.yhsong.zookeeper;

public class TestGorilla {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Gorilla ben = new Gorilla();
		ben.throwSomething();
		ben.eatBananas();
		ben.climb();
		
		Bat jim = new Bat(300);
		jim.fly();
		jim.fly();
		jim.eatHumans();
		jim.eatHumans();
		jim.attackTown();
		jim.attackTown();
		jim.attackTown();
		
	}

}
