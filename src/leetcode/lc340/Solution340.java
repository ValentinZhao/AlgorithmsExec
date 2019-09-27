package lc340;

public class Solution340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int left = 0, distinct = 0, res = 0;
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)] == 0) distinct++;
            count[s.charAt(i)]++;
            while (distinct > k) {
                // sliding window左边界向右推，left当前位置的count自然要减一
                count[s.charAt(left)]--;
                // 比如有一种情况"eeecdd"，这时候left向右平移一次还是不能把e都去掉，所以削减到0才能把种类减一
                if (count[s.charAt(left)] == 0) distinct--;
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int left = 0, res = 0, distinct = 0;
        int[] count = new int[256];
        char[] cArr = s.toCharArray();
        for (int i = 0; i < cArr.length; i++) {
            if (count[cArr[i]] == 0) distinct++;
            count[cArr[i]]++;
            while (distinct > k) {
                count[cArr[left]]--;
                if (count[cArr[left]] == 0) distinct--;
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}