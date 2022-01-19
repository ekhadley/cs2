public class lab1 {
    public static void main(String[] args) {
        makeImage(30);
        }        
        static void makeImage(int scale){
            makeLine(scale, true, false);
            makeSurface(scale, scale);
            makeLine(scale, false, true);
            makeFace(scale);
            makeLine(scale, false, false);
        }
        
        static void makeLine(int x, boolean padding, boolean tail){
            String line = "";
            if(padding){
            for(int i = 0; i<x; i += 1){
                line += " ";
                }
            }
            line += "+";
            for(int i = 0; i<x; i += 1){
                line += "---";
            }
            line += "+";
            if(tail){
            for(int i = 0; i<x; i+=1){
                line += "/";
            }
            
            }
        System.out.println(line);
        
                    
        }
        
        
        
        static void makeSurface(int x, int s){

            for(int i = 1; i<s; i++){
                String line = "";
                for(int j = 1; j<x-i; j++){
                    line += " ";
                }
                line += "/ ";
                for(int j = 0; j<x-i; j++){
                    line += "   ";
                }
                line += "_";
                for(int j = 0; j<i; j++){
                    line += "__/";
                }
                for(int j = 0; j<i; j++){
                    line += "/";
                }
            System.out.println(line);
            }
        }
    
        static void makeFace(int x){
            for(int i = 0; i<x/2; i++){
                String line = "|";
                for(int j=0; j < x; j++){
                    line += " ";
                }
                //line += "|";
                for(int j=0; j<x; j++){
                    line += "  ";
                }
                line += "|";
                
                for(int j = 0; j<x-2*i; j+=1){
                    line += "/";
                }
            
            System.out.println(line);
            }
        }
    
}
