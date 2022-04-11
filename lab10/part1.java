package lab10;
import java.util.*;

public class part1 {
    public static int[] sort(int[] a){
        int l = 0;
        for(int i = a.length-1; i > 0; i--){
            for(int j=0; j <= i; j++)
                if(a[j] > a[l])l = j;
            int t = a[i];
            a[i] = a[l];
            a[l]=t;
            l=0;
        }
        return a;
    }
    public static void main(String[] args){
        // This version of selection sort will be n^2 time complexity like normal selection sort.
        // It will also run at the same speed as original selection sort.
        int[] z = {6, 1, 2, 6, 8, 12, 14, 62, 100};
        int[] w = {1, 7, 34, 1, 7, 8, 9, 0, 10};
        System.out.println(Arrays.toString(sort(z)));
        System.out.println(Arrays.toString(sort(w)));
    }
}
