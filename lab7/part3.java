package lab7;

import java.util.*;

public class part3 {
    static ArrayList<Integer> weave(ArrayList<Integer> a, ArrayList<Integer> b) throws IndexOutOfBoundsException{
        ArrayList<Integer> c = new ArrayList<Integer>();
        int len = a.size()>b.size()?a.size():b.size();
        for(int i = 0; i<len;i++){
            try{
                c.add(a.get(i));
            }catch(Exception indeException){}
            try{
                c.add(b.get(i));
            }catch(Exception indeException){}
        }
        return c;
    }
    
    public static void main(String[] args){
        ArrayList o = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList p = new ArrayList<Integer>(Arrays.asList(6, 7, 8, 9, 10));
        ArrayList q = new ArrayList<Integer>(Arrays.asList(12, 11, 10, 9, 8, 7));
        System.out.println(weave(o, p));
        System.out.println(weave(o, q));
    }
}
