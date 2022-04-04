import java.util.*;
import java.math.*;

ArrayList<piece> pcs = new ArrayList<piece>();
String[] moveArray;
String[] moves;
String moveString;

PImage wKing;
PImage wRook;
PImage wQueen;
PImage wBishop;
PImage wKnight;
PImage wPawn;
PImage bKing;
PImage bRook;
PImage bQueen;
PImage bBishop;
PImage bKnight;
PImage bPawn;

bishop b;

void setup() {
  size(800, 800);
  background(#A26A3E);
  noStroke();
  imageMode(CENTER);

  wKing = loadImage("wKing.png");
  wRook = loadImage("wRook.png");
  wQueen = loadImage("wQueen.png");
  wBishop = loadImage("wBishop.png");
  wPawn = loadImage("wPawn.png");
  wKnight = loadImage("wKnight.png");
  bKing = loadImage("bKing.png");
  bRook = loadImage("bRook.png");
  bQueen = loadImage("bQueen.png");
  bBishop = loadImage("bBishop.png");
  bPawn = loadImage("bPawn.png");
  bKnight = loadImage("bKnight.png");

  moveArray = loadStrings("game.txt");
  
  moveString = "";
  for (String i : moveArray) {
    moveString += i;
    
  }

  moveString.replace("\n", " ");
  moves = moveString.split("\\d\\. |\\d\\d\\. ");
  for (String i : moves)System.out.println(i);
  
  pcs.add(new king(4, 4, false));
  pcs.add(new rook(4, 6, true));
  b = new bishop(6, 4, false);
  b.show();
  
  tile();
  
  fill(200, 30, 150);
  for(int i = 1; i<=8; i++){
    for(int j = 1; j<=8; j++){
      if(b.canMove(new PVector(i, j))){
        ellipse((i-1)*100 + 50, (8-j)*100 + 50, 10, 10);
        System.out.println(i + ", " + j);
      }
    }
  }
  
  
  
}

void tile() {
  background(#A26A3E);
  for (int i=0; i<32; i++) {
    fill(#FFBD8B);
    translate((2*(width/8)*i)%(width) + ((i/4)%2)*(width/8), (width/8)*(i/4));
    rect(0, 0, width/8, width/8);
    resetMatrix();
  }
}

public boolean occupied(PVector a){
  for(piece p : pcs){
    if(p.pos.x == a.x && p.pos.y == a.y)return true;
  }
  return false;
}
public boolean occupied(PVector a, PVector ignore){
  for(piece p : pcs){
    if((p.pos.x == a.x && p.pos.y == a.y) && !match(a, ignore))return true;
  }
  return false;
}

public boolean match(PVector a, PVector b){
  return ((a.x==b.x) && (a.y==b.y));
}

public PVector rowCol(String place) {
  String[] cols = {"A", "B", "C", "D", "E", "F", "G", "H"};
  String[] inp = place.split("");
  int x = 0;
  for (int i = 0; i<8; i++) {
    if (inp[0].matches(cols[i])) {
      x = i+1;
    }
  }
  int y = Integer.parseInt(inp[1]);
  return new PVector(x, y);
}

class piece{
  PVector pos;
  PImage selfie;
  boolean white;
  
  public piece(int c, int r, boolean white){
    this.pos = new PVector(c, r);
    this.white = white;
  }
}

class knight extends piece{
  public knight(int c, int r, boolean white){
    super(c, r, white);
    if(this.white)this.selfie = wKnight;
    else{this.selfie = bKnight;}
    selfie.resize(width/10, height/10);
  }
  public boolean canMove(PVector d) {
    return dist(this.pos.x, this.pos.y, d.x, d.y) == sqrt(5);
  }
  public void show(){
    image(selfie, (this.pos.x-1)*(width/8) + width/16, (8-this.pos.y)*(height/8) + height/16); 
  }
}

class king extends piece{
  public king(int c, int r, boolean white){
    super(c, r, white);
    if(this.white)this.selfie = wKing;
    else{this.selfie = bKing;}
    selfie.resize(width/9, height/9);
  }
  
  public boolean canMove(PVector d) {
    return dist(this.pos.x, this.pos.y, d.x, d.y) == 1 || dist(this.pos.x, this.pos.y, d.x, d.y) == sqrt(2);
  }
  public void show(){
    image(selfie, (this.pos.x-1)*(width/8) + width/16, (8-this.pos.y)*(height/8) + height/16); 
  }
}

class rook extends piece{
  public rook(int c, int r, boolean white){
    super(c, r, white);
    if(this.white)this.selfie = wRook;
    else{this.selfie = bRook;}
    selfie.resize(width/10, width/9);
  }
  
  public boolean canMove(PVector a) {
    if(this.pos.x == a.x){
      for(float y = min(this.pos.y, a.y); y <= max(this.pos.y, a.y); y++){
        if(occupied(new PVector(this.pos.x, y), this.pos))return false;
      }
    return true;
    }
    if(this.pos.y == a.y){
      for(float x = min(this.pos.x, a.x); x <= max(this.pos.x, a.x); x++){
        if(occupied(new PVector(x, this.pos.y), this.pos))return false;
      }
    return true;
    }
    return false;
}
  public void show(){
    image(selfie, (this.pos.x-1)*(width/8) + width/16, (8-this.pos.y)*(height/8) + height/16); 
  }
}
class bishop extends piece{
  public bishop(int c, int r, boolean white){
    super(c, r, white);
    if(this.white)this.selfie = wBishop;
    else{this.selfie = bBishop;}
    selfie.resize(width/10, width/9);
  }
  
  public boolean canMove(PVector a) {
      if(this.pos.x-a.x==this.pos.y-a.y){
        for(float y = min(this.pos.y, a.y); y <= max(this.pos.y, a.y); y++){
          if(occupied(new PVector(this.pos.x, y), this.pos))return false;
        }
      return true;
      }
      if(this.pos.x-a.x==-(this.pos.y-a.y)){
        for(float x = min(this.pos.x, a.x); x <= max(this.pos.x, a.x); x++){
          if(occupied(new PVector(x, this.pos.y), this.pos))return false;
        }
      return true;
      }
    
    return false;
    }
    
  public void show(){
    image(selfie, (this.pos.x-1)*(width/8) + width/16, (8-this.pos.y)*(height/8) + height/16); 
  }
}

void draw() {
  //tile();



  for(piece i : pcs){
    if(i instanceof rook){rook j = (rook)i; j.show();}
    if(i instanceof king){king j = (king)i; j.show();}
    if(i instanceof knight){knight j = (knight)i; j.show();}
    //if(i instanceof bishop){bishop j = (bishop)i; j.show();}
  }
}














































