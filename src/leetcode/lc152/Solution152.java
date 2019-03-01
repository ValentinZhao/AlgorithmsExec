package lc152;

/**
 * imax代表以i为结尾的最大积(maximum product), imin反之
 */
public class Solution152 {
    public int maxProduct(int[] nums) {
        int result = nums[0];
        for (int i = 1, imax = nums[0], imin = nums[0]; i < nums.length; i++) {
            // 当元素为负数时，乘最大值会让它突然反转变为最小值，最小值变最大值，所以为了算出真正的最大值我们需要先将两者互换
            // 这种情况就像是一串sub-array一直是负的，但是它在数组下个元素遇到负数时直接变最大了，就比如[-1,2,-3]，在前两位的时候product还是-2，第三位直接变6了
            // 这时候真正的最大积是6，是经过imax，imin互换才得到的
            if (nums[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            // 这个max和min函数用的很妙，它是如何维护一个连续的sub-array的呢？以最大值为例，如果它在imax之后的一个值令product更大，就直接取imax * nums[i]
            // 这其实就是把结果子数组加多了一位，比如原来的子数组是[2,3]，下一位是4，那imax变为2*3*4，子数组变为[2,3,4]；如果没有当前数字大，比如imax是个负数
            // 就把nums[i]给到imax，这样其实就相当于重置了sub-array，截断了以前的数组
            imax = Math.max(nums[i], imax * nums[i]);
            imin = Math.min(nums[i], imin * nums[i]);
            result = Math.max(result, imax);
        }
        return result;
    }

    // 这里有第二种做法，比较好理解
    // 设DP[i]是以i位置元素为终点的子序列的乘积，那么DP[i]的最大值就是我们要的解。
    // DP[i] = max( DP[i - 1] * nums[i], nums[i] )
    // 上面的方程是错的，因为没有考虑到负数的情况，比如数组[-10,5,-10]，DP[0] = -10, DP[1] = 5, DP[2] =-10，最大乘积是5。 但实际上最大乘积是 -10 * 5　＊ (-10) = 500。
    // 正确的方程是，记录2个DP数组，一个记乘积最大值，一个记乘积最小值，然后综合2个DP数组的结果，就可以得到真正的最大值。
    // DP_max[i] = max( DP_min[i - 1] * nums[i], DP_max[i - 1] * nums[i], nums[i])
    // DP_min[i] = min( DP_min[i - 1] * nums[i], DP_max[i - 1] * nums[i], nums[i])
    // 他其实就是不需要判断下一个数组元素的正负了，每次循环都算出所有结果返回给最大，更有点像暴力DP，但无疑更好理解了
    public int maxProduct2 (int[] A) {
        int[] maxDP = new int[A.length];
        int[] minDP = new int[A.length];
        maxDP[0] = A[0];
        minDP[0] = A[0];
        int result = maxDP[0];
        for (int i = 1; i < A.length; i++) {
            maxDP[i] = Math.max(Math.max(A[i], A[i] * maxDP[i-1]), A[i] * minDP[i-1]);
            minDP[i] = Math.min(Math.min(A[i], A[i] * maxDP[i-1]), A[i] * minDP[i-1]);
            result = Math.max(result, maxDP[i]);
        }
        return result;
    }
}
