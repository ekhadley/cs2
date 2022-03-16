package lab8;

import java.util.*;

public class part5 {
    static boolean is1to1(Map<String, String> a){
        ArrayList<String> keys = new ArrayList<String>();
        ArrayList<String> vals = new ArrayList<String>();

        for(Map.Entry<String, String> entry : a.entrySet()){
            String val = entry.getValue();
            if(keys.contains(val)){return false;}
            keys.add(val);
        }
        return true;

    }
    public static void main(String[] args){
        Map<String, String> a = new HashMap<String, String>() {{
            put("1", "a");
            put("2", "b");
            put("3", "c");
        }};
        Map<String, String> b = new HashMap<String, String>() {{
            put("a", "1");
            put("b", "2");
            put("c", "2");
        }};
        System.out.println(is1to1(a));
        System.out.println(is1to1(b));
    }
}
