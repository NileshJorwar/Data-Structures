package src.LinkedListPractice;

public class DetectFirstNodeInCycle {

    Node detectFistNodeInCycle(Node head) {
        //Find Cycle
        Node meet = findCyclicNode(head);
        Node start = head;
        while (start != meet) {
            start = start.next;
            meet = meet.next;

        }
        return start;
    }

    public Node findCyclicNode(Node head) {
        //Flyod's Cycle Detection Algo
        //User slow and fast pointers
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
