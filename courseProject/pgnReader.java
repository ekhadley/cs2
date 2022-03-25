import java.util.*;
import java.io.*;

String[] g;
String game = "";

void setup(){
    size(800, 800);
    background(#A26A3E);
    noStroke();
    imageMode(CENTER);

    p = loadImage("pieces.png");
  
    g = loadStrings("game1.txt");
    for(String i : g){
      game += i;
    }
    game.split("");
    System.out.println(game);
    tile();
}
  
void tile(){
    background(#A26A3E);
    for(int i=0; i<32; i++){
      fill(#FFBD8B);
      translate((2*(width/8)*i)%(width) + ((i/4)%2)*(width/8), (width/8)*(i/4));
      rect(0, 0, width/8, width/8);
      resetMatrix();
    }
}

public PVector getScreenPos(String place){
  String[] cols = {"A", "B", "C", "D", "E", "F", "G", "H"};
  String[] inp = place.split("");
  int x = 0;
  for(int i = 0; i<8; i++){
    if(inp[0].matches(cols[i])){
      x = 100*i + width/16;
    }  
  }
  int y = (8-Integer.parseInt(inp[1]))*100 + height/16;
  return new PVector(x, y);
}

public PVector rowCol(String place){
  String[] cols = {"A", "B", "C", "D", "E", "F", "G", "H"};
  String[] inp = place.split("");
  int x = 0;
  for(int i = 0; i<8; i++){
    if(inp[0].matches(cols[i])){
      x = i;
    }  
  }
  int y = Integer.parseInt(inp[1])-1;
  return new PVector(x, y);
}

class bishop{
  PVector pos;
  
  public bishop(int c, int r, String colour){
    this.pos = new PVector(c, r);
  }
  public boolean canMove(PVector d){
    return true;
  }
}


PImage p;


void draw(){
  tile();

 
  image(p, 400, 400);
}