package jianzhi;

public class Jz08 {
    public int JumpFloor(int target) {
        int[] dp = new int[target+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= target; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[target];
    }
}
