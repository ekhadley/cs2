package lab2;
import java.util.Random;
import java.util.Scanner;


public class part3 {

    static void makeGuess(){
        Random rand = new Random();
        int guess = rand.nextInt(9) + 1;
        System.out.println("Is your number " + guess + "? (y/n):");
    }

    public static void main(String[] args) {
        Boolean halt = true;
        int guesses = 0;
        makeGuess();
        var input = new Scanner(System.in);
        String resp;

        do{
            resp = input.nextLine();

            if(resp.equals("y")||resp.equals("n")){
                if(resp.equals("y")){halt=false;}
                else{makeGuess();guesses++;}
            }
            else{
                System.out.println("Not recognized, please answer with (y/n):");
            }

        }while(halt);
        
        System.out.println("Computer wins with "+guesses+" guesses.");
    }
}
