package lc440;

// 把这道题转化成10叉树来思考
public class Solution440 {
	public int findKthNumber(int n, int k) {
        int curr = 1;
        k = k - 1;
        while (k > 0) {
            int steps = calSteps(n, curr, curr + 1);
            if (steps <= k) {
                curr += 1;
                k -= steps;
            } else {
                // 当前这一层包含的数字量已经大于k，说明k是在这个树里面的
                // 那我们乘10，也就是下降一层来找这个curr
                curr *= 10;
                k -= 1;
            }
        }
        return curr;
    }

    // 计算n1和n2之间，到底有多少个数字
    // use long in case of overflow
    public int calSteps(int n, long n1, long n2) {
        int steps = 0;
        while (n1 <= n) {
            steps += Math.min(n + 1, n2) - n1;
            n1 *= 10;
            n2 *= 10;
        }
        return steps;
    }
}
