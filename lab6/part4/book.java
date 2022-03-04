package lab6.part4;

public class book extends libraryItem{
    String author;
    int pages;
    book(String name, int id, String author, int pages){
        super(name, id);
        this.author = author;
        this.pages = pages;
    }
    String getAuthor(){
        return this.author;
    }
    int getPages(){
        return this.pages;
    }
}
