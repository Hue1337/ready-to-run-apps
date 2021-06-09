class Bubble{
  float x, y, l;
  color col1, col2;
  Bubble(Square s){
   x = random(s.x+s.s+l/2, width-s.x-s.s-l/2);
   y = random(s.y+s.s+l/2, height-s.y-s.s-l/2);
   l = 3;
   col1 = color(255, 0, 0);
   col2 = color(0, 255, 0);
  }
  
  void display(Circle c){
    noStroke();
    if(inside(c))fill(col1);
    else fill(col2);
    ellipse(x, y, l, l);
  }
  
  boolean inside(Circle c){
    if(dist(x, y, c.x, c.y) < c.l/2) return true;
    else return false;
  }
}    
