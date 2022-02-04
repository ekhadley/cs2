import java.util.*;
public class testy {
    public static void main(String args[]){
        int[] a = {1, 2, 3};
        int[] b = {4, 5, 6};

        int[] temp = new int[3];

        temp = a;
        a = b;
        b = temp;
        System.out.println(Arrays.toString(a));

    }
}
