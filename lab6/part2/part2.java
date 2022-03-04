package lab6.part2;

public class part2 {
    public static void main (String[] args){
        cylinder ap = new cylinder(3, 10);
        sphere wc = new sphere(6);
        cube ek = new cube(10);
        octagonalPrism cj = new octagonalPrism(2, 8);
        System.out.println(ap.getSurfaceArea());
        System.out.println(wc.getVolume());
        System.out.println(ek.getSurfaceArea());
        System.out.println(cj.getVolume());
    }
}
