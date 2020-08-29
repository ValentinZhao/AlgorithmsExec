package nowcoder;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class xuanlv {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> {
            if (a[1] != b[1]) return b[1] - a[1];
            else return b[0] - a[0];
        });

        for (int i = 0; i < t; i++) {
            String s = in.next();
            int count = 0;
            int result = helper(s, count);
            System.out.println(result % 2 == 0 ? "Cassidy" : "Eleanore");
        }
    }

    private static int helper(String s, int count) {
        if (s.length() == 1 || canPalindrome(s)) return count;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < s.length(); i++) {;
            String temp;
            if (i == 0)
                temp = s.substring(1);
            else
                temp = s.substring(0, i-1) + s.substring(i+1);
            min = Math.min(min, helper(temp, count+1));
        }

        return min;
    }

    private static boolean canPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!set.add(s.charAt(i)))
                set.remove(s.charAt(i));
        }

        return set.size() <= 1;
    }

}
