package lab7;

//My date class frpom the previous lab already took years into account, but had no direct
//  comparison function. If i were to implement one in Date it would look like this.
public class part5 {
    public static Boolean isBefore(Date date){
        return daysUntil(date)>0;
    }
}
