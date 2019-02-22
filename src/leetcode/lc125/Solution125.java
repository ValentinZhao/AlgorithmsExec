package lc125;

public class Solution125 {
    class Solution {
        public boolean isPalindrome(String s) {
            char[] strArr = s.toLowerCase().toCharArray();
            StringBuilder sb = new StringBuilder();
            for (char c : strArr) if (isLowercaseLetterOrNumber(c)) sb.append(c);
            strArr = sb.toString().toCharArray();
            int i = 0, j = strArr.length - 1;
            while (i < j) if (strArr[i++] != strArr[j--]) return false;
            return true;
        }

        private boolean isLowercaseLetterOrNumber(char c) {
            return (((int) c < 123) && ((int) c > 96)) ||
                    (((int) c < 58) && ((int) c > 47));
        }
    }
}
