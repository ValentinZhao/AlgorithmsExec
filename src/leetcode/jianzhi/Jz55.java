package jianzhi;

import ListNode.ListNode;

public class Jz55 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode fast=pHead;
        ListNode low=pHead;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            low=low.next;
            if(fast==low)
                break;
        }
        if(fast==null||fast.next==null)
            return null;
        low=pHead;
        while(fast!=low){
            fast=fast.next;
            low=low.next;
        }
        return low;
    }
}
