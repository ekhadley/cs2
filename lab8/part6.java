package lab8;

import java.util.*;

public class part6 {
    static boolean contains(Map<String, String> a, String key, String value){
        for(Map.Entry<String, String> entry : a.entrySet()){
            if(entry.getKey() == key && entry.getValue() == value){return true;}
        }
    return false;
    }

    static boolean subMap(Map<String, String> main, Map<String, String> sub){
        for(Map.Entry<String, String> entry : sub.entrySet()){
            if(!contains(main, entry.getKey(), entry.getValue())){return false;}
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
            put("1", "a");
            put("2", "b");
        }};
        Map<String, String> c = new HashMap<String, String>() {{}};

        System.out.println(subMap(a, b));
        System.out.println(subMap(b, a));
        System.out.println(subMap(a, c));
    }
}
