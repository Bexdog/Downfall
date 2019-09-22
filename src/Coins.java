	import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
public class Coins extends GameObject{
int randy;
boolean isAlive;
	public Coins(int x, int y, int width, int height) {
		super(x, y, width, height);
		isAlive = true;
		randy = new Random().nextInt(500);
		// TODO Auto-generated constructor stub
	}
	void draw(Graphics g) {
		
		g.setColor(Color.YELLOW);
		g.fillOval(x, y, width, height);
	}
	void update() {
		y-=3;
		super.update();
		if(y<=0) {
			y=800;
			x=randy;
		}
		randy = new Random().nextInt(500);
	}
}
