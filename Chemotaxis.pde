 Bacteria [] b;   
 void setup()   
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
 void draw()   
 {    
 	background(131, 171, 161);
 	for (int i = 0; i < b.length; i++)
 	{
 		b[i].move();
 		b[i].show();
 	}   
 }  
 class Bacteria    
 {     
 	int x, y, r, g, b, s;
 	Bacteria(int bx, int by)
 	{
 		x = bx;
 		y = by;
 		r = (int)(Math.random()*128)+127;
 		g = (int)(Math.random()*128)+127;
 		b = (int)(Math.random()*128)+127;
 		s = (int)(Math.random()*10)+5;
 	}
 	void move()
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
 		}
 	}
 	void show()
 	{
 		strokeWeight(0.1);
 		stroke(0);
 		fill(r, g, b);
 		ellipse(x, y, s, s);
 	}
 }    