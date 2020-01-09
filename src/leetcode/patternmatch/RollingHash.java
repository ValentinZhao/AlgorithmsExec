package patternmatch;

public class RollingHash {
    public static final int d = 256;

    public void rollingHashSearch(String pattern, String text, int q) {
        // 这个参数q是一个素数，是用来计算rolling hash的因子
        int m = pattern.length();
        int n = text.length();

        int i, j;

        int p = 0; // pattern的hash值，注意p计算出来之后就不变了
        int t = 0; // text的每个m长度子串的hash，这个就是所谓rolling-hash的值了
        int h = 1; // h就是我们用来计算rolling hash的一个因子

        for (i = 0; i < m-1; i++) {
            h = (d*h) % q;
        }

        for (i = 0; i < m; i++) {
            p = (d*p + pattern.charAt(i)) % q;
            t = (d*t + text.charAt(i)) % q;
        }

        for (i = 0; i <= n-m; i++) {
            if (p == t) {
                for (j = 0; j < m; j++) {
                    if (pattern.charAt(j) != text.charAt(i+j)) break;
                }
                if (j == m) System.out.println("Find Match at Index: " + i);
            }
            if (i < n-m) {
                // 这个就是rolling hash的公式了，基本思想就是去掉最高位，再加上即将进入的那一位完成re-hash
                t = (d * (t - h*text.charAt(i)) + text.charAt(i+m)) % q;
                if (t < 0) t += q;
            }
        }
    }
}
