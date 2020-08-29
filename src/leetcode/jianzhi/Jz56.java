package jianzhi;

import ListNode.ListNode;

public class Jz56 {
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode dummy = new ListNode(0);
        dummy.next = pHead;
        ListNode cur = dummy;
        while(cur.next!=null && cur.next.next != null){
            if(cur.next.val == cur.next.next.val){
                ListNode tmp = cur.next;
                while(tmp !=null && tmp.next!=null && tmp.val == tmp.next.val){
                    tmp = tmp.next;
                }
                cur.next = tmp.next;
            }else{
                cur = cur.next;
            }
        }
        return dummy.next;
    }


    public ListNode deleteDuplication2(ListNode pHead) {
        if (pHead == null || pHead.next == null) return pHead; // 只有0个或1个结点，则返回

        if (pHead.val == pHead.next.val) { // 当前结点是重复结点
            ListNode pNode = pHead.next;
            // 跳过值与当前结点相同的全部结点,找到第一个与当前结点不同的结点
            while (pNode != null && pNode.val == pHead.val) pNode = pNode.next;
            // 从第一个与当前结点不同的结点开始递归
            return deleteDuplication(pNode);
        } else {
            // 注意这里的区别，这里是把递归结果给到当前节点后的，如果当前节点和后面的不重复的话
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }

    public ListNode deleteDuplication1(ListNode pHead) {
        if (pHead==null || pHead.next==null) return pHead;
        ListNode dummy = new ListNode(0);
        dummy.next = pHead;
        ListNode pre = dummy, cur = dummy.next;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) cur = cur.next;
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = pre.next;
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
