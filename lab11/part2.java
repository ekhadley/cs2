package lab11;
import java.util.*;

public class part2 {
    public static Queue<Integer> rearrange(Stack<Integer> q){
        ArrayDeque<Integer> s = new ArrayDeque<Integer>();
        while(q.size()>1){
            int e = q.peek();
            if(e%2==0)s.addFirst(e);
            if(e%2==1)s.addLast(e);
            q.pop();
        }
        return s;
    }
    public static void main(String[] args){
        Stack<Integer> s = new Stack<Integer>();
        for(int i=0; i< 11; i++)s.add(i);
        Collections.shuffle(s);
        System.out.println(s.toString());
        System.out.println(rearrange(s).toString());
    }
}
