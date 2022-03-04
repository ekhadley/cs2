package lab6.part4;

public class CD extends libraryItem{
    int length;
    String genre;
    String creator;

    CD(String name, int id, int length, String creator, String genre){
        super(name, id);
        this.length = length;
        this.genre = genre;
        this.creator = creator;
    }
    int getLength(){
        return this.length;
    }
    String getCreator(){
        return this.creator;
    }
    String getGenre(){
        return this.genre;
    }
}
