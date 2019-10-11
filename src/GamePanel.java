import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
public class GamePanel extends JPanel  implements KeyListener, ActionListener {
public int currentstate = 0;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	final int WIN_STATE = 4;
	Font titleFont;
	Font otherFonts;
	Timer framerate;
	boolean sound = true;
	int x =250;
	int y = 50;
	Ball ball;
	Coin coin;
	Lava lava1;
	Lava lava2;
	Lava lava3;
	Lava lava4;
	Random randy = new Random();	
	ObjectManager manager;
	public static BufferedImage lavaBubble;
	public static BufferedImage lava;
	public static BufferedImage coin1;
	public GamePanel(){
		
		 try {
			lavaBubble = ImageIO.read(this.getClass().getResourceAsStream("Lava_Bubble.png"));
			lava = ImageIO.read(this.getClass().getResourceAsStream("Lava.png"));
			coin1 = ImageIO.read(this.getClass().getResourceAsStream("coin.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		titleFont = new Font("Arial",Font.BOLD,50);
		otherFonts = new Font("Arial",Font.PLAIN,25);
		framerate= new Timer(1000/60,this);
		ball = new Ball(250,50,15,15);
		coin = new Coin(250,400,25,25);
		
		manager = new ObjectManager(ball, coin,lava1,lava2,lava3,lava4);
		
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
			if(sound) {
				playSound("marioBoing.wav");
				}
			}
		if(e.getKeyCode()==32&&currentstate==GAME_STATE) {
			ball.speed=-10;
			if(sound) {
			playSound("marioBoing.wav");
			}			
			}
		if(e.getKeyCode()==90) {
				if(sound) {
					sound = false;
				}
				else {
					sound = true;
				}
			}
		if(e.getKeyCode()==83) {
			ball.y+=ball.speed;
		}
		if(e.getKeyCode()==38) {
			ball.speed=-10;
			if(sound) {
				playSound("marioBoing.wav");
				}
			}
		if(e.getKeyCode()==65) {
			ball.horasoltalSpeed=-5;
		}
		if(e.getKeyCode()==37) {
			ball.horasoltalSpeed=-5;
		}
		if(e.getKeyCode()==32&&currentstate==MENU_STATE) {
			JOptionPane.showMessageDialog(null, "To play, use the w,a,s,d keys to move, space is also jump."+"\n"+" Try and get 20 coins to win, while avoiding the lava, which gets madder every 6 coins you get. Press 'z' to change sound on or off."+"\n"+"Note: having sound on might invoke lag");
			}
		if(e.getKeyCode()==68) {
			ball.horasoltalSpeed=+5;
		}
		if(e.getKeyCode()==39) {
			ball.horasoltalSpeed=+5;
		}
		if(e.getKeyCode()==10) {
			currentstate++;
			if(currentstate == 3||currentstate==5) {
				currentstate=MENU_STATE;
			}
			if(currentstate == 1) {
				manager.lava.add(new Lava(200,700,25,25));
				manager.coins.add(new Coin(250,400,25,25));
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
		manager.score=0;
		manager.lava.clear();
		manager.coins.clear();
		
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
	
	g.drawImage(GamePanel.lava,0, 0,500,800,null );
		
		
		//manager.draw(g);
		g.setFont(otherFonts);
		g.setColor(new Color((int)randy.nextInt(256),(int)randy.nextInt(256),(int)randy.nextInt(256)));
		
		manager.draw(g);
		manager.update();
		manager.checkCollisions();
		if(ball.isAlive==false) {
			currentstate++;
		}
		
		
	}
void drawEndState(Graphics g){
	for(Lava lava:manager.lava) {
		lava.reset();
	}
	for(Coin coin:manager.coins) {
		coin.reset();
	}
	if(currentstate == 2) {
		if(manager.score>=20) {
			currentstate=4;
				
			
		}
	}
	
	
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
	g.drawString("You got "+manager.score+" coins", 120, 325);
	g.drawString("Press ENTER To Restart", 95, 450);
	
}
void drawWinState(Graphics g){
	
	g.setColor(Color.green);
	g.fillRect(0, 0, Downfall.width, Downfall.height);
	g.setColor(Color.black);
	g.setFont(titleFont);
	g.drawString("You Win!", 100, 175);
	g.setFont(otherFonts);
	g.drawString("You got "+manager.score+" coins", 120, 325);
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
    else if(currentstate == WIN_STATE) {
    	drawWinState(g);
    }
}
	private void playSound(String fileName) {
		AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
		sound.play();
	}
}
