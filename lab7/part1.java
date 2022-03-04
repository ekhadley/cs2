package lab7;
import java.util.*;

public class part1 {
    static ArrayList<Integer> filterRange(ArrayList<Integer> a, int l, int u){
        ArrayList b = new ArrayList();
        b.add(a);
        for(int i : a){
            if(i >= l && i <= u){b.add(i);}
        }
        a.removeAll(b);
        return a;
    }
    public static void main(String[] args){
        ArrayList<Integer> l1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 354));
        ArrayList<Integer> l2 = new ArrayList<Integer>(Arrays.asList(4, 2, 54, 7, 5, 8, 9, 99, 23));
        ArrayList<Integer> l3 = new ArrayList<Integer>(Arrays.asList(0, 1, 1, 1, 0, 0, 0, 1, 1, 1));
        System.out.println(filterRange(l1, 3, 8));
    }
}
