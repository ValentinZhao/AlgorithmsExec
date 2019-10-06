package lc277;


import java.util.Stack;

public class Solution277 {
    public class Solution extends Relation {
        public int findCelebrity(int n) {
            if (n <= 0) return -1;
            if (n < 2) return 0;
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < n; i++) stack.push(i);
            while (stack.size() > 1) {
                int a = stack.pop(), b = stack.pop();
                // a knows b, so a is not the celebrity, but b may be
                if (knows(a, b)) stack.push(b);
                else stack.push(a);
            }
            // double check the last potential celebrity
            int c = stack.pop();
            for (int i = 0; i < n; i++) {
                if (i != c && (knows(c, i) || !knows(i ,c))) return -1;
            }
            return c;
        }
    }

    class Relation {
        boolean knows(int a, int b) { return true; }
    }
}