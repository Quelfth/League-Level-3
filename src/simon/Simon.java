package simon;

import java.awt.*;

import javax.swing.*;

public class Simon {
	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel(){
		@Override
		public void paint(Graphics g){
			g.setColor(new Color(127, 0, 0));
			int[] redXs = {220, 320, 220, 120};
			int[] redYs = {10, 110, 210, 110};
			g.fillPolygon(redXs, redYs, 4);
			g.setColor(new Color(0, 0, 127));
			int[] blueXs = {330, 430, 330, 230};
			int[] blueYs = {120, 220, 320, 220};
			g.fillPolygon(blueXs, blueYs, 4);
			g.setColor(new Color(0, 127, 0));
			int[] greenXs = redXs;
			int[] greenYs = {230, 330, 430, 330};
			g.fillPolygon(greenXs, greenYs, 4);
			g.setColor(new Color(127, 127, 0));
			int[] yellowXs = {110, 210, 110, 10};
			int[] yellowYs = blueYs;
			g.fillPolygon(yellowXs, yellowYs, 4);
		}
	};
	
	public static void main(String[] args){
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setPreferredSize(new Dimension(440, 440));
		frame.pack();
	}
}
