package lab6.part4;

public class article extends libraryItem{
    String author;
    String pubSrc;
    article(String name, int id, String author, String pubSrc){
        super(name, id);
        this.author = author;
        this.pubSrc = pubSrc;
    }
    String getAuthor(){
        return this.author;
    }
    String getArticleSource(){
        return this.pubSrc;
    }
}
