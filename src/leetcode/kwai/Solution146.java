package kwai;

import java.util.HashMap;
import java.util.Map;

public class Solution146 {
    private Map<Integer, DoubleLinkedNode> map;
    private DoubleLinkedNode head;
    private DoubleLinkedNode tail;
    private int count, capacity;


    public Solution146(int capacity) {
        map = new HashMap<>();
        capacity = capacity;
        count = 0;
        head = new DoubleLinkedNode(0,0);
        tail = new DoubleLinkedNode(0,0);
        head.next = tail;
        head.pre = null;
        tail.pre = head;
        tail.next = null;
    }

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

    private DoubleLinkedNode popTail() {
        DoubleLinkedNode pre = tail.pre;
        this.removeNode(pre);
        return pre;
    }

    private void moveToHead(DoubleLinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    public int get(int key) {
        DoubleLinkedNode node = map.get(key);
        if (node != null) {
            this.moveToHead(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            DoubleLinkedNode node = new DoubleLinkedNode(key, value);
            count++;
            this.addNode(node);
            map.put(key, node);
            if (count > capacity) {
                DoubleLinkedNode pop = this.popTail();
                map.remove(pop.key);
                count--;
            }
        } else {
            DoubleLinkedNode node = map.get(key);
            node.value = value;
            map.put(key, node);
            this.moveToHead(node);
        }
    }

    static class DoubleLinkedNode {
        int key;
        int value;
        DoubleLinkedNode pre;
        DoubleLinkedNode next;

        public DoubleLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
