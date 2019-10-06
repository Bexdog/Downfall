import java.awt.Rectangle;

import com.sun.prism.Graphics;

public class GameObject  {
	int x;
    int y;
    int width;
    int height;
    boolean isAlive;
    Rectangle rect;
   public GameObject(int x,int y,int width,int height) {
	   this.x=x;
	   this.y=y;
	   this.width=width;
	   this.height=height;
	   this.rect = new Rectangle();
	   
	   isAlive  = true;
   }
   void update() {
	  rect.setBounds(this.x,this.y,this.width,this.height);
   }
  
   
}

