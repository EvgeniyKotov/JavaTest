package com;

public class Task3 {

    public int solve (int[] k){
        int [] inp = new int [] {0,1,1,2,2,2,2,3,2,2,2,1};
        int [] out = new int[12];

        for (int i = 0; i < inp.length; i++)
        {
            for (i=0; i<inp.length; i++)
                out[i] = inp[i] - k[i];
        }
        int sum = 0;
        for (int i = 0; i < out.length; i++)
        {
            sum +=out[i];
        }
        return sum;
    }

}
