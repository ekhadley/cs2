package lab2;

import java.util.*;

public class part4 {

    public static ArrayList intList(String l){
        String[] sep = l.split("\\s+");
        ArrayList<Integer> iList = new ArrayList<Integer>();
        int current;
        for(int i=0; i<sep.length; i++){
            current = Integer.parseInt(sep[i]);
            iList.add(current);
        }
        return iList;
    }

    public static void printGPA(){
        var inp1 = new Scanner(System.in);

        System.out.print("What is the student's name?: ");
        String name = inp1.nextLine();

        System.out.print("List the student's grades, seperated by spaces: ");
        String grades = inp1.nextLine();

        ArrayList<Integer> glist = intList(grades);

        double sum=0;
        for(int i=0; i<glist.size();i++){
            sum += glist.get(i);
        }
        sum /= glist.size();
        System.out.println(name + "'s total grade is: " + sum + ".");
    }
    
    
    public static void main(String[] args) {
        printGPA();
    }

}
