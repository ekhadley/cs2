package lab11;
import java.util.*;

public class part1 {
    public Arraylist<int> collapse(Stack s){
        ArrayList<int> c = new Arraylist<int>();
        int n = 0;
        while(s.length>1){
            n += s.peek();
            s.pop();
            n += s.peek();
            s.pop();
            c.add(0, n);
            n = 0;
        }
        if(s.length == 1){
            c.add(0, s.peek())
        }
        return c;
    }
    public static void main(String[] args){
        Stack<int> s = new Stack<>(Arrays.asList7, 2, 8, 9, 4, 11, 7, 1, 42));
        System.out.println(Arrays.toString(collapse(s)));
    }
}
