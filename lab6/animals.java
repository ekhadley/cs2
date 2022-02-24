import java.util.Random;
import java.util.ArrayList;

Random random = new Random();

void setup(){
  background(30);
  size(800, 800);
  noStroke();
  
  alice = new animal(400, 400, 10, color(20, 200, 90));

for(int i = 0; i < 50; i++){
  ecosystem.add(new animal(random.nextInt(width), random.nextInt(height), random.nextInt(20)+5, 
                color(random.nextInt(100),random.nextInt(255),random.nextInt(255))));
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

  
  public animal(int posx, int posy, int size, color marker){
      this.pos = new PVector(posx, posy);
      this.vel = new PVector(0, 0);
      this.size = size;
      this.strength = 5;
      this.speed = 10;
      this.marker = marker;
  }
    
      void move(){
        if(this.hunger>0){this.hunger--;}
        
        if(this.vel.mag()<1.5){
          this.vel.x += (random.nextDouble()-.5)*this.speed/20;
          this.vel.y += (random.nextDouble()-.5)*this.speed/20;
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
  public dog(){
    super();
  }
}


animal alice;
ArrayList<animal> ecosystem = new ArrayList<animal>();

void draw(){
  background(30);
  
  for(animal i : ecosystem){
    i.move();
    i.show();
  }
  
}








































