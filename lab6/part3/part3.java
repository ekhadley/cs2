package lab6.part3;

public class part3 {
    public static void main(String args[]){
        bobSledder bill = new bobSledder("Bill Brown", 230, 68, "Male", 345000, 88, "Pusher"); 
        rockClimber joel = new rockClimber("Joel Miller", 180, 72, "Male", 1868000, 14, 73);
        pingPongPlayer abby = new pingPongPlayer("Abby Andersen", 215, 65, "Female", 143000, 25000, "Shakehand Grip");
        System.out.println(bill.getHeight());
        System.out.println(joel.getApeIndex());
        System.out.println(abby.getGripType());
    }
}
