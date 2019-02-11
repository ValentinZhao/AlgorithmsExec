package lc136;

/**
 * Here's the reason why it works. 1) XOR is commutative, a ^ b = b ^ a. 2) a number XOR by another number twice makes no change on original number, a ^ b ^ b = a
 * Therefore, if a number appears twice in the array, it makes no change to result. And if a number is unique, since 0 ^ unique = unique, so result = unique
 */
public class Solution136 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}