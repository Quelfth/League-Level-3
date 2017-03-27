package snakesOnAPlane;

public class SnakesOnAPlane {
	static Plane plane = new Plane(30);
	public static void main(String[] args){
		for(int i = 0; i < 100; i++)
			plane.add(new Snake(Randomness.Int(),Randomness.Bool()));
		{
			int totalVenom = 0;
			for(Snake i : plane.snakes)
				totalVenom += i.getVenomous() ? i.viciousness : 0;
			int probabilityOfDeath = (totalVenom*10)/plane.numberOfPassengers;
			probabilityOfDeath = probabilityOfDeath > 100 ? 100 : probabilityOfDeath;
			System.out.println(probabilityOfDeath + "%");
		}
	}
}
