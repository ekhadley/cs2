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
  size(400, 400);
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
  moveArray = loadStrings("game2.txt");
  moveString = "";
  boolean s = false;
  for (String i : moveArray)moveString += i + " ";

  if (moveString.contains("{"))moveString = moveString.substring(0, moveString.indexOf("{")) + 
    moveString.substring(moveString.indexOf("}")+1, moveString.length());
  moveString.replace("\n", "");
  moves = moveString.replaceFirst("\\d\\. |\\d\\.", "").split("\\d\\. |\\d\\d\\. |\\d\\.");



  // Add all the pieces in standard starting configuration
  for (int i = 0; i<9; i++) {
    pcs.add(new pawn(i+1, 2, true));
    pcs.add(new pawn(i+1, 7, false));
    if (i<2) {
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


  // identify the type of and apply each move to the piece, and store previous position for each piece, for the entire game 
  int k = 0;
  for (String move : moves) {
    System.out.println(k + ":" + move);
    k++;
    applyMove(move.split(" ")[0], true);
    applyMove(move.split(" ")[1], false);
  }
}

boolean keyPrev;

void draw() {
  tile();


  // Show the pieces according to the current place in the game
  for (piece x : pcs) {
    x.pos = x.history.get(place);
    x.show(place);
  }

  // detect when a key is released and if it was the left or right arrow key; increment move accordingly
  if (keyPrev && !keyPressed && keyCode==39 && place < moves.length*2)place ++;
  if (keyPrev && !keyPressed && keyCode==37 && place > 0 )place --;

  keyPrev = keyPressed;
}
