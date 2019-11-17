package nutanix;

/**
 * There are certain parts of a fence which need to be painted. Tom wants to divide work in such a way that each person gets exactly 1 contiguous part of the fence to paint.
 *
 * Calculate number of ways in which Tom can divide the work. 2 ways are distinct if they don't have exactly the same number of of pieces allocated.
 *
 * Input:
 * n = Number of parts of fence
 * arr = State of the fence. 1 indicates that the part needs to be painted, 0 means it does not need to be painted.
 *
 * Test Cases:
 * n = 5, arr = 10101
 * Output = 4
 *
 * The ways to divide the fence are:
 * 10|10|1
 * 1|010|1
 * 10|1|01
 * 1|01|01
 *
 * n = 2, arr = 00
 * Output = 0
 * The fence does not need any painting
 */

// 解法很简单，就是把所有1的位置记下来，然后把他们的距离差求积
// 那么其实就是，我们可以自底向上看，10101的话，我们先看1010[1]，这时候只有一种分割1010|1
// 那么倒数第二个1，就有10[101]，这时候我们发现有101|01和1010|1的分割，那其实就是取决于这中间有几个0，再加上1本身的长度就是可排列的种类数

public class PaintFence {
    public int countWays(int[] arr, int n) {
        int pos[] = new int[n];
        int p = 0, i;

        // for loop for saving the
        // positions of all 1s
        for (i = 0; i < n; i++)
        {
            if (arr[i] == 1)
            {
                pos[p] = i + 1;
                p++;
            }
        }

        // If array contains only 0s
        if (p == 0)
            return 0;

        int ways = 1;
        for (i = 0; i < p - 1; i++)
        {
            ways *= pos[i + 1] - pos[i];
        }

        // Return the total ways
        return ways;
    }
}