package com;

public class Solve {

    public void solveMatrix(int[][] m) {
        int l = m.length;
        System.out.println("Input:");
        show(m);
        for (int i = 0; i < l / 2; i++)
        {
            for (int j = i; j < l - i - 1; j++)
            {
                int temp = m[i][j];
                m[i][j] = m[l - 1 - j][i];
                m[l - 1 - j][i] = m[l - 1 - i][l - 1 - j];
                m[l - 1 - i][l - 1 - j] = m[j][l - 1 - i];
                m[j][l - 1 - i] = temp;
            }
        }
        System.out.println("Output:");
        show(m);

    }
    public void show (int[][] m){
        int l = m.length;
        for (int i = 0; i < l; i++)
        {
            for (int j = 0; j < l; j++)
                System.out.print( m[i][j] + " ");
            System.out.println();
        }
    }
}
