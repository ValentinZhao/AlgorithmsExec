package lc109;

import ListNode.ListNode;
import TreeNode.TreeNode;

/**
 * 这题可以这么做，就是divide and conquer法，同时加上DFS来做，每次都找到一段list的中间值，然后两边构建树到这个节点的left和right上
 * 有个巧妙的方式是利用快慢指针，毕竟原来的链表是有序的，快指针一定是走过了慢指针两倍的距离，所以快指针到tail的时候慢指针就在中间
 * 这样可以把时间空间都压到最低
 */
public class Solution109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return toBST(head, null);
    }

    private TreeNode toBST(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;
        if (head == tail) return null;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = toBST(head, slow);
        root.right = toBST(slow.next, tail);
        return root;
    }

    /**
     * 这里还有个简易版的
     */
    public TreeNode sortedListToBST2(ListNode head) {
        if(head == null){   //corner case
            return null;
        }
        int count = countHelper(head);
        return dfs(head, 0, count - 1);
    }
    private TreeNode dfs(ListNode head, int left, int right){
        if(left > right){   //base case
            return null;
        }
        if(left == right){   //base case
            return new TreeNode(head.val);
        }
        ListNode p = head;
        int mid = left + (right - left)/2;
        for(int i = left; i < mid; i++){  //in each recursion , try to cut the list into half
            p = p.next;
        }
        TreeNode root = new TreeNode(p.val);
        root.left = dfs(head, left, mid - 1);
        root.right = dfs(p.next, mid + 1, right);
        return root;
    }
    private int countHelper(ListNode head){   //count the total nodes
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }
}

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return toBST(head, null);
    }

    private TreeNode toBST(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;
        // 是同一个点的话，应该是遍历到结尾了，这时候相当于叶子节点的child
        if (head == tail) return null;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = toBST(head, slow);
        root.right = toBST(slow.next, tail);

        return root;
    }
}
