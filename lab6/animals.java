int w = 800;
int h = 800;

void setup(){
  background(30);
  size(w, h);
  noStroke();
}
  
public class animal{
  PVector pos;
  PVector acc;
  int size;
  int hunger = 0;
  int strength;
  int speed;
  color marker;
  
  public animal(int posx, int posy, int size, color marker){
    this.pos = new PVector(posx, posy);
    this.size = size;
    this.strength = 5;
    this.speed = 10;
    this.marker = marker;
    Random random = new Random();
  }
  
  void move(){
    if(this.hunger>0){this.hunger--;}
    double newAcc = random.nextDouble();
    
  
  }
}
  
alice = Animal(400, 400, )
  
void draw(){
  
}