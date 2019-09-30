package lc921;

/**
 * if (c == '('), we increment right,
 * if (c == ')'), we decrement right.
 * When right is already 0, we increment left
 * Return left + right in the end
 */
public class Solution921 {
    public int minAddToMakeValid(String S) {
        int left = 0, right = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') {
                right++;
            } else if (right > 0) {
                right--;
            } else {
                left++;
            }
        }
        return left + right;
    }
}
