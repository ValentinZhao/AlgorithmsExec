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

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) return res;
        backtracking(res, "", num, target, 0, 0, 0);
        return res;
    }

    // multed 的意思是先存下来下个递归中，如果选用了乘法，会被乘的对象
    // 1. 之前是加法，那么就是 XXXX + A，如果下一位选择乘法，乘到的部分就是+ A的部分，那就是cur
    // 2. 之前是减法，那么就是 XXXX - A，如果下一位选择乘法，乘到的部分就是- A的部分，那就是-cur，毕竟我们最后所有的结果都是加出来的，所以给个负号
    // 3. 之前是乘法，那么就是 XXXX * A，如果下一位选择乘法，乘到的部分就是* A的部分，那就是得连着上一个递归栈中的multed一起乘，因为乘法之间是并列关系
    private void backtracking(List<String> res, String path, String num, int target, int pos, long eval, long multed) {
        if (pos == num.length()) {
            if (eval == target) res.add(path);
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            // 这里的意思是，如果说pos不是零（毕竟i可以i++，i != pos）
            // 然后charAt(pos)却还是0的话，这说明我们在处理一个以0开头的字符串
            // 因为后面我们要用pos为起始，不断地backtracking substring(pos, i+1)这个数字，然后再做一些运算
            // 所以当你想用0做一系列起始的时候，parseLong会报错
            if (i != pos && num.charAt(pos) == '0') break;
            long cur = Long.parseLong(num.substring(pos, i+1));
            // pos是0的话，这说明在这个func的最上层，我们只能先加一个数字进去
            if (pos == 0) {
                backtracking(res, path + cur, num, target, i + 1, cur, cur);
            } else {
                backtracking(res, path + "+" + cur, num, target, i + 1, eval + cur, cur);
                backtracking(res, path + "-" + cur, num, target, i + 1, eval - cur, -cur);
                // for example, if you have a sequence of 12345 and you have proceeded to 1 + 2 + 3, now your eval is 6 right?
                // If you want to add a *(multiple mark) between 3 and 4, you would take 3 as the digit to be multiplied,
                // so you want to take it out from the existing eval.
                // You have 1 + 2 + 3 * 4 and the eval now is (1 + 2 + 3) - 3 + (3 * 4). Hope this could help : )
                backtracking(res, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur);
            }
        }
    }
}
