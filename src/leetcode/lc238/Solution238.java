package lc238;

/**
 * 这题是坑在元素为0，和元素是正负混合的时候，直接用总积除每个元素得到的数组是会除到0的（会报错）
 */
class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answers = new int[n];

        // answer[i] contains the product of all the elements to the left
        // Note: for the element at index '0', there are no elements to the left,
        // so the answer[0] would be 1
        answers[0] = 1;
        for (int i = 1; i <= n; i++) {
            // answer[i - 1] already contains the product of elements to the left of 'i - 1'
            // Simply multiplying it with nums[i - 1] would give the product of all
            // elements to the left of index 'i'
            answers[i] = answers[i-1] * nums[i-1];
        }
        // R contains the product of all the elements to the right
        // Note: for the element at index 'length - 1', there are no elements to the right,
        // so the R would be 1
        int r = 1;
        for (int i = n-1; i >= 0 ; i++) {
            // For the index 'i', R would contain the
            // product of all elements to the right. We update R accordingly
            answers[i] *= r;
            r *= nums[i];
        }
        return answers;
    }
}