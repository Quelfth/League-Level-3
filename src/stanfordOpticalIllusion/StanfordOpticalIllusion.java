package stanfordOpticalIllusion;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class StanfordOpticalIllusion {
	public static final int BOXES_PER_SIDE = 4;
	public static final int BOX_SIZE = 100;
	public static final int BOX_SPACING = 10;
	public static final int WINDOW_PADDING = 15;
	protected static JFrame frame = new JFrame();
	protected static JPanel panel = new JPanel() {
		@Override
		public void paint(Graphics g) {
			for (int i = 0; i < BOXES_PER_SIDE; i++)
				for (int j = 0; j < BOXES_PER_SIDE; j++)
					g.fillRect(WINDOW_PADDING + (BOX_SPACING + BOX_SIZE) * i, WINDOW_PADDING + (BOX_SPACING + BOX_SIZE) * j, BOX_SIZE, BOX_SIZE);

		}
	};

	public static void main(String[] args) {
		frame.add(panel);
		frame.setVisible(true);
		panel.setPreferredSize(new Dimension(WINDOW_PADDING * 2 + BOX_SIZE * BOXES_PER_SIDE + BOX_SPACING * (BOXES_PER_SIDE - 1),
				WINDOW_PADDING * 2 + BOX_SIZE * BOXES_PER_SIDE + BOX_SPACING * (BOXES_PER_SIDE - 1)));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		while (true) {
			frame.pack();
			panel.repaint();
		}
	}
}
