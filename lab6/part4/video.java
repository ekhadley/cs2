package lab6.part4;

public class video extends libraryItem{
    int length;
    double filesize;
    String creator;

    video(String name, int id, int length, double filesize, String creator){
        super(name, id);
        this.length = length;
        this.filesize = filesize;
        this.creator = creator;
    }
    int getLength(){
        return this.length;
    }
    double getFilesize(){
        return this.filesize;
    }
    String getCreator(){
        return this.creator;
    }
}
