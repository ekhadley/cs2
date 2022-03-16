package lab7;

public class point implements Comparable{
    float x;
    float y;

    point(float x, float y){
        this.x = x;
        this.y = y;
    }
    int compareTo(point p){
        float dy = this.y-p.y;
        float dx = this.x-p.x;
        if(dy>0){return 1;}
        if(dy<0){return -1;}
        if(dy==0){
            if(dx>0){return 1;}
            if(dx<0){return -1;}
            if(dx==0){return 0;}
        }
        return 0;
    }
}
