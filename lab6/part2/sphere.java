package lab6.part2;

public class sphere implements shape{
    private float radius;

    public sphere(float r){
        radius = r;
    }
    public float getRadius(){
        return radius;
    }

    public double getVolume(){
        return 4*3.14159*Math.pow(radius, 3)/3;
    }

    public double getSurfaceArea(){
        return 4*3.14159*Math.pow(radius, 2);
    }
}
