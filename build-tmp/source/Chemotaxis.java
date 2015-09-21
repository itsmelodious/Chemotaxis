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
 	b = new Bacteria[30];
 	for (int i = 0; i < b.length; i++)
 	{
 		int myX = (int)(Math.random()*500);
 		int myY = (int)(Math.random()*500);
 		b[i] = new Bacteria(myX, myY);
 	}
 }   
 public void draw()   
 {    
 	background(131, 171, 161);
 	for (int i = 0; i < b.length; i++)
 	{
 		b[i].move();
 		b[i].show();
 		b[i].food();
 	}   
 }  
 class Bacteria    
 {     
 	int x, y, r, g, b, s, foodR, foodG, foodB;
 	Bacteria(int bx, int by)
 	{
 		x = bx;
 		y = by;
 		r = (int)(Math.random()*128)+127;
 		g = (int)(Math.random()*128)+127;
 		b = (int)(Math.random()*128)+127;
 		s = (int)(Math.random()*10)+5;
 		foodR = (int)(Math.random()*128)+127;
 		foodG = (int)(Math.random()*128)+127;
 		foodB = (int)(Math.random()*128)+127;
 	}
 	public void move()
 	{
 		x = x + (int)(Math.random()*3)-1;
 		y = y + (int)(Math.random()*3)-1;
 		// continuous screen
 		if (x < 0)
 			x = 500;
 		else if (x > 500)
 			x = 0;
 		if (y < 0)
 			y = 500;
 		else if (y > 500)
 			y = 0;
 		// follow mouse
 		if (mouseX < x)
 			x = x + (int)(Math.random()*3)-2;
 		else if(mouseX > x)
 			x = x + (int)(Math.random()*3);
 		if (mouseY < y)
 			y = y + (int)(Math.random()*3)-2;
 		else if(mouseY > y)
 			y = y + (int)(Math.random()*3);
 		// new location
 		if (mousePressed == true)
 		{
 			x = (int)(Math.random()*500);
 			y = (int)(Math.random()*500);
 					foodR = (int)(Math.random()*128)+127;
 		foodG = (int)(Math.random()*128)+127;
 		foodB = (int)(Math.random()*128)+127;
 		}
 	}
 	public void show()
 	{
 		strokeWeight(0.1f);
 		stroke(0);
 		fill(r, g, b);
 		ellipse(x, y, s, s);
 	}
 	public void food()
 	{
 		noStroke();
 		fill(foodR, foodG, foodB);
 		rect(mouseX - (s + 20)/2, mouseY - (s + 20)/2, s + 20, s + 20);
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
