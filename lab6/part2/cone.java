package lab6.part2;

public class cone implements shape{
    private float height;
    private float radius;

    public cone(float r, float h){
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
        return 3.14159*(Math.pow(radius, 2))*height/3.0;
    }
    public double getSlantLength(){
        return Math.pow(Math.pow(height, 2)+Math.pow(radius, 2), .5);
    }
    public double getSurfaceArea(){
        return 3.14159*radius*(radius+getSlantLength());
    }
}
