package lab2;
import java.util.Random;
import java.util.random.*;

public class part3 {

    static void makeGuess(){
        Random rand = new Random();
        int guess = rand.nextInt(9) + 1;
        System.out.println("Is your number " + guess + "? (Y/N)")
    }

    public static void main(String[] args) {
        var input = new Scanner(System.in);
        
        String resp = input.nextLine();
        do{
            makeGuess();
        }
        while{resp.equals("n")}
    }
}
