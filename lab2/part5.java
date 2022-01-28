package lab2;

import java.util.*;

public class part5 {

    public static void longestName(int q){
        var input = new Scanner(System.in);
        String longestName = "404";
        int longestLen = 0;
        String current;

        for(int i=0; i<q;i++){
            System.out.print("name " + (i+1) + ":");
            current = input.nextLine();
            if(current.length()>longestLen){
                longestName=current;
                longestLen=current.length();
            }
        }
        System.out.println("The longest name is " + longestName + ", with " + longestLen + " characters.");
    }


    public static void main(String[] args){
        longestName(5);
    }
}
