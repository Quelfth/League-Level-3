package introToArrayLists;

import java.util.*;
public class ArrayListFiller {
	public static ArrayList<Byte> arr = new ArrayList<>();
	public static void main(String[] args){
		while(true)
			try{
				arr.add((byte) 1);
			}catch(OutOfMemoryError e){
				System.out.println(arr.size());
				break;
			}
	}
}