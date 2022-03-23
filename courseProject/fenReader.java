void setup(){
    size(800, 800);
    background(#FFBD8B);
    noStroke();
    
    for(int i=0; i<32; i++){
      fill(#A26A3E);
      translate((2*(width/8)*i)%(width) + ((i/4)%2)*(width/8), (width/8)*(i/4));
      rect(0, 0, width/8, width/8);
      resetMatrix();
    }
  }
  void place(String piece, String place){
    
  
  }