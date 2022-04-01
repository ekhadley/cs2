package lab9;
import java.util.*;

public class part5 {
    static void perm(ArrayList<String> a){
        System.out.println(a);
        for(String i : a){
            ArrayList<String> r = new ArrayList<String>(a);
            r.remove(i);
            perm(r);
        }
    }
    public static void main(String[] args){
        perm(new ArrayList<>(Arrays.asList("Porthos", "Athos", "Aramis")));
    }
}
