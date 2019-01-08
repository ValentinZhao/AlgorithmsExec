package src;

import lc884.Solution884;

public class Main {
    public static void main (String[] args) {
        Solution884 solution = new Solution884();
        String[] res = solution.uncommonFromSentences("This is Apple", "This is pear");
        System.out.println(res.toString());
    }
}