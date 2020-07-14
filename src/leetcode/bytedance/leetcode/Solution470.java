package bytedance.leetcode;

public class Solution470 extends SolBase {
    public int rand10() {
        int result = 40;
        while (result > 40) {
            result = 7 * (rand7() - 1) + rand7(); // 保证1-49均匀分布，这个while又保证能均匀产出一个40以下的数，这样我们取余就可以了
        }

        return result % 10 + 1;
    }

}

class SolBase {
    public int rand7() {
        return 0;
    }
}
