import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Downfall  {
JFrame frame;
GamePanel panel;
public Ball ball;
static int width = 500;
static int height = 800;
	public static void main(String[] args) {
	Downfall downfall = new Downfall();
	downfall.setup();
}
		public Downfall() {
			frame = new JFrame();
			panel = new GamePanel();
			ball = new Ball(250,50,10,10);
		}
		void setup() {
			frame.addKeyListener(panel);
			frame.add(panel);
			frame.pack();
			frame.setSize(width,height);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			panel.startGame();
		}
}
