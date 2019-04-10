package lc975;

import java.util.TreeMap;

/**
 * 先说这题的意思：这题就是对于一个数组，我们进行奇偶跳，奇数跳找比当前元素大的、在该位置之后的其他元素中最小的那个；
 * 那么偶数跳是同理的找小元素中最大的那个。最后返回所有可以用这种方式恰好跳到末尾的起始点的数量
 * 这样的数据结构我们有TreeMap来提供 higherKey 和 lowerKey就能实现，同时我们也能很容易的发现最后一个元素天然成立。
 * 接下来其实就是一个dp问题，我们只需要给每个元素位置i，都维护一个even[i]和odd[i]的dp数组，它表示以奇偶跳跳到该位置时能否继续完成奇偶跳到达终点
 * 起始条件就是even[LEN-1] = odd[LEN-1] = true
 * 状态转移方程就是 even[i] = odd[当前节点元素值的lowerKey的index]，因为偶数跳是下降的嘛；并且由于原数组并非有序，所以向后找更小的一个数是有可能找到的，
 * 如果这个数在前面是出现过的，那么这一步奇偶跳其实就是从上一个该数字跳到现在这个位置（数字相同），那也就是even[i]=odd[上一个该数字的index]
 * 还有最后一个需要注意的点就是从后向前build dp
 * 最后我们遍历odd数组有多少个true即可，毕竟第1步是奇数
 *
 * TreeMap基于红黑树，查找效率在O(logN)，总体又走了一遍数组为O(N)，然后在遍历过程中每次都查找所以O(logN) * O(N) = O(NlogN)
 */
public class Solution975 {
    public int oddEvenJumps(int[] A) {
        int N = A.length;
        boolean[] odd = new boolean[N];
        boolean[] even = new boolean[N];
        odd[N-1] = even[N-1] = true;
        TreeMap<Integer, Integer> vals = new TreeMap<>();
        vals.put(A[N-1], N-1);
        for (int i = N-2; i >= 0 ; i--) {
            int v = A[i];
            if (vals.containsKey(v)) {
                odd[i] = even[vals.get(v)];
                even[i] = odd[vals.get(v)];
            } else {
                Integer lower = vals.lowerKey(v);
                Integer higher = vals.higherKey(v);
                if (higher != null) odd[i] = even[vals.get(higher)];
                if (lower != null) even[i] = odd[vals.get(lower)];
            }
            vals.put(v, i);
        }
        int count = 0;
        for (boolean valid : odd) if (valid) count++;
        return count;
    }
}
