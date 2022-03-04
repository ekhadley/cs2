package lab7;
import java.util.*;

public class part1 {
    static ArrayList<Integer> filterRange(ArrayList<Integer> a, int l, int u){
        ArrayList<Integer> b = new ArrayList<Integer>();
        b.add(a);
        for(int i : a){
            if(i > l && i < u){b.add(i);}
        }
        a.removeAll(b);
        return a;
    }
    public static void main(String[] args){
        ArrayList<Integer> l = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 354));
        System.out.println(filterRange(l, 3, 8));
    }
}
