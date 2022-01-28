package lab2;

import java.util.*;

public class part1 {


    static int processDate(String date){
        ArrayList<Integer> daysInMonth = new ArrayList<Integer>(Arrays.asList(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31));

        String[] dates = date.split("/");

        int day = Integer.parseInt(dates[1]);
        int month = Integer.parseInt(dates[0]);

        int yearDay = 0;
        for(int i=0; i<month-1; i++){
            yearDay += daysInMonth.get(i);
        }
        yearDay += day;
        
        return yearDay;
    } 

    static int daysUntil(String now, String then){
        var input = new Scanner(System.in);
        int nowDay = processDate(now);
        int thenDay = processDate(then);

        int daysUntil = thenDay-nowDay;
        if(daysUntil<0){daysUntil+=365;}
        return daysUntil;
    }

    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.print("What is the current date? (M/D): ");
        String now = input.nextLine();
        System.out.print("What is the first birthday? (M/D): ");
        String bd1 = input.nextLine();
        System.out.print("What is the second birthday? (M/D): ");
        String bd2 = input.nextLine();
        
        int d2bd1 = daysUntil(now, bd1);
        int d2bd2 = daysUntil(now, bd2);
        if(d2bd1<d2bd2){
            System.out.println("The first birthday is sooner, with " + d2bd1 + "days left. The second birthday has " + d2bd2 + "days to go.");
        }
        else{
            System.out.println("The second birthday is sooner, with " + d2bd2 + "days left. The first birthday has " + d2bd1 + "days to go.");
        }
    }
    

}