import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;
public class GamePanel extends JPanel  implements KeyListener, ActionListener {
public int currentstate = 0;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	Font titleFont;
	Font otherFonts;
	Timer framerate;
	int x =250;
	int y = 50;
	Ball ball;
	Coins coin;
	ObjectManager manager;
	public GamePanel(){
		titleFont = new Font("Arial",Font.BOLD,50);
		otherFonts = new Font("Arial",Font.PLAIN,25);
		framerate= new Timer(1000/60,this);
		ball = new Ball(250,50,15,15);
		coin = new Coins(250,400,15,15);
		manager = new ObjectManager(ball, coin);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyCode());
		if(e.getKeyCode()==87) {
			ball.speed=-10;
			}
		if(e.getKeyCode()==32) {
			ball.speed=-10;
			}
		if(e.getKeyCode()==83) {
			ball.y+=ball.speed;
		}
		if(e.getKeyCode()==65) {
			ball.horasoltalSpeed=-5;
		}
		if(e.getKeyCode()==68) {
			ball.horasoltalSpeed=+5;
		}		
		if(e.getKeyCode()==10) {
			currentstate++;
			if(currentstate == 3) {
				currentstate=0;
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void startGame() {
		framerate.start();
	}
	void drawMenuState(Graphics g) {
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Downfall.width, Downfall.height);    
		g.setColor(Color.WHITE);
		g.setFont(titleFont);
		g.drawString("Downfall", 150, 200);
		g.setFont(otherFonts);
		g.drawString("Press ENTER To Start", 120, 325);
		g.drawString("Press SPACE For Instructions", 85, 450);
	}
void drawGameState(Graphics g){
	
	g.setColor(Color.BLACK);
		g.fillRect(0, 0, Downfall.width, Downfall.height);
		//manager.draw(g);
		g.setFont(otherFonts);
		g.setColor(Color.WHITE);
		ball.draw(g);
		coin.draw(g);
		manager.update();
		if(ball.isAlive==false) {
			currentstate++;
		}
	}
void drawEndState(Graphics g){
	ball.isAlive=true;
	ball.y=0;
	ball.x=250;
	ball.speed=0;
	g.setColor(Color.RED);
	g.fillRect(0, 0, Downfall.width, Downfall.height);
	g.setColor(Color.black);
	g.setFont(titleFont);
	g.drawString("Game Over", 100, 175);
	g.setFont(otherFonts);
	g.drawString("You got "+" coins", 120, 325);
	g.drawString("Press ENTER To Restart", 95, 450);
}
	@Override
	public void actionPerformed(ActionEvent e) {
		this.repaint();
		if(currentstate == MENU_STATE){

            //updateMenuState();

    }else if(currentstate == GAME_STATE){

           // updateGameState();

    }else if(currentstate == END_STATE){

           // updateEndState();

    }
		
	}
	public void paintComponent(Graphics g){
		if(currentstate == MENU_STATE){

            drawMenuState(g);

    }else if(currentstate == GAME_STATE){

            drawGameState(g);

    }else if(currentstate == END_STATE){

           drawEndState(g);

    }
}
}
