/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 */
class MinStack {
    private Node head;

    public MinStack() {

    }
    
    public void push(int x) {
        if (head == null) {
            head = new Node(x, x);
        } else {
            head = new Node(x, Math.min(head.min, x), head);
        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }

    private class Node {
        private int val;
        private int min;
        private Node next;
        public Node (int val, int min) {
            this.val = val;
            this.min = min;
        }

        public Node (int val, int min, Node node) {
            this.val = val;
            this.min = min;
            this.next = node;
        }
    }
}
