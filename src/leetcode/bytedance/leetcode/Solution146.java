package bytedance.leetcode;

import java.util.Map;

class DoubleLinkedNode {
    int key;
    int value;
    DoubleLinkedNode pre;
    DoubleLinkedNode next;
}

class Solution146 {
    class LRUCache {
        private DoubleLinkedNode head, tail;
        private Map<Integer, DoubleLinkedNode> cache;
        private int capacity, count;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.count = 0;
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
            DoubleLinkedNode curr = cache.get(key);
            if (curr != null) {
                curr.value = value;
                moveToHead(curr);
            } else {
                DoubleLinkedNode newNode = new DoubleLinkedNode();
                newNode.key = key;
                newNode.value = value;
                cache.put(key, newNode);
                moveToHead(newNode);
                ++this.count;
                if (this.count > this.capacity) {
                    DoubleLinkedNode tail = popTail();
                    cache.remove(tail.key);
                    this.count--;
                }
            }
        }

        private void moveToHead(DoubleLinkedNode node) {
            removeNode(node);
            addNode(node);
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
            DoubleLinkedNode tail = this.tail.pre;
            removeNode(tail);
            return tail;
        }
    }
}
