package com;

public class Main {

    public static void main(String[] args) {

        // Task 1
        System.out.println("///// Task 1 /////");

        System.out.println(solve(323));

        // Task 2
        System.out.println("///// Task 2 /////");

        Solve n = new Solve();
        int [][] m = {{9,8,7},{6,5,4},{3,2,1}};
        n.solveMatrix(m);

        //Task 3
        System.out.println("///// Task 3 /////");

        int [] k = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        Task3 s = new Task3();
        System.out.println("Output: " + s.solve(k));

    }

    public static boolean solve(int k) {
        int r, temp, sum = 0;
        temp = k;
        while(k>0){
            r = k % 10;
            sum = (sum * 10) + r;
            k = k / 10;
        }
        if (temp==sum) {
            return true;
        } else return false;
    }

}
