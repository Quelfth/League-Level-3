package introToArrays;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class IntroToArrays {
	public static void main(String[] args){
		String In = JOptionPane.showInputDialog("Gimme some numbers:");
		String[] InList = In.split(", ");
		int[] inList = new int[InList.length];
		for(int i = 0; i < InList.length; i++){
			inList[i] = Integer.parseInt(InList[i]);
		}
		System.out.println("in: " + Arrays.toString(inList));
		for(int i = 0; i < inList.length; i++)
			for(int j = 0; j < inList.length - 1; j++)
				if(inList[j] > inList[j + 1]){
					int inJ = inList[j];
					inList[j] = inList[j+1];
					inList[j+1] = inJ;
				}
		System.out.println("out: " + Arrays.toString(inList));
	}
}
