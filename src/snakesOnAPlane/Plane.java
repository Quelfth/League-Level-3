package snakesOnAPlane;

import java.util.ArrayList;

public class Plane {
	int numberOfPassengers;
	ArrayList<Snake> snakes = new ArrayList<>();
	
	public Plane(int numberOfPassengers){
		this.numberOfPassengers = numberOfPassengers;
	}
	public void add(Snake s){
		snakes.add(s);
	}
}
