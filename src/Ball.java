import java.awt.Graphics;

public class Ball {
	int x;
	int y;
	int width;
	int height;
	int speed;
	public Ball(int x, int y, int width, int height) {
		this.x = x;
		this.y=y;
		this.width=width;
		this.height=height;
		speed=8;
	}
	public void draw(Graphics g) {
		  g.fillOval(x, y, width, height);
	}
}
