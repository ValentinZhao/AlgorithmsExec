package lc043;

/**
 * 只需要重现往日的乘法算法即可，具体实现解释在
 * https://leetcode.com/problems/multiply-strings/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation
 */
public class Solution043 {
    public String multiply(String num1, String num2) {
        int m =num1.length(), n = num2.length();
        int[] indices = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + indices[i+j+1];
                indices[i+j] += sum / 10;
                // sum只可能是一位数或者是十几，所以sum/10就可以判断要不要进位
                // 毕竟一位数/10就是0，十几/10就是1嘛，如果进位了就给前面一位加上去，然后%10就可以得到这个结果的个位
                // 正好用来给到后面这位
                indices[i+j+1] = sum % 10;
            }
        }
        StringBuilder builder = new StringBuilder();
        // 这个if就是为了避免开头一位是0的情况
        for (int p : indices) if (!(builder.length() == 0 && p == 0)) builder.append(p);
        return builder.length() == 0 ? "0" : builder.toString();
    }
}

class Solution {
    public String multiply(String num1, String num2) {
        char[] chs1 = num1.toCharArray();
        char[] chs2 = num2.toCharArray();
        int m = chs1.length, n = chs2.length;
        int[] res = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (chs1[i] - '0') * (chs2[j] - '0');
                int sum = mul + res[i+j+1];
                res[i+j+1] = sum % 10;
                res[i+j] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : res) if (!(i == 0 && sb.length() == 0)) sb.append(i);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}