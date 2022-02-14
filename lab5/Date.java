package lab5;

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

    public int yearlen(int year){
        boolean type1 = this.year%400 == 0 && this.year%100 == 0;
        boolean type2 = this.year%4 == 0 && this.year%100 != 0;
        int yearlen = (type1 || type2)?366:365;
        return yearlen;
    }

    public void addDays(int inc){
        int absDate = this.day;
        int yearlen = yearlen(this.year);

        for(int i=0; i<this.month-1; i++){
            absDate += daysPerMonth[i];
        }
        absDate += inc;

        while(absDate>yearlen){
            yearlen = yearlen(this.year);
            absDate -= yearlen;
            this.year++;
            System.out.println(this.year + ", " + yearlen);
        }
        
        for(int i = 0; absDate>daysPerMonth[i];i++){
            absDate -= daysPerMonth[i];
            this.month = i + 2;
        }
        this.day = absDate;
    }

    public String getDate(){
        return "" + this.month + ", " + this.day + ", " + this.year;
    }
}
