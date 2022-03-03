package lab6.part2;

public class cube implements shape{
    private float length;

    public cube(float l){
        length = l;
    }
    public float getSideLength(){
        return length;
    }
    public double getVolume(){
        return Math.pow(length, 3);
    }
    public double getSurfaceArea(){
        return 6*Math.pow(length, 2);
    }
}
