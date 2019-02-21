package lc038;

public class Solution038 {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String lastStr = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int count = 0;
        char c = '0';
        for (int i = 0; i < lastStr.length(); i++) {
            c = lastStr.charAt(i);
            count = 1;
            while ((i + 1 < lastStr.length()) && lastStr.charAt(i + 1) == c) {
                i++;
                count++;
            }
            sb.append(count+""+c);
        }
        return sb.toString();
    }
}
