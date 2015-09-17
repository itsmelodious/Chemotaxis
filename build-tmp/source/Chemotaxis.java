import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Chemotaxis extends PApplet {

 Bacteria [] b;   
 public void setup()   
 {      
 	size(500, 500);
 	background(160, 207, 195); 
 	b = new Bacteria[20];
 	for (int i = 0; i < b.length; i++)
 	{
 		int myX = (int)(Math.random()*500);
 		int myY = (int)(Math.random()*500);
 		b[i] = new Bacteria(myX, myY);
 	}
 }   
 public void draw()   
 {    
 	//move and show the bacteria
 	background(131, 171, 161);
 	for (int i = 0; i < b.length; i++)
 	{
 		b[i].move();
 		b[i].show();
 	}   
 }  
 class Bacteria    
 {     
 	int x, y, r, g, b;
 	Bacteria(int bx, int by)
 	{
 		x = bx;
 		y = by;
 		r = (int)(Math.random()*128)+127;
 		g = (int)(Math.random()*128)+127;
 		b = (int)(Math.random()*128)+127;
 	}
 	public void move()
 	{
 		x = x + (int)(Math.random()*3)-1;
 		y = y + (int)(Math.random()*3)-1;
 	}
 	public void show()
 	{
 		strokeWeight(0.5f);
 		stroke(255);
 		fill(r, g, b);
 		ellipse(x, y, 10, 10);
 	}
 }    
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Chemotaxis" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
