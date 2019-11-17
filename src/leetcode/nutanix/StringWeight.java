package nutanix;

import java.util.Arrays;

/**
 * Problem:
 * Given a string consisting of only A’s and B’s. We can transform the given string to another string by toggling any character.
 * Thus many transformations of the given string are possible.
 * The task is to find Weight of the maximum weight transformation.
 *
 * Weight of string = Weight of total pairs +
 *                    weight of single characters -
 *                    Total number of toggles.
 *
 * Two consecutive characters are considered as pair only if they
 * are different.
 * Weight of a single pair (both character are different) = 4
 * Weight of a single character = 1
 *
 * Intuition:
 * If (n == 1)
 *    maxWeight(str[0..n-1]) = 1
 *
 * Else If str[0] != str[1]
 * // Max of two cases: First character considered separately
 * //                   First pair considered separately
 * maxWeight(str[0..n-1]) = Max (1 + maxWeight(str[1..n-1]),
 *                               4 + getMaxRec(str[2..n-1])
 * Else
 * // Max of two cases: First character considered separately
 * //                   First pair considered separately
 * // Since first two characters are same and a toggle is
 * // required to form a pair (and toggle cost 1), 3 is added for pair instead
 * // of 4
 * maxWeight(str[0..n-1]) = Max (1 + maxWeight(str[1..n-1]),
 *                               3 + getMaxRec(str[2..n-1])
 */
public class StringWeight {
    public int getMaxWeight(String str)
    {
        int n = str.length();

        // Create and initialize lookup table
        int[] dp = new int[n];
        Arrays.fill(dp ,-1);

        // Call recursive function
        // dp的意义是，以i为起始的字符串的最大weight transform是多少
        // 那么这题我们自顶向下，直接计算到最尾部的结果，再往回算
        return getMaxRec(str, 0, str.length(),
                dp);
    }

    private int getMaxRec(String str, int i, int length, int[] dp) {
        if (i >= length) return 0;

        if (dp[i] != -1) return dp[i];

        // 首先假设只有一个字符，我们计算出来一个字符的weight
        int ans = 1 + getMaxRec(str, i+1, length, dp);

        // 如果可以凑成一个pair
        if (i + 1 < length) {

            // 并且前后两个字符还不相等，这就直接凑成了一个weight为4的pair
            if (str.charAt(i) != str.charAt(i+1)) {
                ans = Math.max(ans, 4 + getMaxRec(str, i+2, length, dp));
            } else {
                // 如果前后是两个一样的字符，那这时候我们得toggle其中一个凑pair，toggle cost 1，所以加3
                ans = Math.max(ans, 3 + getMaxRec(str, i+2, length, dp));
            }
        }

        dp[i] = ans;

        return dp[i];
    }
}
