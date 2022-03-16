package lab8;

import java.util.*;

public class part1 {
    static int maxLength(ArrayList<String> a){
        int maxLen = 0;
        for(String i : a){
            if(i.length()>maxLen){
                maxLen = i.length();
            }
        }
        return maxLen;
    }
    public static void main(String[] args){
        ArrayList<String> a = new ArrayList<String>(Arrays.asList("xd", "hehe", ""));
        ArrayList<String> b = new ArrayList<String>(Arrays.asList());
        System.out.println(maxLength(a));
        System.out.println(maxLength(b));
    }
}
