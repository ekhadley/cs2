package lab6.part4;

public class magazine extends libraryItem{
    String editionTitle;
    int pages;
    magazine(String name, int id, String editionTitle, int pages){
        super(name, id);
        this.editionTitle = editionTitle;
        this.pages = pages;
    }
    String getEditionTitle(){
        return this.editionTitle;
    }
    int getPages(){
        return this.pages;
    }
}