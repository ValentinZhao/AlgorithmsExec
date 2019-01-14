package lc002;

public class Solution002 {
	public static class ListNode {
		public int val;
		public ListNode next;
		public ListNode(int x) { this.val = x; }
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode preHead = new ListNode(0);
		ListNode runner = preHead;
		int carry = 0;
		while (l1 != null || l2 != null || carry != 0) {
			if (l1 != null) {
				carry += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				carry += l2.val;
				l2 = l2.next;
			}
			// 由于一开始有runner = preHead; 这就是把runner和preHead引到同一个内存地址的地方
			// 之后的每次runner.next = new ListNode()就是同时给了preHead和runner一个next
			// 不同点在于，由于下下一行runner的引用地址换到了runner.next，而preHead没动，这就导致下一次循环到这里时
			// preHead的地址一直没变过，而runner跑到了preHead的next节点，再下一次循环由于runner.next再次更新，preHead.next.next就有了新的值
			// 同时这个preHead.next.next，也就是本循环的runner.next再次把地址给到runner，相当于再次把preHead.next.next和runner的地址同步了起来
			// 也就是说runner.next保存的地址一直是preHead的尾next的地址，每次runner.next被赋值，preHead就延长了
			// runner = runner.next很明显就是把runner往后推一位，其实就是把runner在preHead上向后推一位（毕竟一开始起点是一样的）
			// 它的作用就很明显了，把runner作为preHead的"奔跑"节点，一直在链表尾
			runner.next = new ListNode(carry % 10);
			runner = runner.next;
			carry /= 10;
		}
		return preHead.next;
	} 	
}