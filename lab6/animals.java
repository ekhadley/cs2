import java.util.Random;
import java.util.ArrayList;

// This code was written to run inside of a visual/animation IDE/library for Java called Processing which
// I am familiar with so decided to use it for this assignment. The program has a tool to export a script as an 
// executable but in my experience it rarely works.  It is submited in the dropbox with the source code. If it does not work, 
// you can donwload Processing 3.5.4 from processing.org/download
// and run the code on your own computer.

Random random = new Random();


public static PVector PVadd(PVector a, PVector b) {
  return new PVector(a.x+b.x, a.y+b.y);
}

public static PVector PVscale(PVector a, float d) {
  return new PVector(a.x*d, a.y*d);
}

public PVector oob(PVector pos){
    if (pos.x > width) {
      pos.x -= width;}
    if (pos.x < 0) {
      pos.x += width;}
    if (pos.y > width) {
      pos.y -= height;}
    if (pos.y < 0) {
      pos.y += height;}
    return pos;
}

void setup() {
  background(30);
  size(1000, 1000);
  noStroke();

  for (int i = 0; i < 0; i++) {
    ecosystem.add(new dog(random.nextInt(width), random.nextInt(height)));
  }
  for (int i = 0; i < 0; i++) {
    ecosystem.add(new bird(random.nextInt(width), random.nextInt(height)));
  }
  for (int i = 0; i < 10; i++) {
    ecosystem.add(new tiger(random.nextInt(width), random.nextInt(height)));
  }
}

public class animal {
  PVector pos;
  PVector vel = new PVector(0, 0);
  PVector acc = new PVector(0, 0);
  float size;
  int strength;
  int speed;
  color marker;
  int energy = 1000;
  int age = 0;
  int lastMate = 0;
  int calories;
  

  public animal(float posx, float posy) {
    this.pos = new PVector(posx, posy);
    this.size = 5;
    this.strength = 5;
    this.speed = 10;
    this.calories = 100;    
  }

  void attemptMate(animal other){
    boolean a = this.age - this.lastMate > 100 && this.energy > 100;
    boolean b = other.age - other.lastMate > 100 && other.energy > 100;
    float dist = dist(this.pos.x, this.pos.y, other.pos.x, other.pos.y);
    if(a && b && (dist<20)){this.spawn();}
  }

  boolean canEat(animal food){
      return (this.strength>food.strength)
  
  }

  void spawn(){
    this.energy-=100;
    this.lastMate = this.age;
    pool.add(new animal(this.pos.x, this.pos.y));
  }
  
  void update(){
      this.move();
      this.encounter();
      this.show();
      this.age ++;
  }

  void encounter(){
    if(this.energy>0){
      for(int i=0; i<ecosystem.size(); i++){
        animal other = ecosystem.get(i);
        attemptMate(other);
        attemptEat(other);
      }
    }
  }
  
  void show(){
    fill(this.marker);
    ellipse(this.pos.x, this.pos.y, this.size, this.size);
  }

  void move() {
    this.energy--;
    this.acc = PVadd(this.acc, new PVector((random.nextFloat()-.5)/5, (random.nextFloat()-.5)/5));
    this.vel = PVadd(this.vel, this.acc);
    if (this.vel.mag()>this.speed/10.0){
      this.vel = PVscale(this.vel, .4);
      this.acc = PVscale(this.vel, .5);}
    this.pos = PVadd(this.pos, this.vel);
    this.pos = oob(this.pos);
  }
}

public class dog extends animal {
  public dog(float posx, float posy) {
    super(posx, posy);
    this.size = 17;
    this.strength = 7;
    this.speed = 10;
    this.marker = color(random.nextInt(150)+50, random.nextInt(30), random.nextInt(150)+100);
  }

  void spawn(){
    this.energy-=100;
    this.lastMate = this.age;
    pool.add(new dog(this.pos.x, this.pos.y));
  }

  void show() {
    resetMatrix();
    fill(this.marker);
    translate(this.pos.x, this.pos.y);
    rotate(this.vel.heading()-PI/2);
    triangle(-this.size/2, 0, this.size/2, 0, 0, this.size);
    triangle(-this.size/2, 1, this.size/2, 1, 0, -this.size/3);
  }
}

public class bird extends animal {
  public bird(float posx, float posy) {
    super(posx, posy);
    this.size = 5.5;
    this.strength = 3;
    this.speed = 30;
    this.marker = color(random.nextInt(50), random.nextInt(150)+100, random.nextInt(100)+80);
    }

  void spawn(){
    this.energy-=100;
    this.lastMate = this.age;
    pool.add(new bird(this.pos.x, this.pos.y));
  }

  void show() {
    resetMatrix();
    fill(this.marker);
    translate(this.pos.x, this.pos.y);
    rotate(this.vel.heading()-PI/2);
    triangle(-this.size, -this.size, 1, 0, 0, this.size*2);
    triangle(this.size, -this.size, -1, 0, 0, this.size*2);
  }
}
public class tiger extends animal {
  public tiger(float posx, float posy) {
    super(posx, posy);
    this.size = 20;
    this.strength = 30;
    this.speed = 30;
    this.marker = color(random.nextInt(100)+150, random.nextInt(140)+90, random.nextInt(90));
  }

  void spawn(){
    this.energy-=100;
    this.lastMate = this.age;
    pool.add(new tiger(this.pos.x, this.pos.y));
  }

  void show() {
    resetMatrix();
    fill(this.marker);
    translate(this.pos.x, this.pos.y);
    rotate(this.vel.heading()-PI/2);
    triangle(-this.size/2, 0, this.size/2, 0, 0, this.size);
    triangle(-this.size/2, 1, this.size/2, 1, 0, -this.size);
  }
}

ArrayList<animal> ecosystem = new ArrayList<animal>();
ArrayList<animal> pool = new ArrayList<animal>();

int i = 0;
void draw() {
  background(30);

  System.out.println(i);
  i++;
  
  for (animal i : ecosystem){
    if(i instanceof bird){bird j = (bird)i; j.update();}
    if(i instanceof dog){dog j = (dog)i;j.update();}
    if(i instanceof tiger){tiger j = (tiger)i;j.update();}
  }
  ecosystem.addAll(pool);
  pool.clear();
}







































