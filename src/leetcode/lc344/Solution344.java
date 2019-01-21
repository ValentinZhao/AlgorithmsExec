package lc344;

public class Solution344 {
    public String reverseString(String s) {
        if (s == null || s == "") return s;
        int start = 0;
        int end = s.length();
        char[] chrAry = s.toCharArray();
        while (start < end) {
            char temp = chrAry[start];
            chrAry[start] = chrAry[end];
            chrAry[end] = temp;
            start++;
            end--;
        }
        return new String(chrAry);
    }
}
