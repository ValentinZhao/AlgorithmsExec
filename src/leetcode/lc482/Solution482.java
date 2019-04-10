package lc482;

/**
 * 方法很简单，首先把"-"去掉，全部升为大写，然后从后往前插入"-"，利用StringBuilder的特性很容易做到
 */
public class Solution482 {
    public String licenseKeyFormatting(String S, int K) {
        String s1 = S.replace("-", "").toUpperCase();
        StringBuilder builder = new StringBuilder(s1);
        int len = s1.length();
        for (int i = K; i < s1.length(); i = i + K) {
            builder.insert(len - i, "-");
        }
        return builder.toString();
    }
}
