package lab10;

public class part1 {
    public static int[] sort(int[] a){
        int l = 0;
        for(int i = a.length-1; i > 0; i--){
            for(int j=0; j < i; j++)
                if(a[j] < a[l])l = j; 
            int t = a[i];
            a[i] = a[l];
            a[l]=t;
            l=0;
        }
        return a;
    }
    public static void main(String[] args){
        int[] z = {6, 1, 2, 6, 8, 12, 14, 62, 100};
        sort(z);
        for(int i : z)System.out.print(i + ", ");
    }    
}
