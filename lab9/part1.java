package lab9;

public class part1{
    static float sumTo(int n){
        System.out.println(n);
        if(n==1)return 1;
        return 1/n + sumTo(n-1);
    }
    static String bin(int n){
        if(n<2)return "" + n%2;
        return bin(n/2) + n%2;
    }
    
    public static void main(String[] args){
        System.out.println(sumTo(5));
        System.out.println(bin(64));
    }
}