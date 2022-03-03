package lab6.part2;

public class triangularPrism {
    private float height;
    private float length;

    public triangularPrism(float l, float h){
        length = l;
        height = h;
    }
    public float getSideLength(){
        return length;
    }
    public float getHeight(){
        return height;
    }

    public double getVolume(){
        return height*1.732*Math.pow(length, 2)/4;
    }
    public double getSurfaceArea(){
        return 3*length*height + 2*1.732*Math.pow(length, 2)/4;
    }
}
