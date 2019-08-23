package lc017;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * EXAMPLE:
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class Solution017 {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if (digits == null) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add(""); // 第一次peek需要有一个值，长度为0时直接peek会报错

        /**
         * 采用FIFO的思想，第一次进入，根据mapping把三个字母分别塞入ans中，此时就是三个单字母元素
         * 第二次进入，i是1，这个i就可以理解为每个需要被修改的元素的元素长度
         * 每次for-i之前会推出一个元素，把这个元素分别在for-i中添加另外的字母并塞回ans中，只要while读取到的ans中的元素还有长度为i的，就继续添加字母在后面
         * 这样就会把原来的三个元素分别加上新字母在后面并推入了队列，全部元素长度为2，接下再就以此类推
         */
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            // 这个判断就很巧妙了，他只允许比当前遍历到的位数短一位的元素执行下面的字符串拼接操作
            while(ans.peek().length() == i) {
                String t = ans.remove();
                for (char s : mapping[x].toCharArray()) {
                    ans.add(t+s);
                }
            }
        }
        return ans;
    }
}
