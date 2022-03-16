package lab8;

public class part2 {
    static boolean hasOdd(int[] a){
        for(int i : a){
            if(i%2==1){return true;}
        }
        return false;
    }
    public static void main (String[] args){
        int[] a = {2, 4, 6, 8, 10, 2, 4};
        int[] b = {2, 4, 6, 8, 10, 2, 111};
        int[] c = {};
        System.out.println(hasOdd(a));
        System.out.println(hasOdd(b));
        System.out.println(hasOdd(c));
    }
}
