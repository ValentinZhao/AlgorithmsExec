package lc373;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 跟meeting room II差不多，我们使用最小堆来保存sum最小的pairs的数据，然后就是利用最小堆巧妙地进行全排列
 * 基本思想就是最小堆poll出来的一定是sum最小的，但不一定是前一位最小的，比如这种组合(7,5) (11,2)，明显后者sum更小
 * 下一个poll出来的应该是(11,2)，最小堆就能实现
 */
public class Solution373 {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> list = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return list;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);

        // 第三个参数就是去记录读到了nums2的哪个index，每次入堆都会+1
        for (int i = 0; i < nums1.length; i++) minHeap.offer(new int[]{nums1[i], nums2[0], 0});
        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            list.add(new int[]{cur[0], cur[1]});
            if (cur[2] == nums2.length - 1) continue;
            minHeap.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
        }
        return list;
    }
}
