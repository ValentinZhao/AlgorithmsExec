package lc138;

/**
 * 经典深拷贝题，我们采用优化过的三次轮询方案把时间复杂度降到O(n)
 * 第一轮，拷贝每一个节点到它的next上
 * 第二轮，把每个节点的random的next指向被复制节点的random上
 * 第三轮，把复制节点全部提取出来，用一个pseudoHead作头，一个一个copy到这个头上，然后把原list每两步next到一起就行了,
 * 最后被复制的list全部挂在pseudoHead上，把pseudoHead.next返回即可，毕竟它自己不属于被复制的部分
 */

public class Solution138 {
    public static class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode (int x) { this.label = x; }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode iter = head, next;
        while (iter != null) {
            next = iter.next;
            RandomListNode copy = new RandomListNode(iter.label);
            iter.next = copy;
            copy.next = next;
            iter = next;
        }

        iter = head;
        while (iter != null) {
            if (iter.random != null) iter.next.random = iter.random.next;
            iter = iter.next.next;
        }

        RandomListNode pseudoHead = new RandomListNode(0);
        RandomListNode copy, copyIter = pseudoHead;
        iter = head;
        while (iter != null) {
            next = iter.next.next;

            copy = iter.next;
            copyIter.next = copy;
            copyIter = copy;

            iter.next = next; // restore original list
            iter = next;
        }
        return pseudoHead.next;
    }
}

