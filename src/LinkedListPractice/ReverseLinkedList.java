package src.LinkedListPractice;

public class ReverseLinkedList {
    private boolean stop;
    private ListNode left;
    private static ListNode head;

    class ListNode {
        int val;
        ListNode next;
    }

    public void recurseAndReverse(ListNode right, int m, int n) {

        // base case. Don't proceed any further
        if (n == 1) {
            return;
        }

        // Keep moving the right pointer one step forward until (n == 1)
        right = right.next;

        // Keep moving left pointer to the right until we reach the proper node
        // from where the reversal is to start.
        if (m > 1) {
            this.left = this.left.next;
        }

        // Recurse with m and n reduced.
        this.recurseAndReverse(right, m - 1, n - 1);

        // In case both the pointers cross each other or become equal, we
        // stop i.e. don't swap val any further. We are done reversing at this
        // point.
        if (this.left == right || right.next == this.left) {
            this.stop = true;
        }

        // Until the boolean stop is false, swap val between the two pointers
        if (!this.stop) {
            int t = this.left.val;
            this.left.val = right.val;
            right.val = t;

            // Move left one step to the right.
            // The right pointer moves one step back via backtracking.
            this.left = this.left.next;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        this.left = head;
        this.stop = false;
        this.recurseAndReverse(head, m, n);
        return head;
    }

    public void insert(int val) {
        ListNode newNode = new ListNode();
        newNode.val = val;
        newNode.next = null;
        if (head == null) {
            head = newNode;
        } else {
            ListNode n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = newNode;
        }
    }

    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        list.insert(10);
        list.insert(6);
        list.insert(4);
        list.insert(9);
        list.insert(11);
        list.insert(8);
        list.insert(28);
        list.insert(45);
//        list.reverseBetween(head, 3, 6);
        reverseBetween2(head, 3, 6);
    }

    // 10 -> 6  -> 4  -> 9 ->11 ->8->28->45
    static ListNode reverseBetween2(ListNode head, int m, int n) {
        if (head == null)
            return null;
        ListNode current = head, prev = null;
        while (m > 1) {
            prev = current;
            current = current.next;
            m--;
            n--;
        }
        ListNode con = prev, tail = current;
        ListNode third = null;
        while (n > 0) {
            third = current.next;
            current.next = prev;
            prev = current;
            current = third;
            n--;
        }
        con.next = prev;
        tail.next = current;
        return head;
    }

}
