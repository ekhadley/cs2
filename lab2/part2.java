package lab2;

public class part2 {

    public static void digitRange(int n){
        int keep = n;
        int largest = 0;
        int smallest = 9;
        int current;
        do{
            current = n%10;
            if(current<smallest){smallest=current;}
            if(current>largest){largest=current;}
            n /= 10;
        }while(n>0);
        System.out.println("The digitRange of " + keep + " is " + (largest-smallest));
    }

        public static void main(String[] args) {
            digitRange(999);
    }
}