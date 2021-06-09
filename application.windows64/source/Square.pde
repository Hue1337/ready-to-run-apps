class Square{
 float x, y, a, s;
 Square(){
  x = 50;
  y = 50;
  s = 2;
  a = width-100;
 }
 void display(){
  stroke(0);
  strokeWeight(s);
  noFill();
  rect(x, y, a, a);
 }
  
}
