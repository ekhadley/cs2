
void tile() {
  background(#A26A3E);
  for (int i=0; i<32; i++) {
    fill(#FFBD8B);
    translate((2*(width/8)*i)%(width) + ((i/4)%2)*(width/8), (width/8)*(i/4));
    rect(0, 0, width/8, width/8);
    resetMatrix();
  }
}

public void display(ArrayList<piece> pcs){
  for(piece i : pcs){
    if( i instanceof pawn){pawn j = (pawn)i; j.show();}
    if( i instanceof king){king j = (king)i; j.show();}
    if( i instanceof queen){queen j = (queen)i; j.show();}
    if( i instanceof rook){rook j = (rook)i; j.show();}
    if( i instanceof bishop){bishop j = (bishop)i; j.show();}
    if( i instanceof knight){knight j = (knight)i; j.show();}
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
  int x = 0;
  for (int i = 0; i<8; i++) {
    if (inp[0].matches(cols[i])) {
      x = i+1;
    }
  }
  int y = Integer.parseInt(inp[1]);
  return new PVector(x, y);
}
