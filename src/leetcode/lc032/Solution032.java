package lc032;

import java.util.Stack;

/**
 * dp题，主要是一个公式，设dp[i]是以i为结尾的子串的最长valid parentheses长度，那么当s[i]为'('时，那dp[i]一定是0，因为它本身不能组成valid的
 * 如果是')'，就要比对它前面一个字符是啥，如果是'('那么i-1和i就正好组成一对；如果还是')'那么就遇到了嵌套parentheses
 * 这时候dp[i]应该是dp[i] = dp[i-dp[i-1]-2] + 2 + dp[i-1]，解读一下就是 dp[i-dp[i-1]-2] 是 当前index减去前一个')'与它配对的括号所组成的长度再减去1就是与
 * 前一个')'匹配的'('，那么再减去1就是到了'('的前一位的新匹配组。比如 ()(()) ,i-dp[i-1]-2就是1，index为1的地方不就是新的匹配组位置嘛
 */
public class Solution032 {
    public int longestValidParentheses(String s) {
        if(s.length() <= 1) return 0;
        int curMax = 0;
        int[] longest = new int[s.length()];
        for(int i=1; i < s.length(); i++){
            // i-longest[i-1]-1 =>>> 当前位置 - 上一个匹配组长度【比如(())这里面的longest[i-1]就是2】- 1【就是找到匹配当前')'的前一个')'的'('的组内index】
            if(s.charAt(i) == ')' && i-longest[i-1]-1 >= 0 && s.charAt(i-longest[i-1]-1) == '('){
                // 比如()(())，自己摆弄一下index就懂了
                longest[i] = longest[i-1] + 2 + ((i-longest[i-1]-2 >= 0)?longest[i-longest[i-1]-2]:0);
                curMax = Math.max(longest[i],curMax);
            }
        }
        return curMax;
    }
}

class Solution {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        String maxStr;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                    // 由于这里有坐标了，如果要应对FB的followup，我们直接用substring取这一段，就能返回最长的这段了
                    maxStr = s.substring(stack.peek(), i);
                }
            }
        }
        return maxans;
    }
}