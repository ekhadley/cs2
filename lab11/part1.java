package lab11;
import java.util.*;

public class part1 {
    public static ArrayList<Integer> collapse(Stack<Integer> s){
        ArrayList<Integer> c = new ArrayList<Integer>();
        int n = 0;
        if(s.size()%2 == 1){
            c.add(s.peek());
        }
        while(s.size()>1){
            n += s.peek();
            s.pop();
            n += s.peek();
            s.pop();
            c.add(0, n);
            n = 0;
        }

        return c;
    }
    public static void main(String[] args){
        Stack<Integer> s = new Stack<Integer>();
        for(int i=0; i< 11; i++)s.add(i);
        System.out.println(s.toString());
        System.out.println(collapse(s).toString());
    }
}
