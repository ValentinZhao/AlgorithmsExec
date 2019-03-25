package lc421;

/**
 * 为什么选择Trie树这里有详细的解释
 *
 * https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/discuss/130427/()-92
 * 简而言之就是对于32位整型而言呢，出现的数字总有前面很多位为0，这就导致待比较的数字有很多共同部分，这就想到了Trie树
 * 然后是异或操作，它是指把十进制数转成二进制数之后，每一位进行比较，相同则结果为1，否则为0，那么我们就知道如果想要使得结果尽量大的话
 * 我们应该尽量让相同的位处于尽量高的位置
 */
public class Solution421 {
    public int findMaximumXOR(int[] nums) {
        Trie root = new Trie(0);
        Trie curr = root;
        for (int i = 0; i < nums.length; i++) {
            // 每一位都得算一下
            for (int j = 31; j >= 0; j--) {
                // 算这一位是0还是1
                int tmp = nums[i] & (1 << j);
                // 我们设定左子树为1，右子树为0的话，当这一位为0时，为了异或出最大结果，我们需要给他
                // 安排一个0，这样才能在结果位得到一个1，也就是安排一个右子树
                if (tmp == 0) {
                    if (curr.right == null) curr.right = new Trie(0);
                    curr = curr.right;
                } else {
                    if (curr.left == null) curr.left = new Trie(1);
                    curr = curr.left;
                }
            }
            curr = root; // curr归位，从Trie树头开始重新读新的一串TrieNode
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int res = 0;
            // 每一位都得XOR算出结果然后加到res上才是这个数的异或结果
            for (int j = 31; j >= 0; j--) {
                int tmp = nums[i] & (1 << j);
                if (curr.left != null && curr.right != null) {
                    if (tmp > 0) curr = curr.right;
                    else curr = curr.left;
                } else {
                    curr = curr.left == null ? curr.right : curr.left;
                }
                res += tmp ^ (curr.val << j);
            }
            max = Math.max(max, res);
            curr = root;
        }
        return max;
    }

    private static class Trie {
        int val;
        Trie left;
        Trie right;
        Trie (int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
}
