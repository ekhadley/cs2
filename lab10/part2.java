package lab10;
import java.util.*;

public class part2 {
    public static void swap(int[] arr, int a, int b){
        int t = arr[a];
        arr[a] = arr[b];
        arr[b]=t;
    }
    public static int[] sort(int[] a){
        int l = 0;
        int s = 0;
        for(int i = 0; i < a.length/2; i++){
            for(int j=i; j < a.length-i; j++){
                System.out.println(i +", " + j);
                if(a[j] > a[l])l = j;
                if(a[j] < a[s])s = j;
            }
            swap(a, l, a.length-i);
            swap(a, s, i);
            l = 0;
            s = 0;
            System.out.println(Arrays.toString(a));
            
        }
        return a;
    }
    public static void main(String[] args){
        // This version of selection sort also has n^2 time complexity but will run about 
        // twice as fast as normal selection sort becuase it sorts twice as many elements per pass
        int[] z = {6, 1, 2, 6, 8, 12, 14, 62, 100};
        int[] w = {1, 7, 34, 1, 7, 8, 9, 0, 10};
        System.out.println(Arrays.toString(sort(z)));
        //System.out.println(Arrays.toString(sort(w)));
    }
}