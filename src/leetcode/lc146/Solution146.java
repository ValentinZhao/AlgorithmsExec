package lc146;

import java.util.HashMap;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 *
 * 我们使用双向链表来维持数据结构，使用HashMap来存储数据。基本的最近最少使用算法就是每次把你访问过的元素(比如调用过get)推到双向链表的队头
 * 然后每次set的时候都把新数据从队头塞进去，毕竟无论是get还是set，当前操作过的数据一定是最近使用过的，在第二位的元素就优先级低一些，以此类推
 * 那么之后就很简单，我们set的时候肯定要先查HashMap的size和capacity，这时候如果超额了就把队尾的那个元素pop掉，最后加一些边界条件即可
 * PS: 使用双向链表是因为双向链表具有O(1)的插入删除复杂度，因为它删除是不需要reference的，直接把自身的前后指针互相ref自己就被推出了
 */

public class Solution146 {
    private HashMap<Integer, DoubleLinkedNode> cache = new HashMap<>();
    // 使用假的头尾方便进行推入和退出队尾的操作，同时也因此不需要进行边界检查了
    private DoubleLinkedNode head, tail;
    private int count, capacity;

    private void addNode(DoubleLinkedNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(DoubleLinkedNode node) {
        DoubleLinkedNode pre = node.pre;
        DoubleLinkedNode next = node.next;
        pre.next = next;
        next.pre = pre;
    }

    private void moveToHead(DoubleLinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    private DoubleLinkedNode popTail() {
        DoubleLinkedNode pre = tail.pre;
        this.removeNode(pre);
        return pre;
    }

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        head = new DoubleLinkedNode();
        tail = new DoubleLinkedNode();
        head.pre = null;
        head.next = tail;
        tail.pre = head;
        tail.next = null;
    }

    public int get(int key) {
        DoubleLinkedNode node = cache.get(key);
        if (node != null) {
            this.moveToHead(node);
            return node.value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        DoubleLinkedNode node = cache.get(key);
        if (node == null) {
            DoubleLinkedNode newNode = new DoubleLinkedNode();
            newNode.key = key;
            newNode.value = value;
            cache.put(key, newNode);
            this.addNode(newNode);
            ++this.count;
            if (this.count > this.capacity) {
                DoubleLinkedNode tailNode = this.popTail();
                cache.remove(tailNode.key);
                --this.count;
            }
        } else {
            node.value = value;
            this.moveToHead(node);
        }
    }
}

class DoubleLinkedNode {
    int key;
    int value;
    DoubleLinkedNode pre;
    DoubleLinkedNode next;
}
