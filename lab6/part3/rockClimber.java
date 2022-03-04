package lab6.part3;

public class rockClimber extends athlete {
    int maxGrade;
    float wingSpan;

    rockClimber(String nam, float wei, float hei, String gen, float sal, int gra, int win){
        super(nam, wei, hei, gen, sal);
        this.maxGrade = gra;
        this.wingSpan = win;
    }
    int getMaxGrade(){
        return this.maxGrade;
    }
    float getWingSpan(){
        return this.wingSpan;
    }
    float getApeIndex(){
        return this.wingSpan-this.height;
    }
}