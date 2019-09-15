import java.awt.Graphics;import java.awt.event.KeyEvent;
import java.util.ArrayList;
	import java.util.Random;
public class ObjectManager {
	ArrayList <Platforms> platforms = new <Platforms> ArrayList();
	int score = 0;
	Ball ball;
	ObjectManager(Ball ball){
	this.ball = ball;
}
	void draw(Graphics g) {
		ball.draw(g);
	}
	void update() {
		ball.update();
			}
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyCode());
		if(e.getKeyCode()==87) {
			ball.fallSpeed-=ball.speed;
			}
		if(e.getKeyCode()==83) {
			ball.y+=ball.speed;
		}
		if(e.getKeyCode()==65) {
			ball.x-=ball.speed;
		}
		if(e.getKeyCode()==68) {
			ball.x+=ball.speed;
		}
		}
	}
	
	

