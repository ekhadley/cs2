package lab1;
import java.util.Scanner;

public class part3 {
    public static void main(String[] args) {

            var input = new Scanner(System.in);
            System.out.println("Enter your name: ");
        
            String name = input.nextLine();
            String[] sep = name.split("\\s+");
            
            String reversed = "";
            for(int i = sep.length-1; i>-1; i--){
                reversed += sep[i];
                if(sep.length > 1 && i > 0){
                    reversed += ", ";
                }
            }

            System.out.println("Your name in reverse order is: " + reversed);
        }

}





































