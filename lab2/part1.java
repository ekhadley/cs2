package lab2;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class part1 {


    static int processDate(){
        ArrayList<Integer> daysInMonth = new ArrayList<Integer>(Arrays.asList(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31));

        var input = new Scanner(System.in);
        
        String date = input.nextLine();
        String[] dates = date.split("/");

        int day = Integer.parseInt(dates[0]);
        int month = Integer.parseInt(dates[1]);
        int year = Integer.parseInt(dates[2]);

        int yearDay = 0;
        for(int i=0; i<month-1; i++){
            yearDay += daysInMonth.get(i);
        }
        yearDay += day;
        
        return yearDay;
    } 




    public static void main(String[] args) {
        System.out.println("What is the first birthday? (D/M/YY)" );
        processDate();

    }
}