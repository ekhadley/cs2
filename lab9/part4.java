package lab9;

public class part4 {
    static void bCount(int n, String prev){
        if(prev.length() == n)System.out.println(prev);
        if(prev.length()<n){
        bCount(n, prev+"0");
        bCount(n, prev+"1");
        }
    }
    static void bCount(int n){
        bCount(n, "");
    }
    public static void main(String[] args){
        System.out.println("2 bit numbers: ");
        bCount(2);
        System.out.println("3 bit numbers: ");
        bCount(3);
    }
}
