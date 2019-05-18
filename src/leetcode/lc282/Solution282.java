package lc282;

import java.util.ArrayList;
import java.util.List;

/**
 * 这个地方使用backtracking来解决，流程还是非常复杂的
 *
 * 这题有点难，标记一下
 */
public class Solution282 {
    public List<String> addOperators(String num, int target) {
        int v = num.length();
        char[] sc = num.toCharArray();
        char[] path = new char[v * 2];
        List<String> res = new ArrayList<>();
        long n = 0;
        for (int i = 0; i < v; i++) {
            n = n * 10 + (sc[i]-'0');
            path[i] = sc[i];
            backtracking(res, path, i+1, sc, i+1, 0, n, target);
            if (n == 0) break;
        }
        return res;
    }

    /**
     *
     * @param res
     * @param path store temporary result path
     * @param pathi end index
     * @param sc input char array
     * @param sci end index
     * @param left is what before we do the calculation
     * @param cur is the new number from last recuisive call
     * @param target
     */
    private void backtracking(List<String> res, char[] path, int pathi, char[] sc, int sci, long left, long cur, int target) {
        if (sci == sc.length) {
            if (left + cur == target) {
                res.add(new String(path, 0 ,pathi));
            }
            return;
        }
        long n = 0;
        int signIndex = pathi;
        pathi++; // jump over signIndex
        for (int i = sci; i < sc.length; i++) {
            path[pathi] = sc[i];
            pathi++;
            n = n * 10 + (sc[i]-'0'); // add a new digit
            path[signIndex] = '+';
            backtracking(res, path, pathi, sc, i + 1, left + cur, n, target);
            path[signIndex] = '-';
            backtracking(res, path, pathi, sc, i + 1, left + cur, -n, target);
            path[signIndex] = '*';
            backtracking(res, path, pathi, sc, i + 1, left, cur * n, target);
            if(n == 0) break; // deal with '001' case, only `0` in the first loop will be handled.
        }
    }
}
