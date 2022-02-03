package lab3;

import java.util.*;
import java.io.*;

public class part2 {

    public static void printProg(String filename) throws FileNotFoundException{
        String line;
        String full = "";

        File prg = new File(filename);
        Scanner scan = new Scanner(prg);

        while(scan.hasNext()){
            line = scan.nextLine();
            full += line + "\n";
        }
        System.out.println(full);
    }


    public static void main(String args[]) throws FileNotFoundException{
        printProg("prog.txt");
    }

}
