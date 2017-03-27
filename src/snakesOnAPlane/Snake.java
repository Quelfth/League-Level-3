package snakesOnAPlane;

public class Snake {
	int viciousness = 0;
	boolean venomous = false;
	
	public Snake(int vic, boolean ven){
		viciousness = vic;
		venomous = ven;
	}
	
	public int getViciousness(){
		return viciousness;
	}
	
	public boolean getVenomous(){
		return venomous;
	}
}
