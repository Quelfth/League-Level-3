package visualArraySorter;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class VisualArraySorter {
	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel();

	public static void main(String[] args) {
		final int MAX_ENTRY = Integer.parseInt(JOptionPane.showInputDialog("Max entry:"));
		final int ENTRIES = Integer.parseInt(JOptionPane.showInputDialog("Number of entries:"));
		int[] arr = new int[ENTRIES];
		frame.setVisible(true);
		Random r = new Random();
		for(int i = 0; i < arr.length; i++){
			arr[i] = r.nextInt(MAX_ENTRY);
		}
		panel = new JPanel() {
			@Override
			public void paint(Graphics g) {
				g.setColor(new Color(0, 0, 0));
				g.fillRect(0, 0, frame.getWidth(), frame.getHeight());
				g.setColor(new Color(0, 255, 0));
				for(int i = 0; i < arr.length; i++){
					g.fillRect(i, frame.getHeight() - arr[i], 1, arr[i]);
				}
			}
		};
		frame.add(panel);
		panel.setPreferredSize(new Dimension(ENTRIES, MAX_ENTRY));
		frame.pack();
		for (int i = 0; i < arr.length; i++){
			for (int j = 0; j < arr.length - 1; j++){
				if (arr[j] > arr[j + 1]) {
					int inJ = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = inJ;
					
				}
				panel.repaint();
			}
			try{
				Thread.sleep(1000 / 60);
			}catch(Exception e){
			}
		}
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
