package lab4;

import java.util.*;

public class part1 {
    static public Boolean sameSize(int[][] a, int[][] b){
        try{
            if(a.length!=b.length){return false;}
            for(int i=0; i< a.length; i++){
                if(a[i].length!=b[i].length){return false;}
            }
            return true;
        }
        catch(IndexOutOfBoundsException e){
            return false;
        }
    }


    static public int[][] matrixAdd(int[][] a, int[][] b){
        int[][] c = new int[a.length][a[0].length];

        if(!sameSize(a, b)){System.out.println("Mismatched array sizes; sum is undefined");return c;}

        for(int i=0; i<a.length; i++){
            for(int j=0; j<a[i].length; j++){
                //System.out.println(i + ", " + j);
                c[i][j] = a[i][j] + b[i][j];
            }
        }
        return c;

    }

    static public void main(String[] args){
        int[][] A = {{3, 3, 3}, {2, 2, 2}, {1, 1, 1}};
        int[][] B = {{3, 3}, {2, 2, 2}, {1, 1, 1}};

        int[][] C = matrixAdd(A, B);

        System.out.print(Arrays.deepToString(C));
    }
    
}
