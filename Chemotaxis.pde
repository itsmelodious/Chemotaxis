 Bacteria [] b;   
 void setup()   
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
 void draw()   
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
 	void move()
 	{
 		x = x + (int)(Math.random()*3)-1;
 		y = y + (int)(Math.random()*3)-1;
 	}
 	void show()
 	{
 		strokeWeight(0.5);
 		stroke(255);
 		fill(r, g, b);
 		ellipse(x, y, 10, 10);
 	}
 }    