package lab8;

import java.util.*;

public class part4 {
    static ArrayList<Integer> intersection(ArrayList<Integer> a, ArrayList<Integer> b){
        ArrayList<Integer> z = new ArrayList<Integer>(a);
        ArrayList<Integer> x = new ArrayList<Integer>(a);
        z.removeAll(b);
        x.removeAll(z);
        return x;
    }

    static ArrayList<Integer> symSetDiff(ArrayList<Integer> a, ArrayList<Integer> b){
        ArrayList<Integer> x = new ArrayList<Integer>(a);
        x.addAll(b);
        x.removeAll(intersection(a, b));
        return x;
        }
    
    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(1, 4, 7, 9));
        ArrayList<Integer> b = new ArrayList<Integer>(Arrays.asList(2, 4, 5, 6, 7));
        System.out.println(symSetDiff(a, b));
    }
}
