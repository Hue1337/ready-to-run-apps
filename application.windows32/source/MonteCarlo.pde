 Square square;
 Circle circle;
 
 boolean b = false;
 
 void setup(){
  size(500, 500);
  frameRate(60);
  square = new Square(); 
  circle = new Circle(square);
 }
 
 void draw(){
   background(#fffdd1);
   square.display();
   circle.display(square);
   MC(10000, circle, square);
   if(b)delay(3000);  // removing loading time for the 1st animation
   else b = true;
 }
 
 void MC(int a, Circle c, Square s){
   float x=0, z;
   Bubble bubble;
   for(int i=0; i<a; ++i){
     bubble = new Bubble(s);
     if(bubble.inside(c))++x;
     bubble.display(c);
   }
   z = (x/(a))*4;
   PFont f;
   f = createFont("Arial", 20);
   textFont(f, 20);
   fill(0);
   textAlign(CENTER);
   text("Pi ≈ "+z, width/2, 25);
 }
