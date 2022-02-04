package lab4;

import java.util.*;

public class part1 {

    static public int[][] matrixAdd(int[][] a, int[][] b){
        int[][] c = new int[a.length][a[0].length];
        for(int i=0;i<a.length-1;i++){
            for(int j=0;i<a[i].length-1;j++){
                System.out.println(i + ", " + j);
                c[j][i] = a[j][i]+b[j][i];
            }
        }
        return c;
    }

    static public void main(String[] args){
        int[][] A = {{3, 3, 3}, {2, 2, 2}, {1, 1, 1}};
        int[][] B = {{3, 3, 3}, {2, 2, 2}, {1, 1, 1}};

        int[][] C = matrixAdd(A, B);
        System.out.println(Arrays.toString(C[0]));

    }
    
}
