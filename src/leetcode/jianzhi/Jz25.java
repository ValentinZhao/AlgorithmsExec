package jianzhi;

public class Jz25 {
    public RandomListNode Clone(RandomListNode pHead) {
        RandomListNode iter, next;
        iter = pHead;
        while (iter != null) {
            next = iter.next;
            RandomListNode copy = new RandomListNode(iter.label);
            iter.next = copy;
            copy.next = next;
            iter = next;
        }

        iter = pHead;
        while (iter != null) {
            if (iter.random != null) iter.next.random = iter.random.next;
            iter = iter.next.next;
        }

        RandomListNode dummy = new RandomListNode(0);
        RandomListNode copy, copyIter = dummy;
        iter = pHead;
        while (iter != null) {
            next = iter.next.next;
            copy = iter.next;
            copyIter.next = copy;
            copyIter = copy;
            iter.next = next;
            iter = next;
        }

        return dummy.next;
    }

    class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}
