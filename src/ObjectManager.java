import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
	import java.util.Random;
public class ObjectManager {
	ArrayList <Coin> coins = new ArrayList<Coin> ();
	ArrayList <Lava> lava = new  ArrayList<Lava>();
	int score = 0;
	Ball ball;
	
	ObjectManager(Ball ball, Coin coin,Lava lava1, Lava lava2,Lava lava3,Lava lava4){
	this.ball = ball;
	lava1 = new Lava(200,780,25,25);
	lava2 = new Lava(200,350,25,25);
	lava3 = new Lava(200,80,25,25);
	lava4 = new Lava(200,700,25,25);
	coins.add(coin);
	lava.add(new Lava(200,780,25,25));
}
	void draw(Graphics g) {
		ball.draw(g);
	for(Coin coin:coins) {
		coin.draw(g);
	}
	for(Lava lava:lava) {
		lava.draw(g);
	}
	}
	void update() {
		ball.update();
		for(Coin coin:coins) {
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
		for(Coin coin:coins) {
			if(ball.rect.intersects(coin.rect)) {
				coin.reset();
				score++;
				if(score%6==0) {
					lava.add(new Lava(200,780,25,25));
					coins.add(new Coin(250,800,25,25));
				}
			}
		}
	}
	
	
}

