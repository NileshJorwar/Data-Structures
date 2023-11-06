package src.LinkedListPractice;

public class DetectFirstNodeInCycleII {

    public Node detectCycle(Node head) {
        Node meet = findCyclicNode(head);
        Node start = head;
        if (meet == null)
            return null;
        while (start != meet) {
            start = start.next;
            meet = meet.next;
        }
        return start;
    }

    public Node findCyclicNode(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }
}
