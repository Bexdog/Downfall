	import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;
public class Coins extends GameObject{
int randy;
boolean isAlive;
	public Coins(int x, int y, int width, int height,Rectangle rect) {
		super(x, y, width, height, rect);
		isAlive = true;
		randy = new Random().nextInt(495);
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
			reset();
		}
		randy = new Random().nextInt(500);
	}
	void reset (){
		y=800;
		super.update();
		randy = new Random().nextInt(495);
		x=randy;
	}
}
