import javax.swing.tree.TreeNode;
import java.util.ArrayList;

/**
 * Print a binary tree in an m*n 2D string array following these rules:
 *
 * 1. The row number m should be equal to the height of the given binary tree.
 * 2. The column number n should always be an odd number.
 * 3. The root node's value (in string format) should be put in the exactly middle of the first row it can be put.
 * The column and the row where the root node belongs will separate the rest space into two parts (left-bottom part and right-bottom part).
 * You should print the left subtree in the left-bottom part and print the right subtree in the right-bottom part.
 * The left-bottom part and the right-bottom part should have the same size.
 * Even if one subtree is none while the other is not,
 *      you don't need to print anything for the none subtree but still need to leave the space as large as that for the other subtree.
 * However, if two subtrees are none, then you don't need to leave space for both of them.
 * 4. Each unused space should contain an empty string "".
 * 5. Print the subtrees following the same rules.
 * Example 1:
 * Input:
 *      1
 *     /
 *    2
 * Output:
 * [["", "1", ""],
 *  ["2", "", ""]]
 * Example 2:
 * Input:
 *      1
 *     / \
 *    2   3
 *     \
 *      4
 * Output:
 * [["", "", "", "1", "", "", ""],
 *  ["", "2", "", "", "", "3", ""],
 *  ["", "", "4", "", "", "", ""]]
 * Example 3:
 * Input:
 *       1
 *      / \
 *     2   5
 *    /
 *   3
 *  /
 * 4
 * Output:
 *
 * [["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 *  ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 *  ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 *  ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
 * Note: The height of binary tree is in the range of [1, 10].
 */
class Solution655 {
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList();
        int height = 1;
        if (root != null) {
            height = getHeight(root);
        }
        int col = (int)Math.pow(2, height) - 1;
        ArrayList<String> rows = new ArrayList();
        for (int i = 0; i < col; i++) rows.add("");
        for (int k = 0; k < height; k++) res.add(new ArrayList(rows));
        insertMatrix(root, res, 0, height, 0, col - 1);
        return res;
    }

    /**
     * 就是通过不断分治，在下一层按照这个中心点分成两部分然后把这一层的节点定在中间，到了最后一层，比如说最左子节点，那么它的start是0，end是1
     * 取得的中间点就是(0 + 1) / 2 = 0，就直接定在了最左边，非常巧妙
     */
    public void insertMatrix(TreeNode root, List<List<String>> res, int curRow, int totalRow, int start, int end) {
        if (root == null || curRow == totalRow) return;
        res.get(curRow).set((start + end) / 2, Integer.toString(root.val));
        insertMatrix(root.left, res, curRow + 1, totalRow, start, (start + end) / 2 - 1);
        insertMatrix(root.right, res, curRow + 1, totalRow, (start + end) / 2 + 1, end);
    }

    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}