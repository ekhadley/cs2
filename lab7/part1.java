package lab7;

public class part1 {
    static ArrayList filterRange(ArrayList a, int l, int u){
        for(int i : a){
            if(i > l && i < u){a.remove(i);}
        }
        return a;
    }
    public static void main(String[] args){
        
    }
}
