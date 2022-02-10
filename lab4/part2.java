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
        int len = a.length-1;
        int key = 0;
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        int sum4 = 0;

        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                sum1 += a[i][j];
                sum2 += a[j][i];
                sum3 += a[j][j];
                sum4 += a[j][len-j];
            }
            if(i==0){key=sum1;}
            //System.out.println(key + ", " + sum1 + ", " + sum2 + ", " + sum3 + ", " + sum4);
            if(sum1!=sum2||sum2!=key){return false;}
            sum1=0;
            sum2=0;
            sum3=0;
            sum4=0;
        }
        
        return true;
    }


    public static void main(String[] args){
        int[][] test1 = {{2,7,6},{9,5,1},{4,3,8}};
        int[][] test2 = {{1,1,4},{3,8,6},{2,2,9}};
        System.out.println(isMagicSquare(test1));
        System.out.println(isMagicSquare(test2));
    }

}
