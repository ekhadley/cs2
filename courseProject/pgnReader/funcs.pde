void tile() {
  background(#A26A3E);
  for (int i=0; i<32; i++) {
    fill(#FFBD8B);
    translate((2*(width/8)*i)%(width) + ((i/4)%2)*(width/8), (width/8)*(i/4));
    rect(0, 0, width/8, width/8);
    resetMatrix();
  }
}



public boolean applyMove(String move, boolean white){
  boolean detected = false;
  String original = move;
  move = move.replace("+", "");
  if(!move.matches("[a-h]x[a-h][1-8]"))move = move.replace("x", "");
  String[] ma = move.split("");
  
  if(move.matches("O-O")){
    for(piece x : pcs){
      if(x instanceof king && x.white==white)x.pos = new PVector(7, x.white?1:8);
      if(x instanceof rook && x.white==white){
        if(match(x.pos, new PVector(8, x.white?1:8)))x.pos = new PVector(6,x.white?1:8);
        detected = true;
      }
    }
  }
  else if(move.matches("O-O-O")){
    for(piece x : pcs){
      if(x instanceof king && x.white==white)x.pos = new PVector(3, x.white?1:8);
      if(x instanceof rook && x.white==white){
        if(match(x.pos, new PVector(1, x.white?1:8)))x.pos = new PVector(4,x.white?1:8);
        detected = true;
      }
    }
  }
  
  else if(move.matches("[a-h][1-8]")){
    for(piece x : pcs){
      if(x instanceof pawn && x.white == white){
        pawn p = (pawn)x;
        if(p.canMove(rowCol(move)) && (p.white == white)){
          p.pos = rowCol(move);
          detected = true;
        }
      }
    }
  }

  else if(move.matches("[a-h]x[a-h][1-8]")){
    for(piece x : pcs){
      if(match(x.pos, rowCol(ma[2]+ma[3]))){
        x.pos = new PVector(100, 100);
      }
      if(x instanceof pawn && x.white == white){
        pawn p = (pawn)x;
        if(p.pos.x == rowCol(ma[0]).x && p.white==white){
          p.pos = rowCol(ma[2]+ma[3]);
          detected = true;
        }
      }
    }
  }
  
  else if(move.matches("N[a-h][1-8]")){
    PVector dest = rowCol(ma[1] + ma[2]);
    for(piece x : pcs){
      if(match(x.pos, dest))x.pos = new PVector(10, 10);
      if(x instanceof knight && x.white == white){
        knight n = (knight)x;
        if(n.canMove(dest)){
          n.pos = dest.copy();
          detected = true;
        }
      }
    }
  }
  
  else if(move.matches("N[a-h][a-h][1-8]")){
    PVector dest = rowCol(ma[2] + ma[3]);
    for(piece x : pcs){
      if(match(x.pos, dest))x.pos = new PVector(10, 10);
      if(x instanceof knight && x.white == white){
        knight n = (knight)x;
        if(n.canMove(dest) && rowCol(ma[1]).x == n.pos.x){
          n.pos = dest.copy();
          detected = true;
        }
      }
    }
  }
  
  else if(move.matches("N[1-8][a-h][1-8]")){
    PVector dest = rowCol(ma[2] + ma[3]);
    for(piece x : pcs){
      if(match(x.pos, dest))x.pos = new PVector(10, 10);
      if(x instanceof knight && x.white == white){
        knight n = (knight)x;
        if(n.canMove(dest) && rowCol("a"+ma[1]).y == n.pos.y){
          n.pos = dest.copy();
          detected = true;
        }
      }
    }
  }

  else if(move.matches("B[a-h][1-8]")){
    PVector dest = rowCol(ma[1] + ma[2]);
    for(piece x : pcs){
      if(match(x.pos, dest))x.pos = new PVector(10, 10);
      if(x instanceof bishop && x.white == white){
        bishop b = (bishop)x;
        if(b.canMove(dest)){
          b.pos = dest.copy();
          detected = true;
        }
      }
    }
  }

  else if(move.matches("R[a-h][1-8]")){
    PVector dest = rowCol(ma[1] + ma[2]);
    for(piece x : pcs){
      if(match(x.pos, dest))x.pos = new PVector(10, 10);
      if(x instanceof rook && x.white == white){
        rook r = (rook)x;
        if(r.canMove(dest)){
          r.pos = dest.copy();
          detected = true;
        }
      }
    }
  }

  else if(move.matches("R[a-h][a-h][1-8]")){
    PVector dest = rowCol(ma[2] + ma[3]);
    for(piece x : pcs){
      if(match(x.pos, dest))x.pos = new PVector(10, 10);
      if(x instanceof rook && x.white == white){
        rook n = (rook)x;
        if(n.canMove(dest) && rowCol(ma[1]).x == n.pos.x){
          n.pos = dest.copy();
          detected = true;
        }
      }
    }
  }

  else if(move.matches("R[1-8][a-h][1-8]")){
    PVector dest = rowCol(ma[2] + ma[3]);
    for(piece x : pcs){
      if(match(x.pos, dest))x.pos = new PVector(10, 10);
      if(x instanceof rook && x.white == white){
        rook n = (rook)x;
        if(n.canMove(dest) && rowCol("a"+ma[1]).y == n.pos.y){
          n.pos = dest.copy();
          detected = true;
        }
      }
    }
  }

  else if(move.matches("Q[a-h][1-8]")){
    PVector dest = rowCol(ma[1] + ma[2]);
    for(piece x : pcs){
      if(match(x.pos, dest))x.pos = new PVector(10, 10);
      if(x instanceof queen && x.white == white){
        queen q = (queen)x;
        if(q.canMove(dest)){
          q.pos = dest.copy();
          detected = true; 
        }
      }
    }
  }

  else if(move.matches("Q[a-h][a-h][1-8]")){
    PVector dest = rowCol(ma[2] + ma[3]);
    for(piece x : pcs){
      if(match(x.pos, dest))x.pos = new PVector(10, 10);
      if(x instanceof queen && x.white == white){
        queen n = (queen)x;
        if(n.canMove(dest) && rowCol(ma[1]).x == n.pos.x){
          n.pos = dest.copy();
          detected = true;
        }
      }
    }
  }

  else if(move.matches("K[a-h][1-8]")){
    PVector dest = rowCol(ma[1] + ma[2]);
    for(piece x : pcs){
      if(match(x.pos, dest))x.pos = new PVector(10, 10);
      if(x instanceof king && x.white == white){
        king k = (king)x;
        if(k.canMove(dest)){
          k.pos = dest.copy();
          detected = true;
        }
      }
    }
  }

  else if(move.matches("1-0")){
    for(piece x : pcs){
      if(!(x instanceof king && x.white))x.pos = new PVector(10, 10);
    }
  }
  else if(move.matches("0-1")){
    for(piece x : pcs){
      if(!(x instanceof king && !x.white))x.pos = new PVector(10, 10);
    }
  }
  else if(move.matches("1\2-1\2")){
    for(piece x : pcs){
      if(!(x instanceof king))x.pos = new PVector(10, 10);
    }
  }

  else System.out.println("format not recognized: " + original);
  for(piece x : pcs)x.history.add(x.pos.copy());
  return detected;
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

public boolean occupied(PVector a, PVector ignore1, PVector ignore2){
  for(piece p : pcs){
    if((p.pos.x == a.x && p.pos.y == a.y) && !match(a, ignore1)&& !match(a, ignore2))return true;
  }
  return false;
}

public boolean match(PVector a, PVector b){
  return ((a.x==b.x) && (a.y==b.y));
}

public PVector rowCol(String place) {
  String[] cols = {"a", "b", "c", "d", "e", "f", "g", "h"};
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