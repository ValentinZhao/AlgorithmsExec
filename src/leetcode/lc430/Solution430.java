package lc430;

public class Solution430 {
    public Node flatten(Node head) {
        Node cursor = head;
        while (cursor != null) {
            if (cursor.child != null) {
                Node next = cursor.next;

                // recursive process building up the child list
                Node child = flatten(cursor.child);
                cursor.next = child;
                child.prev = cursor;
                cursor.child = null;

                // move cursor to the end of "child" list
                // then connect it to the origin "next"
                while (cursor.next != null) cursor = cursor.next;

                // connect
                if (next != null) {
                    cursor.next = next;
                    next.prev = cursor;
                }
            }
            cursor = cursor.next;
        }
        return head;
    }
}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
}

class Solution {
    public Node flatten(Node head) {
        // 如果不把head这个指针留下来，你是无法返回正确head的
        // 毕竟链表也不能往回走
        Node cursor = head;
        while (cursor != null) {
            Node next = cursor.next;

            if (cursor.child != null) {
                Node child = flatten(cursor.child);
                cursor.next = child;
                child.prev = cursor;
                while (cursor.next != null) cursor = cursor.next;
                if (next != null) {
                    cursor.next = next;
                    next.prev = cursor;
                }
            }

            cursor = cursor.next;
        }

        return head;
    }
}