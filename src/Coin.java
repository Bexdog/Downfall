	import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;
public class Coin extends GameObject{
int randy;
boolean isAlive;
	public Coin(int x, int y, int width, int height) {
		super(x, y, width, height);
		isAlive = true;
		randy = new Random().nextInt(490);
		// TODO Auto-generated constructor stub
	}
	void draw(Graphics g) {
		
		g.setColor(Color.YELLOW);
		g.drawImage(GamePanel.coin1,x, y, width ,height,null);
	}
	void update() {
		y-=3;
		super.update();
		if(y<=0) {
			reset();
			if(ObjectManager.score<20) {
			ObjectManager.score--;
			}
		}
		randy = new Random().nextInt(490);
	}
	void reset (){
		y=800;
		super.update();
		randy = new Random().nextInt(490);
		x=randy+5;
	}
}
