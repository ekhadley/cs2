package lab3;

import java.util.*;

public class part4 {
    public static int[] vowelCount(String str){
        String[] strlist = str.split("");
        String[] vowels = {"a", "e", "i", "o", "u"};
        int[] vcount = {0, 0, 0, 0, 0};

        for(int i=0;i<strlist.length;i++){

            for(int j=0;j<5;j++){
                System.out.println(strlist[i] + ", " + vowels[j]);
                if(strlist[i] == vowels[j]){vcount[j]+=1;}
            }
        }
        return vcount;
    }

    public static void main(String[] args){
        int[] vc = vowelCount("aaeeeiouuuu");
        System.out.println(Arrays.toString(vc));
    }
}
