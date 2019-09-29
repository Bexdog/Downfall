import java.awt.Graphics;import java.awt.event.KeyEvent;
import java.util.ArrayList;
	import java.util.Random;
public class ObjectManager {
	ArrayList <Coins> coins = new ArrayList<Coins> ();
	ArrayList <Lava> lava = new  ArrayList<Lava>();
	int score = 0;
	Ball ball;
	
	ObjectManager(Ball ball, Coins coin,Lava lava1, Lava lava2,Lava lava3,Lava lava4){
	this.ball = ball;
	
	coins.add(coin);
	lava.add(lava1);
	lava.add(lava2);
	lava.add(lava3);
	lava.add(lava4);
}
	void draw(Graphics g) {
		ball.draw(g);
	for(Coins coin:coins) {
		coin.draw(g);
	}
	for(Lava lava:lava) {
		lava.draw(g);
	}
	}
	void update() {
		ball.update();
		for(Coins coin:coins) {
			coin.update();
		}
		for(Lava lava:lava) {
			lava.update();
		}
			}
	void checkCollisions() {
		for(Lava lava : lava) {
			if(ball.rect.intersects(lava.rect)) {				
				ball.isAlive=false;
			}
			
		}
		for(Coins coin:coins) {
			if(ball.rect.intersects(coin.rect)) {
				coin.reset();
				score++;
			}
		}
	}
	
	
}

