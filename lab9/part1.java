package lab9;

public class part1{
    static float sumTo(int n) throws IllegalArgumentException{
        if(n<2)return n;
        if(n<0)throw new IllegalArgumentException();
        return 1/(float)n + sumTo(n-1);
    }
    
    public static void main(String[] args){
        System.out.println(sumTo(5));
        System.out.println(sumTo(100));
        System.out.println(sumTo(0));
    }
}