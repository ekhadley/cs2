package lab3;

import java.util.*;

public class part3 {
    
    public static int[] collapse(int[] in){
        int len = in.length/2;
        if(in.length%2==1){len++;}
        int[] out = new int[len];
        for(int i=0; i<len;i++){
            out[i] = in[2*i] + in[2*i+1];
        }
        return out;
    }


    public static void main(String[] args){
        int[] q = new int[]{1, 1, 2, 2, 3, 3, 5, 5};
        int[] o = collapse(q);
        for(int i=0;i<o.length;i++){
            System.out.println(o[i]);
        }
    }
}
