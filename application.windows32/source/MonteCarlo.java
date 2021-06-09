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

public class MonteCarlo extends PApplet {

 Square square;
 Circle circle;
 
 boolean b = false;
 
 public void setup(){
  
  frameRate(60);
  square = new Square(); 
  circle = new Circle(square);
 }
 
 public void draw(){
   background(0xfffffdd1);
   square.display();
   circle.display(square);
   MC(10000, circle, square);
   if(b)delay(3000);  // removing loading time for the 1st animation
   else b = true;
 }
 
 public void MC(int a, Circle c, Square s){
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
class Bubble{
  float x, y, l;
  int col1, col2;
  Bubble(Square s){
   x = random(s.x+s.s+l/2, width-s.x-s.s-l/2);
   y = random(s.y+s.s+l/2, height-s.y-s.s-l/2);
   l = 3;
   col1 = color(255, 0, 0);
   col2 = color(0, 255, 0);
  }
  
  public void display(Circle c){
    noStroke();
    if(inside(c))fill(col1);
    else fill(col2);
    ellipse(x, y, l, l);
  }
  
  public boolean inside(Circle c){
    if(dist(x, y, c.x, c.y) < c.l/2) return true;
    else return false;
  }
}    
class Circle{
 float x, y, l;
 Circle(Square s){
   x = width/2;
   y = height/2;
   l = width-2*s.x;
 }
 
 public void display(Square s){
  stroke(0);
  strokeWeight(s.s);
  noFill();
  ellipse(x, y, l, l);
 }
  
}
class Square{
 float x, y, a, s;
 Square(){
  x = 50;
  y = 50;
  s = 2;
  a = width-100;
 }
 public void display(){
  stroke(0);
  strokeWeight(s);
  noFill();
  rect(x, y, a, a);
 }
  
}
  public void settings() {  size(500, 500); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "MonteCarlo" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
