package lc889;

import TreeNode.TreeNode;

import java.util.Arrays;

public class Solution889 {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int N = pre.length;
        if (N == 0) return null;
        TreeNode root = new TreeNode(pre[0]);
        if (N == 1) return root;

        int L = 0; // 我们知道pre[1]就是左子树的根，那么我们在post中找这个数的位置再加一所代表的长度，就是整个左子树的部分，这就便于我们递归
        for (int i = 0; i < post.length; i++) {
            if (post[i] == pre[1]) L = i + 1;
        }
        // 同时我们也可以借用这个L来切割数组
        root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, L+1), Arrays.copyOfRange(post, 0, L));
        root.right = constructFromPrePost(Arrays.copyOfRange(pre, L+1, N), Arrays.copyOfRange(post, L, N-1));

        return root;
    }
}
