package stanfordPyramid;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class StanfordPyramid {
	public static final int BRICK_WIDTH = 30;
	public static final int BRICK_HEIGHT = 12;
	public static final int BRICKS_IN_BASE = 14;
	public static final int WINDOW_PADDING = 15;
	protected static JFrame frame = new JFrame();
	protected static JPanel panel = new JPanel() {
		@Override
		public void paint(Graphics g) {
			for (int i = 0; i < BRICKS_IN_BASE; i++)
				for (int j = 0; j < BRICKS_IN_BASE - i; j++)
					g.drawRect(WINDOW_PADDING + BRICK_WIDTH * (j + (BRICKS_IN_BASE - i) / 2), 0/* fix */, 0/* fix */, 0/* fix */);
		}
	};

	public static void main(String[] args) {
		frame.add(panel);
		frame.setVisible(true);
		panel.setPreferredSize(new Dimension((BRICK_WIDTH * BRICKS_IN_BASE) + WINDOW_PADDING * 2, BRICK_HEIGHT * BRICKS_IN_BASE + WINDOW_PADDING));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		while (true) {
			frame.pack();
			panel.repaint();
		}
	}
}
