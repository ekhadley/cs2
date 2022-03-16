package lab7;

public class part4 {
    public static void main(String[] args){
        point x = new point(2, 1);
        point d = new point(3, 1);
        point l = new point(-1, 2);

        System.out.println(x.compareTo(d));
        System.out.println(d.compareTo(x));
        System.out.println(l.compareTo(d));
    }
}
