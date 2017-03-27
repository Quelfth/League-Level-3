package snakesOnAPlane;

import java.util.Random;

public class Randomness {
	static Random r = new Random();
	public static boolean Bool(){
		return r.nextBoolean();
	}
	
	public static int Int(){
		return r.nextInt(9) + 1;
	}
}
