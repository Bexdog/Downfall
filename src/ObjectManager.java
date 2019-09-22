import java.awt.Graphics;import java.awt.event.KeyEvent;
import java.util.ArrayList;
	import java.util.Random;
public class ObjectManager {
	ArrayList <Coins> coins = new <Coins> ArrayList();
	int score = 0;
	Ball ball;
	Coins coin;
	ObjectManager(Ball ball, Coins coin){
	this.ball = ball;
	this.coin = coin;
}
	void draw(Graphics g) {
		ball.draw(g);
		coin.draw(g);
	}
	void update() {
		ball.update();
		coin.update();
		
			}
}
	
	
	

