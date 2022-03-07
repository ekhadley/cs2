package lab7;
import java.util.*;
public class part2 {
    static ArrayList<String> clump(ArrayList<String> a) throws IndexOutOfBoundsException{
        ArrayList<String> c = new ArrayList<>();
        for(int i = 0; i < a.size(); i+=2){
            if(i+1 < a.size()){
                c.add("(" + a.get(i) + " " + a.get(i+1) + ")");
            }
        }
        return c;
    }
    public static void main(String[] args){
        ArrayList<String> k = new ArrayList<String>(Arrays.asList("yeah", "im", "a", "climber", "how", "could", "you", "tell", "bitch?"));
        System.out.println(clump(k));
    }
}
