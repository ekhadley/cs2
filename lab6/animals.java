import java.util.Random;
import java.util.ArrayList;

// This code was written to run inside of a visual/animation IDE for Java called Processing which
// I am familiar with so decided to use it for this assignment. The program has a tool to export a script as an 
// executable but in my experience it rarely works. If it does not, you can donwload Processing 3.5.4 from:
// processing.org/download
// and run this on your own computer if you feel it necessary.
// sidenote, I think processing is an amazingly intuitive way to implement animation/interfaces for python or java,
// and I would reccomend it for use in other classes.

Random random = new Random();

void setup(){
  background(30);
  size(800, 800);
  noStroke();

  for(int i = 0; i < 50; i++){
    ecosystem.add(new dog(random.nextInt(width), 
                             random.nextInt(height), 
                             color(random.nextInt(100)+60, random.nextInt(300), random.nextInt(150)+80)));
  }
}


public class animal{
  PVector pos;
  PVector vel;
  int size;
  int hunger = 0;
  int strength;
  int speed;
  color marker;

  
  public animal(int posx, int posy, color marker){
      this.pos = new PVector(posx, posy);
      this.vel = new PVector(0, 0);
      this.size = 5;
      this.strength = 5;
      this.speed = 10;
      this.marker = marker;
  }
    
      void move(){
        if(this.hunger>0){this.hunger--;}
        
        this.vel.x += (random.nextDouble()-.5)*this.speed/10;
        this.vel.y += (random.nextDouble()-.5)*this.speed/10;
        
        if(this.vel.mag()<1.5){
            this.vel.x *= .95;
            this.vel.y *= .95;
        }
        
        this.pos.x += vel.x;
        this.pos.y += vel.y;
 
        if(this.pos.x > width){this.pos.x -= width;}
        if(this.pos.x < 0){this.pos.x += width;}
        if(this.pos.y > width){this.pos.y -= height;}
        if(this.pos.y < 0){this.pos.y += height;}
      }
      void show(){
        fill(this.marker);
        ellipse(this.pos.x, this.pos.y, this.size, this.size);
      }
    
}
public class dog extends animal{
  public dog(int posx, int posy, color marker){
    super(posx, posy, marker);
    this.size = 17;
    this.strength = 7;
    this.speed = 6;
  }
  
  void show(){
    resetMatrix();
    fill(this.marker);
    translate(this.pos.x, this.pos.y);
    rotate(this.vel.heading()-PI/2);
    triangle(-this.size/2, 0, this.size/2, 0, 0, this.size);
    triangle(-this.size/2, 1, this.size/2, 1, 0, -this.size/3);

  }
}


ArrayList<animal> ecosystem = new ArrayList<animal>();

void draw(){
  background(30);
  
  for(animal i : ecosystem){
    dog j = (dog) i;
    j.move();
    j.show();


  }
  
}








































