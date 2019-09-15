import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
public class Ball extends GameObject{
	
	int speed;
	int fallSpeed;
	boolean up;
	boolean down;
	boolean left;
	boolean right;
	public Ball(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed=90;
		fallSpeed = 2;
	}
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillOval(x, y, width, height);
	}
	void update() {
		super.update();
		this.y+=fallSpeed;
	}
}
