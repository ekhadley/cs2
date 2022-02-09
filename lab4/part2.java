package lab4;

public class part2 {
    public static boolean squareCheck(int[][] a){
        int height = a.length;
        int width = a[0].length;
        for(int[] i : a){
            if(i.length != width || i.length != height){return false;}
        }
        return true;
    }

    public static Boolean isMagicSquare(int[][] a){
        if(!squareCheck(a)){return false;}
        int key = 0;
        int sum1 = 0;
        int sum2 = 0;

        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                sum1 += a[i][j];
                sum2 += a[j][i];
            }
            if(i==0){key=sum1;}
            System.out.println(key + ", " + sum1 + ", " + sum2);
            if(sum1!=sum2||sum2!=key){return false;}
            sum1=0;
            sum2=0;
        }
        
        return true;
    }


    public static void main(String[] args){
        int[][] test = {{2,7,6},{9,5,1},{4,3,8}};
        boolean ya = isMagicSquare(test);
        System.out.println(ya);
    }

}
