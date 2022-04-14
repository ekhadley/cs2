class piece {
  PVector pos;
  PImage selfie;
  boolean white;
  ArrayList<PVector> history = new ArrayList<PVector>();

  public piece(int c, int r, boolean white) {
    this.pos = new PVector(c, r);
    this.history.add(this.pos.copy());
    this.white = white;
  }

  public void show(int place) {
    image(selfie, (this.history.get(place).x-1)*(width/8) + width/16, (8-this.history.get(place).y)*(height/8) + height/16);
  }

  public boolean canMove(PVector a){
    return true;
  }
  
  public void showMoves(){
    fill(30, 230, 150);
    for(int i = 1; i<=8; i++){
       for(int j = 1; j<=8; j++){
         if(this.canMove(new PVector(i, j))){
           ellipse((i-1)*100 + 50, (8-j)*100 + 50, 30, 30);
         }
       }
     }
   }
}
class king extends piece {
  public king(int c, int r, boolean white) {
    super(c, r, white);
    if (this.white)this.selfie = wKing;
    else {
      this.selfie = bKing;
    }
    selfie.resize(width/9, height/9);
  }

  public boolean canMove(PVector d) {
    return dist(this.pos.x, this.pos.y, d.x, d.y) == 1 || dist(this.pos.x, this.pos.y, d.x, d.y) == sqrt(2);
  }
}

class knight extends piece {
  public knight(int c, int r, boolean white) {
    super(c, r, white);
    if (this.white)this.selfie = wKnight;
    else {
      this.selfie = bKnight;
    }
    selfie.resize(width/10, height/10);
  }
  public boolean canMove(PVector d) {
    return dist(this.pos.x, this.pos.y, d.x, d.y) == sqrt(5);
  }
}
class rook extends piece {
  public rook(int c, int r, boolean white) {
    super(c, r, white);
    if (this.white)this.selfie = wRook;
    else {
      this.selfie = bRook;
    }
    selfie.resize(width/10, width/9);
  }

  public boolean canMove(PVector a) {
    if (this.pos.x == a.x) {
      for (float y = min(this.pos.y, a.y); y <= max(this.pos.y, a.y); y++) {
        if (occupied(new PVector(this.pos.x, y), this.pos, a))return false;
      }
      return true;
    }
    if (this.pos.y == a.y) {
      for (float x = min(this.pos.x, a.x); x <= max(this.pos.x, a.x); x++) {
        if (occupied(new PVector(x, this.pos.y), this.pos, a))return false;
      }
      return true;
    }
    return false;
  }
}
class bishop extends piece {
  public bishop(int c, int r, boolean white) {
    super(c, r, white);
    if (this.white)this.selfie = wBishop;
    else {
      this.selfie = bBishop;
    }
    selfie.resize(width/10, width/9); 
  }

  public boolean canMove(PVector a) {
    if(match(this.pos, a))return false;
    if (this.pos.x-a.x==this.pos.y-a.y) {
      for (float y = min(this.pos.y, a.y); y <= max(this.pos.y, a.y); y++) {
        if (occupied(new PVector(this.pos.x+(y-this.pos.y), y), this.pos, a))return false;
      }
      return true;
    }
    if (this.pos.x-a.x==-(this.pos.y-a.y)) {
      for (float x = min(this.pos.x, a.x); x <= max(this.pos.x, a.x); x++) {
        if (occupied(new PVector(x, this.pos.y-(x-this.pos.x)), this.pos, a))return false;
      }
      return true;
    }

    return false;
  }
}

class queen extends piece {
  public queen(int c, int r, boolean white) {
    super(c, r, white);
    if (this.white)this.selfie = wQueen;
    else {
      this.selfie = bQueen;
    }
    selfie.resize(width/10, width/9);
  }

  public boolean canMove(PVector a) {
    if (this.pos.x == a.x) {
      for (float y = min(this.pos.y, a.y); y <= max(this.pos.y, a.y); y++) {
        if (occupied(new PVector(this.pos.x, y), this.pos, a))return false;
      }
      return true;
    }
    if (this.pos.y == a.y) {
      for (float x = min(this.pos.x, a.x); x <= max(this.pos.x, a.x); x++) {
        if (occupied(new PVector(x, this.pos.y), this.pos, a))return false;
      }
      return true;
    }
    if (this.pos.x-a.x==this.pos.y-a.y) {
      for (float y = min(this.pos.y, a.y); y <= max(this.pos.y, a.y); y++) {
        if (occupied(new PVector(this.pos.x+(y-this.pos.y), y), this.pos, a))return false;
      }
      return true;
    }
    if (this.pos.x-a.x==-(this.pos.y-a.y)) {
      for (float x = min(this.pos.x, a.x); x <= max(this.pos.x, a.x); x++) {
        if (occupied(new PVector(x, this.pos.y-(x-this.pos.x)), this.pos, a))return false;
      }
      return true;
    }

    return false;
  }

}
class pawn extends piece {
  public pawn(int c, int r, boolean white) {
    super(c, r, white);
    if (this.white)this.selfie = wPawn;
    else {
      this.selfie = bPawn;
    }
    selfie.resize(width/12, width/10);
  }

  public boolean canMove(PVector a) {
    int mod = this.white?1:-1;
    PVector d = new PVector(this.pos.x, this.pos.y+mod);
    PVector q = new PVector(this.pos.x, this.pos.y+2*mod);
    if (match(a, d) && !occupied(d))return true;
    if (match(a, q) && !occupied(a) && !occupied(q))return true;
    return false;
  }
}