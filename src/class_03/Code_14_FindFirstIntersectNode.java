package class_03;

public class Code_14_FindFirstIntersectNode {

	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

	public static Node getIntersectNode(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		Node loop1 = getLoopNode(head1); //找到head1入环节点
		Node loop2 = getLoopNode(head2); //找到head2入环节点
		if (loop1 == null && loop2 == null) { //两个无环链表的相交问题
			return noLoop(head1, head2);
		}
		if (loop1 != null && loop2 != null) { //两个有环链表的相交问题
			return bothLoop(head1, loop1, head2, loop2);
		}
		return null; //一个有环一个无环，则不相交返回空
	}

	public static Node getLoopNode(Node head) {
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
		Node n1 = head.next; // n1 -> slow
		Node n2 = head.next.next; // n2 -> fast
		while (n1 != n2) {
			if (n2.next == null || n2.next.next == null) {
				return null;
			}
			n2 = n2.next.next;
			n1 = n1.next;
		}
		n2 = head; // n2 -> walk again from head
		while (n1 != n2) { //快节点回到head之后，再次一步一步走，最终会在入环节点处，快指针慢指针相遇。
			n1 = n1.next;
			n2 = n2.next;
		}
		return n1; //返回相遇时刻的入环节点
	}

	public static Node noLoop(Node head1, Node head2) { //无环链表的相交
		if (head1 == null || head2 == null) {
			return null;
		}
		Node cur1 = head1;
		Node cur2 = head2;
		int n = 0;
		while (cur1.next != null) {
			n++;
			cur1 = cur1.next;
		}
		while (cur2.next != null) {
			n--;
			cur2 = cur2.next;
		}
		if (cur1 != cur2) { //cur1和cur2分别为两个链表的末尾节点，如果不相同则链表不相交。
			return null;
		}
		cur1 = n > 0 ? head1 : head2; //如果head1的长度更长(n>0)，则head1先走多出的步数，然后一起走
		cur2 = cur1 == head1 ? head2 : head1; //cur1如果为head1，cur2赋值为head2，反之亦反之。
		n = Math.abs(n);
		while (n != 0) {
			n--;
			cur1 = cur1.next;
		}
		while (cur1 != cur2) { //从头结点开始遍历，直至找到第一个相同的入环节点，返回即可。
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur1;
	}

	public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) { //有环链表的相交
		Node cur1 = null;
		Node cur2 = null;
		if (loop1 == loop2) { //第二种情况，当两个入环节点相同 loop1 == loop2 的时候，使用无环链表相交的那一套。
			cur1 = head1;
			cur2 = head2;
			int n = 0;
			while (cur1 != loop1) {
				n++;
				cur1 = cur1.next;
			}
			while (cur2 != loop2) {
				n--;
				cur2 = cur2.next;
			}
			cur1 = n > 0 ? head1 : head2;
			cur2 = cur1 == head1 ? head2 : head1;
			n = Math.abs(n);
			while (n != 0) {
				n--;
				cur1 = cur1.next;
			}
			while (cur1 != cur2) {
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			return cur1;
		} else { //否则，从loop1开始通过next找loop2节点，如果找不到，那就不相交，如果找得到，那loop1就是相交节点返回即可。
			cur1 = loop1.next;
			while (cur1 != loop1) {
				if (cur1 == loop2) {
					return loop1;
				}
				cur1 = cur1.next;
			}
			return null;
		}
	}

	public static void main(String[] args) {
		// 1->2->3->4->5->6->7->null
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);

		// 0->9->8->6->7->null
		Node head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		System.out.println(getIntersectNode(head1, head2).value);

		// 1->2->3->4->5->6->7->4...
		head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);
		head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

		// 0->9->8->2...
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next; // 8->2
		System.out.println(getIntersectNode(head1, head2).value);

		// 0->9->8->6->4->5->6..
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		System.out.println(getIntersectNode(head1, head2).value);

	}

}
