package lab9;

public class part1{
    static float sumTo(int n){
        System.out.println(n);
        if(n==1)return 1;
        return sumTo(n-1) + 1/n;
    }

    public static void main(String[] args){
        System.out.println(sumTo(5));
    }
}