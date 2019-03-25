package lc134;

public class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0;
        int currTank = 0;
        int startPoint = 0;
        for (int i = 0; i < gas.length; i++) {
            totalTank += gas[i] - cost[i];
            currTank += gas[i] - cost[i];
            if (currTank < 0) {
                // 说明从i出发不行，我们重来；那么有人可能会问说直接从i+1开始，这趟路程到最后也没走完你怎么知道就是正确的呢？
                // 其实是这样，当我们走到i发现车厢是没油了的话，这证明从startPoint到这里的每个点到这里其实都不会是正确的，也就是说
                // 要是想获得正确结果前面的路都要舍弃掉，那我们就从i+1开始记，如果从i+1到最后都是可以的，然后再从最后到i这步有前面的认证其实也是可以的
                // 那么这样成环就是正确的
                startPoint = i + 1;
                currTank = 0;
            }
        }
        return totalTank >= 0 ? startPoint : -1;
    }
}
