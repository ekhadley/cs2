package lab6.part2;

public class octagonalPrism implements shape{
    private float height;
    private float length;

    public octagonalPrism(float l, float h){
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
        return 4.828*Math.pow(length, 2)*height;
    }
    public double getSurfaceArea(){
        return 8*length*height + 9.656*Math.pow(length, 2);
    }
}