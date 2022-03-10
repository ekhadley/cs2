package lab5;

import java.math.*;

public class Date {
    int year;
    int month;
    int day;
    int[] daysPerMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public Date(int month, int day, int year){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String getDate(){
        return "" + this.month + ", " + this.day + ", " + this.year;
    }

    public int absDate(Date date){
        int absDate = date.day;
        for(int i=0; i<date.month-1; i++){
            absDate += daysPerMonth[i];
        }
        return absDate;
    }

    public int yearlen(int year){
        boolean type1 = this.year%400 == 0 && this.year%100 == 0;
        boolean type2 = this.year%4 == 0 && this.year%100 != 0;
        int yearlen = (type1 || type2)?366:365;
        return yearlen;
    }

    public void addDays(int inc){
        int absDate = absDate(this);
        int yearlen = yearlen(this.year);

        absDate += inc;

        while(absDate>yearlen){
            yearlen = yearlen(this.year);
            absDate -= yearlen;
            this.year++;
        }
        
        for(int i = 0; absDate>daysPerMonth[i];i++){
            absDate -= daysPerMonth[i];
            this.month = i + 2;
        }
        this.day = absDate;
    }

    public void addWeeks(int weeks){
        addDays(weeks*7);
    }
    
    public int daysUntil(Date date){
        int diff = absDate(date) - absDate(this);

        diff += (this.year-date.year)*365;

        return diff;
        // returns negative shift if the second date is before the first
    }

    public int getDay(){
        return this.day;
    }
    public int getMonth(){
        return this.month;
    }
    public int getYear(){
        return this.year;
    }
    public boolean isLeapYear(){
        boolean leapyear = yearlen(this.year)==366?true:false;
        return leapyear;
    }

    public String toString(){
        String days = (this.day>10)?"" + this.day:"0"+this.day;
        String months = (this.month>10)?"" + this.month:"0"+this.month;
        return this.year + "/" + months + "/" + days;
    }

}
