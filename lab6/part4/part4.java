package lab6.part4;

public class part4 {
    public static void main(String args[]){
        article a = new article("On the Electrodynamics of Moving Bodies", 123654, "Albert Einstein", "Science Weekly");
        book b = new book("Harry Potter and the Prisoner of Azkaban", 109812, "J.K. Rowling", 317);
        magazine c = new magazine("Sports Illustrated", 676767, "The 2020 Swimsuit Issue", 45);
        video d = new video("Is Anything Real?", 846298, 682, 4.3, "VSauce");
        CD e = new CD("My Way", 323908, 1952, "Frank Sinatra", "Traditional pop");
        System.out.println(a.getAuthor());
        System.out.println(b.getID());
        System.out.println(c.getEditionTitle());
        System.out.println(d.getCreator());
        System.out.println(e.getLength());
    }
}
