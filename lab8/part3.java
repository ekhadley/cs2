package lab8;

import java.util.*;

public class part3 {
    static ArrayList rmEven(ArrayList<String> a){
        ArrayList<String> z = new ArrayList<String>(a);
        for(String i : a){
            if(i.length()%2==0){
                z.remove(i);
            }
        }
        return z;
    }
    public static void main(String[] args){
        ArrayList<String> a = new ArrayList<String>(Arrays.asList("1", "12", "123", "1234", "12345"));
        ArrayList<String> b = new ArrayList<String>(Arrays.asList("1", "1"));
        ArrayList<String> c = new ArrayList<String>(Arrays.asList());
        System.out.println(rmEven(a));
        System.out.println(rmEven(b));
        System.out.println(rmEven(c));
    }
}