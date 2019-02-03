package lc151;

/**
 * 基本算法就是把整个字符串reverse过来，再遍历一次，把每个单词reverse过来，在途中去掉多余的空格，去掉空格的逻辑就是由一个新指针
 * 来负责在每个单词之后插入空格，此外的空格全部去掉
 */
public class Solution151 {
    public String reverseWords(String s) {
        if (s.length() < 1) return s;
        int fillIndex = 0;
        char[] str_arr = s.toCharArray();
        reverse(str_arr, 0 , str_arr.length - 1);
        for (int i = 0; i < str_arr.length; i++) {
            if (str_arr[i] == ' ') continue;
            if (fillIndex != 0) str_arr[fillIndex++] = ' '; // 由fillIndex控制哪里给空格，第一位除外
            int tempIndex = fillIndex;
            while (i < str_arr.length && str_arr[i] != ' ') str_arr[fillIndex++] = str_arr[i++];
            reverse(str_arr, tempIndex, fillIndex - 1); // 翻转这个单词
        }
        return new String(str_arr, 0, fillIndex);
    }

    public void reverse (char[] str, int start, int end) {
        while (start < end) {
            char c = str[start];
            str[start++] = str[end];
            str[end--] = c;
        }
    }
}
