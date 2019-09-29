import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Lava extends GameObject {
int randy;
int angle;
int speed;
boolean left;
boolean up = true;
	public Lava(int x, int y, int width, int height, Rectangle rect) {
		super(x, y, width, height, rect);
		// TODO Auto-generated constructor stub
		randy = new Random().nextInt(Downfall.width);
		angle = new Random().nextInt(15);
		speed = new Random().nextInt(8)+3;
	}
	void reset (){
		y=780;
		super.update();
		x=randy;
		up=true;
		angle = new Random().nextInt(15);
		speed = new Random().nextInt(8)+3;
		randy = new Random().nextInt(Downfall.width);
	}
	void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillOval(x, y, width ,height );
	}
	void update() {
		super.update();
		
		if(up) {
			y-=speed;
			x+=angle;
		}
		else {
			y+=speed;
			x+=angle;
		}
		if(y<=10) {
			if(up) {
				up=false;
				
			}
			else {
				up=true;
			}
		}
		if(x<=0) {
			angle=-angle;
		}
		else if(x>=Downfall.width) {
			angle=-angle;
		}
		if(y>=800) {
			reset();
			
		}
	}
}
