package src;


import lc673.Solution673;

import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        Solution673 solution = new Solution673();
        int[] data = new int[]{5,4,3,2,1};
        int res = solution.findNumberOfLIS(data);
        System.out.println("Input =====> " + Arrays.toString(data));
        System.out.println("Output =====> " + res);
    }
}