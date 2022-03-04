package lab6.part3;

public class pingPongPlayer extends athlete {
    int rating;
    String gripType;

    pingPongPlayer(String nam, float wei, float hei, String gen, float sal, int rat, String gri){
        super(nam, wei, hei, gen, sal);
        this.rating = rat;
        this.gripType = gri;
    }
    int getRating(){
        return this.rating;
    }
    String getGripType(){
        return this.gripType;
    }
}