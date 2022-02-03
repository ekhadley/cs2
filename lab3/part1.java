package lab3;

import java.io.*;
import java.util.*;

public class part1 {

    public static int[] wordCount(String filename) throws FileNotFoundException{
        String line;
        String full = "";
        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;
        int[] counts = new int[3];

        File paper = new File(filename);
        Scanner scan = new Scanner(paper);

        while(scan.hasNext()){
            line = scan.nextLine();
            full += line;
            lineCount ++;
        }
        String[] words = full.split("\\s+");

        wordCount = words.length;
        charCount = full.length();

        counts[0] = lineCount;
        counts[1] = wordCount;
        counts[2] = charCount;

        return counts;
    }

    public static void main(String args[]) throws FileNotFoundException{
        int[] resp = wordCount("thePaper.txt");
        System.out.println("This text file contains " + resp[0] + " lines, " + resp[1] + " words, and " + resp[2] + " lines");
    }

}









































