void tile() {
  background(#A26A3E);
  for (int i=0; i<32; i++) {
    fill(#FFBD8B);
    translate((2*(width/8)*i)%(width) + ((i/4)%2)*(width/8), (width/8)*(i/4));
    rect(0, 0, width/8, width/8);
    resetMatrix();
  }
}



public void applyMove(String move, boolean white){
  String[] ma = move.split("");
  
  if(move.matches("[a-z]\\d")){
    for(piece x : pcs){
      if(x instanceof pawn){
        pawn p = (pawn)x;
        if(p.canMove(rowCol(move)) && p.white == white){
          p.pos = rowCol(move);
          p.history.add(p.pos.copy());
        }
      }
    }
  }

  else if(move.matches("[a-z]x[a-z]\\d")){
    for(piece x : pcs){
      if(match(x.pos, rowCol(ma[2]+ma[3]))){
        x.pos = new PVector(100, 100);
      }
      if(x instanceof pawn){
        pawn p = (pawn)x;
        if(p.pos.x == rowCol(ma[0]).x){
          p.pos = rowCol(ma[2]+ma[3]);
        }
      }
    }
  }
  
  else if(move.matches("N[a-z]\\d")){
    for(piece x : pcs){
      if(x instanceof knight){
        knight n = (knight)x;
        if(n.canMove(rowCol(ma[1] + ma[2]))){
          n.pos = rowCol(ma[1] + ma[2]);
        }
      }
    }
  }

  else System.out.println("format not recognized: " + move);
}




public void display(ArrayList<piece> pcs, int place){
  for(piece i : pcs){
    if( i instanceof pawn){pawn j = (pawn)i; j.show(place);}
    if( i instanceof king){king j = (king)i; j.show(place);}
    if( i instanceof queen){queen j = (queen)i; j.show(place);}
    if( i instanceof rook){rook j = (rook)i; j.show(place);}
    if( i instanceof bishop){bishop j = (bishop)i; j.show(place);}
    if( i instanceof knight){knight j = (knight)i; j.show(place);}
  }
}

public boolean occupied(PVector a){
  for(piece p : pcs){
    if((p.pos.x == a.x && p.pos.y == a.y))return true;
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
  int y;
  int x = 0;
  for (int i = 0; i<8; i++) {
    if (inp[0].matches(cols[i])) {
      x = i+1;
    }
  }
  if(place.length()>1)y = Integer.parseInt(inp[1]);
  else y = 0;
  return new PVector(x, y);
}