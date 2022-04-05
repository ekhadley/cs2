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
  
  for(int i = 0; i<9; i++){
    pcs.add(new pawn(i+1, 2, true));
    pcs.add(new pawn(i+1, 7, false));
    if(i<2){
      pcs.add(new rook(i*7+1, 1, true));
      pcs.add(new rook(i*7+1, 8, false));
      pcs.add(new knight(i*5+2, 1, true));
      pcs.add(new knight(i*5+2, 8, false));
      pcs.add(new bishop(i*3+3, 1, true));
      pcs.add(new bishop(i*3+3, 8, false));
    }
  }
  pcs.add(new king(5, 1, true));
  pcs.add(new queen(4, 1, true));
  pcs.add(new king(5, 8, false));
  pcs.add(new queen(4, 8, false));
  tile();

  /*
  fill(30, 230, 150);
  for(int i = 1; i<=8; i++){
    for(int j = 1; j<=8; j++){
      if(q.canMove(new PVector(i, j))){
        ellipse((i-1)*100 + 50, (8-j)*100 + 50, 30, 30);
        System.out.println(i + ", " + j);
      }
    }
  }
  */
}


void draw() {
  tile();

  display(pcs);
}
