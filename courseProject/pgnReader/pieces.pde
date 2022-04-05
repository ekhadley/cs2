class piece{
  PVector pos;
  PImage selfie;
  boolean white;
  
  public piece(int c, int r, boolean white){
    this.pos = new PVector(c, r);
    this.white = white;
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
          if(occupied(new PVector(this.pos.x+(y-this.pos.y), y), this.pos))return false;
        }
      return true;
      }
      if(this.pos.x-a.x==-(this.pos.y-a.y)){
        for(float x = min(this.pos.x, a.x); x <= max(this.pos.x, a.x); x++){
          if(occupied(new PVector(x, this.pos.y-(x-this.pos.x)), this.pos))return false;
        }
      return true;
      }
    
    return false;
    }
    
  public void show(){
    image(selfie, (this.pos.x-1)*(width/8) + width/16, (8-this.pos.y)*(height/8) + height/16); 
  }
}

class queen extends piece{
  public queen(int c, int r, boolean white){
    super(c, r, white);
    if(this.white)this.selfie = wQueen;
    else{this.selfie = bQueen;}
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
      if(this.pos.x-a.x==this.pos.y-a.y){
        for(float y = min(this.pos.y, a.y); y <= max(this.pos.y, a.y); y++){
          if(occupied(new PVector(this.pos.x+(y-this.pos.y), y), this.pos))return false;
        }
      return true;
      }
      if(this.pos.x-a.x==-(this.pos.y-a.y)){
        for(float x = min(this.pos.x, a.x); x <= max(this.pos.x, a.x); x++){
          if(occupied(new PVector(x, this.pos.y-(x-this.pos.x)), this.pos))return false;
        }
      return true;
      }
    
    return false;
    }
    
  public void show(){
    image(selfie, (this.pos.x-1)*(width/8) + width/16, (8-this.pos.y)*(height/8) + height/16); 
  }
}
class pawn extends piece{
  public pawn(int c, int r, boolean white){
    super(c, r, white);
    if(this.white)this.selfie = wPawn;
    else{this.selfie = bPawn;}
    selfie.resize(width/12, width/10);
  }
  
  public boolean canMove(PVector a) {
    PVector d = new PVector(this.pos.x, this.pos.y+1);
    PVector q = new PVector(this.pos.x, this.pos.y+2);
    if(match(a, d) && !occupied(d))return true;
    if(match(a, q) && !occupied(a) && !occupied(q))return true;
    return false;
    }
    
  public void show(){
    image(selfie, (this.pos.x-1)*(width/8) + width/16, (8-this.pos.y)*(height/8) + height/16); 
  }
}
