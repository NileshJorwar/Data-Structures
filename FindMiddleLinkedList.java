
public class FindMiddleLinkedList {
	static Node head = null;

	static class Node {
		int val;
		Node next;

	}

	public void insert(int val) {
		Node node = new Node();
		node.val = val;
		node.next = null;
		if (head == null)
			head = node;
		else {
			Node n = head;
			while (n.next != null) {
				n = n.next;
			}
			n.next = node;
		}

	}

	public void printList() {
		Node n = head;
		while (n.next != null) {
			System.out.print(n.val + " -> ");
			n = n.next;
		}
		System.out.println(n.val);
	}

	public int findMiddleUsingCount() {
		int count = 1;
		if (head == null) {
			return 0;
		}
		// Using Count
		Node countPtr = head;
		Node countPtr2 = head;
		while (countPtr.next != null) {
			countPtr = countPtr.next;
			count++;
		}

		for (int j = 0; j < (count / 2); j++)
			countPtr2 = countPtr2.next;
		return countPtr2.val;
	}

	public int findMiddleUsingTwoPtr() {
		int count = 1;
		Node current = head;
		Node slow = head;
		if (head == null) {
			return 0;
		}

		// Using two pointers
		while (current != null & current.next != null) {
			current = current.next.next;
			slow = slow.next;
		}
		return slow.val;

	}

	public int findMiddleUsingMidCount() {
		int count = 2;
		Node mid = head;
		if (head == null) {
			return 0;
		}
		int b=1;
		
		while(head!=null)
		{
			int c=count&b;
			if(c==1)
				mid=mid.next;
			head=head.next;
			count++;
		}
		return mid.val;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindMiddleLinkedList f = new FindMiddleLinkedList();
		f.insert(10);
		f.insert(2);
		f.insert(30);
		f.insert(52);
		f.insert(5);
		f.insert(555);
		f.insert(40);
		f.printList();
		int middle = f.findMiddleUsingMidCount();
		System.out.println("Middle-" + middle);
	}

}
