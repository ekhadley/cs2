package lab6.part3;

public class bobSledder extends athlete {
    int topSpeed;
    String position;

    bobSledder(String nam, float wei, float hei, String gen, float sal, int top, String pos){
        super(nam, wei, hei, gen, sal);
        this.topSpeed = top;
        this.position = pos;
    }
    int getTopSpeed(){
        return this.topSpeed;
    }
    String getPosition(){
        return this.position;
    }
}