package lab7;
import java.util.*;
public class part2 {
    static ArrayList<String> clump(ArrayList<String> a) throws IndexOutOfBoundsException{
        ArrayList<String> c = new ArrayList<>();
        for(int i = 0; i < a.size(); i+=2){
                c.add("(" + a.get(i) + " " + a.get(i+1) + ")");
        }
        if(a.size()%2 == 1){c.add(a.get(a.size()-1));}
        return c;
    }
    public static void main(String[] args){
        ArrayList<String> k = new ArrayList<String>(Arrays.asList("The", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog"));
        ArrayList<String> j = new ArrayList<String>(Arrays.asList("Lorem", "ipsum", "dolor", "sit", "amet", "consectetur", "adipiscing", "elit"));
        System.out.println(clump(k));
        System.out.println(clump(j));
    }
}
