package lc076;

/**
 * 给这题举个例子，比如原串是"XXXXXCXXXVV"，然后要你匹配"CVV"，首先答案就是"CXXVV"
 * 那怎么找的呢？就是右边界先右移，找到了最后才发现CVV都包括进来了
 * 然后左边界开始向前走，收缩窗口，这就是counter == 0的深意
 * 因为在前面XXXXX的部分，counter一直都是0
 */
public class Solution076 {
    public String minWindow(String s, String t) {
        int[] arr = new int[128];
        for (int i = 0; i < t.length(); i++) {
            // 记录所有出现过的字母的出现次数
            arr[t.charAt(i)]++;
        }

        // counter是待匹配串中还未被匹配的个数
        int counter = t.length(), left = 0, right = 0, window = Integer.MAX_VALUE, head = -1;
        while (right < s.length()) {
            char rc = s.charAt(right++);
            if (arr[rc] > 0) {
                counter--;
            }
            // 重点就在这了！！
            // 无论怎样这一位的次数都会减一
            // 也就是说非匹配字符的这一位，会变成负数
            // 这就可以解释下面为什么在arr[lc]==0的时候，才把counter+1
            arr[rc]--;


            // 右边到达某个位置后，发现全部字母找完了，我们考虑左边向前走，收缩窗口
            while (counter == 0) {
                if (right - left < window) {
                    window = right - (head = left);
                }

                char lc = s.charAt(left++);

                if (arr[lc] == 0) {
                    counter++;
                }
                // 那么由于我们右移了左边界，被跳过的那一位应该被加一次计数
                // 没准在后面还能再次遇到这个字符
                // 那么如果碰巧此时，得到计数的是一个arr[lc]==0，也就是待匹配字符串中的值的话
                // 这就可以在第21行执行时，在后面查到一样的字符，加入window中
                // 那么有可能中间比以前隔着更短的距离，这样window就更小了
                arr[lc]++;
            }
        }
        return head == -1 ? "" : s.substring(head, head + window);
    }
}

class Solution {
    public String minWindow(String s, String t) {
        int[] arr = new int[128];
        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i)]++;
        }

        int counter = t.length(), left = 0, right = 0, head = -1, window = Integer.MAX_VALUE;
        while (right < s.length()) {
            char rc = s.charAt(right++);
            if (arr[rc] > 0) counter--;
            arr[rc]--;
            while (counter == 0) {
                if (right - left < window) {
                    window = right - (head = left);
                }
                char lc = s.charAt(left++);
                if (arr[lc] == 0) counter++;
                arr[lc]++;
            }
        }
        return head == -1 ? "" : s.substring(head, head + window);
    }
}