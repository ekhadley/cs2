package lab5;

public class part2 {
    public static void main(String[] args){
        Date yo = new Date(3,26,2002);
        yo.addDays(123);
        System.out.println(yo.toString());
        System.out.println(yo.getDay());
        System.out.println(yo.getMonth());
        System.out.println(yo.getYear());
        System.out.println(yo.isLeapYear());

    }
} 
