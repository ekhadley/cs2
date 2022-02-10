package lab5;
public class Date {
    int year;
    int month;
    int day;
    int[] daysPerMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public Date(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void addDays(int inc){
        this.day += inc;
        int temp = day;
        this.day -= daysPerMonth[this.month-1];
        this.month += temp/daysPerMonth[this.month-1];
    }

    public String getDate(){
        return "" + this.day + ", " + this.month + ", " + this.year;
    }
}
