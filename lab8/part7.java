package lab8;

import java.util.*;

public class part7 {
    static Map reverse(Map<String, String> a){
        ArrayList<String> keys = new ArrayList<String>();
        ArrayList<String> values = new ArrayList<String>();
        Map<String, ArrayList<String>> r = new HashMap<String, ArrayList<String>>();

        for(Map.Entry<String, String> entry : a.entrySet()){
            keys.add(entry.getKey());
            values.add(entry.getValue());
        }
        ArrayList<String> m = new ArrayList<String>();
        for(int i=0; i<keys.size(); i++){
            for(int j=0; j<keys.size();j++){
                if(values.get(j)==values.get(i)){m.add(keys.get(j));}
            }
            r.put(values.get(i), new ArrayList<String>(m));
            m.clear();
        }
        return r;
    }
    public static void main(String[] args){
        Map<String, String> a = new HashMap<String, String>(){{
            put("a", "1");
            put("b", "2");
            put("c", "2");
            put("d", "2");
            put("e", "4");
            put("f", "4");
        }};
        System.out.println(reverse(a));
    }
}
