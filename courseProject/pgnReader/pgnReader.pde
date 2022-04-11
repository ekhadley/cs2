import java.util.*;
import java.math.*;

ArrayList<piece> pcs = new ArrayList<piece>();

String[] moveArray;
String[] moves;
String moveString;
int place;

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

  // load the sprites for each piece
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


  // read and clean pgn file as text into an array of individual moves for black and white
  moveArray = loadStrings("game.txt");
  moveString = "";
  for (String i : moveArray) if(i!="")moveString += i + " ";
  moveString = moveString.substring(0, moveString.indexOf("{")) + moveString.substring(moveString.indexOf("}")+1, moveString.length());
  moveString.replace("\n", "");
  moves = moveString.replaceFirst("\\d\\. ", "").split("\\d\\. |\\d\\d\\. ");
  
  
  // identify the type of and apply each move to the piece, and store previous position for each piece, for the entire game 
  int k = 0;
  for (String move : moves){
    System.out.println(k + ":" + move);
    k++;
    applyMove(move.split(" ")[0], true);
    applyMove(move.split(" ")[1], false);
  }
 
  
  // Add all the pieces in standard starting configuration
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

  System.out.println(pcs.get(0).history);

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

boolean keyPrev;

void draw(){
  tile();


  // detect when a key is released and if it was the left or right arrow key, increment move accordingly
  if(keyPrev && !keyPressed && keyCode==39)place ++;
  if(keyPrev && !keyPressed && keyCode==37)place --;
  keyPrev = keyPressed;
  
  
  // Show the pieces according to 
  //System.out.println(place + ", " + keyCode);
  display(pcs, place);
}


























