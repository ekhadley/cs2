package lab9;

public class part3 {
    static void waysToClimb(int n, String prev){
        if(n==1)System.out.println(prev + "1" + "]");
        if(n==2){
            System.out.println(prev + "1, 1]");
            System.out.println(prev + "2]");
        }
        if(n>2){
            waysToClimb(n-2, prev + "2, ");
            waysToClimb(n-1, prev + "1, ");
        }
    }
    static void waysToClimb(int n){
        waysToClimb(n, "[");
    }
    public static void main(String[] args){
        System.out.println("3 stairs: ");
        waysToClimb(3);
        System.out.println("4 stairs: ");
        waysToClimb(4);
        System.out.println("5 stairs: ");
        waysToClimb(5);
    }
    
}
