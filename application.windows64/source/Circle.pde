class Circle{
 float x, y, l;
 Circle(Square s){
   x = width/2;
   y = height/2;
   l = width-2*s.x;
 }
 
 void display(Square s){
  stroke(0);
  strokeWeight(s.s);
  noFill();
  ellipse(x, y, l, l);
 }
  
}
