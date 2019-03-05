package lc394;

/**
 * 这是一道非常经典的DFS题，我们发现原字符串的特点是数字后面一定会有中括号[]，所以我们只需要在上层遍历一遍，在每次遇到[的时候，
 * 我们向后找离这个最近的]，把中间这段给substring下来，递归调用decode，这样的话我们就可以先获得这一子串的结果，最后原串也就获得结果了
 */
public class Solution394 {
    public String decodeString(String s) {
        if (s.length() == 0) return "";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 读这个串的时候，只有两种情况，读到数字或字母
            // 数字就进入切字符串递归的流程，字母的话，说明是游离在pattern之外的，那就直接插入builder中
            if (Character.isDigit(c)) {
                int digitBegin = i;
                while (s.charAt(i) != '[') i++;
                int num = Integer.valueOf(s.substring(digitBegin, i));
                int count = 1;
                int strBegin = i + 1;
                i++;
                // 直接读到最后一个匹配当前'['的']'
                while (count != 0) {
                    if (s.charAt(i) == '[') count ++;
                    else if (s.charAt(i) == ']') count --;
                    i ++;
                }
                i--;
                // 在这里递归调用，生成子串的结果
                String pattern = decodeString(s.substring(strBegin, i));
                for (int j = 0; j < num; j++) {
                    builder.append(pattern);
                }
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
