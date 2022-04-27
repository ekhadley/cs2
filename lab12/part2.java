package lab12;

public class part2 {
    public static boolean isPairwiseSorted(int[] a){
        for(int i = 0; i < (a.length- a.length%2); i += 2){
            if(a[i] > a[i+1])return false;
        }
        return true;
    }
    public static void main(String[] args){
        int[] k = {-1, 1, -4, -2, 10, 11, 7, 7};
        int[] v = {-1, 1, -4, -2, 10, 11, 7, -7};
        System.out.println(isPairwiseSorted(k));
        System.out.println(isPairwiseSorted(v));
    }
}
