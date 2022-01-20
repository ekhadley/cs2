package lab1;

public class part4 {
        static void makeLine(int l){
            String line = "+";
            for(int i=0; i<l; i++){
                line += "------+";
            }
            System.out.println(line);
        }

        static void makeRows(int l, int s){
            System.out.print("|");
            String day = "";

            for(int i = 1-(s%7); i<35; i++){
                day = "" + i;
                if(i > 0 && i <= l){
                    if(day.length() > 1){
                        System.out.print("  " + i + "  |");
                    }
                    else{
                        System.out.print("   " + i + "  |");
                    }
                }
                else{
                    System.out.print("      |");
                    }
                
                if((i+(s%7))%7 == 0 && i != 34){
                    System.out.print("\n|");
                }
            }
            System.out.println();   
        }

        static void makeCalendar(int l, int s){    
            System.out.println("  Sun    Mon    Tue    Wed    Thu    Fri    Sat");
            makeLine(7);
            makeRows(l, s);
            makeLine(7);
        }

    public static void main(String[] args) {
        makeCalendar(31, 6);
    }
}
