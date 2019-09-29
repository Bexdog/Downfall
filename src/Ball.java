import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
public class Ball extends GameObject{
	boolean isAlive;
	double speed;
	double horasoltalSpeed;
	boolean up;
	boolean down;
	boolean left;
	boolean right;
	
	public Ball(int x, int y, int width, int height,Rectangle rect) {
		super(x, y, width, height, rect);
		speed=2;
		horasoltalSpeed = 0;
		isAlive = true;
	}
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillOval(x, y, width, height);
	}
	void update() {
		super.update();
		this.y+=speed;
		this.speed+=0.5;
		this.x+=horasoltalSpeed;
		if(horasoltalSpeed>0) {
			horasoltalSpeed-=0.1;
		}
		else if(horasoltalSpeed<0) {
			horasoltalSpeed+=0.1;
			}
		if(this.y>=760) {
			isAlive=false;
		}
		if(this.x>=500) {
			this.x=0;
		}
		else if(this.x<=0) {
			this.x=500;
		}
		
	}
}
