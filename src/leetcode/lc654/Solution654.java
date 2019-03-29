package lc654;

import TreeNode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 解法十分巧妙的一道题，使用栈来保存读到的比较大的元素
 */
public class Solution654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> stack = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            TreeNode curr = new TreeNode(nums[i]);
            // 只要栈顶元素的值小于遍历元素，就说明栈内的这个元素虽然是在数组靠前的位置，但又比当前数字小，所以是当前节点的左孩子节点
            // 同时这个栈是维护较大数字节点的，所以顺便把比较小的值出栈
            while (!stack.isEmpty() && stack.peek().val < nums[i]) {
                curr.left = stack.pop();
            }
            // 经过上面的处理，现在如果栈不为空的话，栈顶元素数值一定比当前元素大
            // 又因为当前元素在栈顶元素在数组位置的右边，所以就能知道当前元素是栈顶元素的右子节点
            // 毕竟根节点的值必须是最大的，两个子节点都要比他小
            if (!stack.isEmpty()) {
                stack.peek().right = curr;
            }
            // 最后把这个元素入栈，进入下轮循环
            stack.push(curr);
        }
        // 最后我们就知道最大的元素就留在了栈底，所以利用deque的简易方法取出来
        return stack.isEmpty() ? null : stack.removeLast();
    }
}
