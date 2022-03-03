package lab6.part2;

public class cylinder implements shape{
    private float height;
    private float radius;

    public cylinder(float r, float h){
        radius = r;
        height = h;
    }
    public float getRadius(){
        return radius;
    }
    public float getHeight(){
        return height;
    }

    public double getVolume(){
        return 3.14159*(Math.pow(radius, 2))*height;
    }
    public double getSurfaceArea(){
        return 2*3.14159*radius*height + 2*3.14159*Math.pow(radius, 2);
    }
}
