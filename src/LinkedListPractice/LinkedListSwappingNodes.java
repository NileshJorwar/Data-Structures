package src.LinkedListPractice;

public class LinkedListSwappingNodes {
    static Node head;
    private boolean stop;
    private Node left;

    public class Node {
        int data;
        Node next;
    }

    public void insert(int data) {
        Node node = new Node();
        node.data = data;
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

    public void show() {
        Node n = head;
        while (n.next != null) {
            System.out.println(n.data);
            n = n.next;
        }
        System.out.println(n.data);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LinkedListSwappingNodes list = new LinkedListSwappingNodes();
        list.insert(5);
        list.insert(10);
        list.insert(12);
        list.insert(15);
        list.insert(30);
//		list.show();
        int size = list.findSize();
        list.swapNodes(head, 2, size - 2);
    }

    public void swapNodes(Node right, int start, int end) {
        if (end == 1)
            return;

        right = right.next;
        if (start > 1) {
            this.left = this.left.next;
        }
        this.swapNodes(right, start - 1, end - 1);
        if (this.left == right || right.next == this.left) {
            this.stop = true;
        } else {
            int t = this.left.data;
            this.left.data = right.data;
            right.data = t;
        }
    }

    int findSize() {
        left = head;

        Node temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }
}
