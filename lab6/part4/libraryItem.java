package lab6.part4;

public class libraryItem {
    String name;
    int id;

    libraryItem(String name, int id){
        this.name = name;
        this.id = id;
    }
    String getName(){
        return this.name;
    }
    int getID(){
        return this.id;
    }
}
