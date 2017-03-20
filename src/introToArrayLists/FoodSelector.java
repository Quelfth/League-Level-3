package introToArrayLists;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class FoodSelector {
	public static ArrayList<String> foodOptions = new ArrayList<>();
	
	public static void main(String[] args){
		foodOptions.add("Beef and Broccoli");
		foodOptions.add("Cheese Stew");
		foodOptions.add("Death Cabbage");
		Random r = new Random();
		JOptionPane.showMessageDialog(null, foodOptions.get(r.nextInt(3)));
	}
}
