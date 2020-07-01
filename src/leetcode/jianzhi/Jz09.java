package jianzhi;

public class Jz09 {
    public int JumpFloorII(int target) {
        if(target == 0) return 0;

        int[] dp = new int[target + 1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2;i <= target;i++) {
            // 在这之后的每一步情况，其实都可以理解成在第i步时，直接跳了n-i过来到达当前位置
            for(int j = 0;j < i;j++) {
                dp[i] += dp[j];
            }
        }

        return dp[target];
    }
}
