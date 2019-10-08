package lc1021;

/**
 * 这题简单来说就是，把一串parentheses中，自然成一个valid parentheses的提取出来，去掉他们最外面一层
 * 比如(())(()())的话，首先是两个自然parentheses，(())和(()())，去掉外面一层是()和()()，这样我们最后返回()()()即可
 * 解题思路就是，从最开始遍历使用计数法来判断是否走过了一个自然parentheses，方法就是左右括号的数量恰好一致
 */
public class Solution1021 {
    public String removeOuterParentheses(String S) {
        int left = 0, right = 0, start = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') left++;
            else if (S.charAt(i) == ')') right++;
            if (left == right) {
                sb.append(S.substring(start+1,i));
                start = i + 1;
            }
        }
        return sb.toString();
    }
}
