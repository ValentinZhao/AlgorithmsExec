package lc362;

public class HitCounter {
    private int[] timestamps;
    private int[] hits;
    /** Initialize your data structure here. */
    public HitCounter() {
        // 300是因为题目是以秒为最小粒度，并且只计算过去5mins的数据，那这样不就是300么
        // 很巧妙的一点在于，为了节省空间，我们使用timestamp的300的模来作为数组下标，这对于5分钟过期的数据来说也是非常有效的计算方式
        timestamps = new int[300];
        hits = new int[300];
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int index = timestamp % 300;
        if (timestamps[index] != timestamp) {
            timestamps[index] = timestamp;
            hits[index] = 1;
        } else {
            hits[index]++;
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int total = 0;
        for (int i = 0; i < 300; i++) {
            if (timestamp - timestamps[i] < 300) total += hits[timestamp];
        }
        return total;
    }
}
