package lc241;

import java.util.ArrayList;
import java.util.List;

public class Solution241 {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' ||
                    input.charAt(i) == '-' ||
                    input.charAt(i) == '*') {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i+1);
                List<Integer> ret1 = diffWaysToCompute(part1);
                List<Integer> ret2 = diffWaysToCompute(part2);
                for (int p1 : ret1) {
                    for (int p2 : ret2) {
                        int c = 0;
                        switch (input.charAt(i)) {
                            case '+': c = p1+p2;break;
                            case '-': c = p1-p2;break;
                            case '*': c = p1*p2;break;
                        }
                        res.add(c);
                    }
                }
            }
        }
        if (res.size() == 0) res.add(Integer.valueOf(input));
        return res;
    }
}
