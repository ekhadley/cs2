package lab3;

import java.io.*;
import java.util.*;

public class part1 {

    public static int wordCount(String filename){
        File paper = new File(filename + ".txt");
        Scanner scan = new Scanner(paper);
        String line;

        line = scan.nextLine();
        System.out.println(line);

        return 0;
    }

    public static void main(String args[]){

        System.out.print(wordCount("mypaper"));
    }

}
