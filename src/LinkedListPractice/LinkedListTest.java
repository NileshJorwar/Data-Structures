package src.LinkedListPractice;

public class LinkedListTest {
    LinkedNode head;

    class LinkedNode {
        int data;
        LinkedNode next;
    }

    public void insert(int data) {
        LinkedNode newNode = new LinkedNode();
        newNode.data = data;
        newNode.next = null;
        if (head == null) {
            head = newNode;
        } else {
            LinkedNode n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = newNode;
        }
    }

    public void showLinkedList() {
        LinkedNode n = head;
        while (n.next != null) {
            System.out.println(n.data);
            n = n.next;
        }
        System.out.println(n.data);
    }

    public void insertAtBegin(int data) {
        LinkedNode newNode = new LinkedNode();
        newNode.data = data;
        newNode.next = null;

        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertAtN(int data, int pos) {
        LinkedNode newNode = new LinkedNode();
        newNode.data = data;
        newNode.next = null;

        if (head == null) {
            head = newNode;
            return;
        }
        if (pos == 1) {
            newNode.next = head;
            head = newNode;
            return;
        } else {
            LinkedNode node = head;
            for (int i = 0; i < pos - 2; i++) {
                node = node.next;
            }
            newNode.next = node.next;
            node.next = newNode;
        }
    }

    public void insertAtLast(int data) {
        LinkedNode newNode = new LinkedNode();
        newNode.data = data;
        newNode.next = null;
        LinkedNode node = head;
        while (node.next != null) {
            node = node.next;
        }
        newNode.next = node.next;
        node.next = newNode;
    }

    public void deleteAt(int pos) {
        if (head == null) {
            return;
        } else if (pos == 1) {
            LinkedNode node = head;
            head = node.next;
            node = null;
        } else {
            LinkedNode prevNodeToBeDeleted = head;
            for (int i = 0; i < pos - 2; i++) {
                prevNodeToBeDeleted = prevNodeToBeDeleted.next;
            }
            LinkedNode nodeToBeDeleted = prevNodeToBeDeleted.next;
            prevNodeToBeDeleted.next = nodeToBeDeleted.next;
            nodeToBeDeleted = null;

        }
    }

    public void deleteNode(int data) {
        LinkedNode node = head;
        LinkedNode prev = null;
        if (head == null) {
            return;
        } else if (head.next != null && head.data == data) {
            node = node.next;
            head = node;
            return;
        } else {
//            LinkedNode prev = head;
            while (node.next != null && node.data != data) {
                prev = node;
                node = node.next;
            }
            prev.next = node.next;

        }
    }

    public int get(int index) {
        if (index < 0)
            return -1;
        if (head == null)
            return -1;

        LinkedNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;

    }

    public void reverseList() {
        if (head == null)
            return;
        LinkedNode current = head, next;
        LinkedNode prev = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public LinkedNode reverseBetween(int left, int right) {
        LinkedNode d = new LinkedNode();
        d.next = head;
        if (head == null || head.next == null)
            return head;
        LinkedNode untilLeft = head;
        for (int i = 0; i < left - 2; i++) {
            untilLeft = untilLeft.next;
        }
        LinkedNode fromLeftToRight = untilLeft;
        int total = right - left + 1;
        for (int i = 0; i < total; i++) {
            fromLeftToRight = fromLeftToRight.next;
        }
        LinkedNode end = fromLeftToRight.next;
        fromLeftToRight.next = null;
        LinkedNode temp = untilLeft.next;
        LinkedNode rev = reverse(temp);
        untilLeft.next = rev;
        temp.next = end;
        return d.next;
    }

    public LinkedNode reverse(LinkedNode head) {
        LinkedNode current = head, next;
        LinkedNode prev = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
       return prev;
    }

    public static void main(String[] args) {
        LinkedListTest linkedListTest = new LinkedListTest();
        /*
        linkedListTest.insert(9);
        linkedListTest.insertAtBegin(7);
        linkedListTest.insertAtN(10, 2);
        linkedListTest.insertAtN(1, 1);
        linkedListTest.insertAtN(55, 2);
        linkedListTest.insertAtLast(66);

        linkedListTest.reverseList();
        linkedListTest.showLinkedList();
        linkedListTest.get(2);

        linkedListTest.deleteAt(1);
        linkedListTest.deleteNode(10);
        linkedListTest.deleteNode(66);
        linkedListTest.deleteNode(55);
        linkedListTest.deleteNode(9);
*/
        linkedListTest.insert(10);
        linkedListTest.insert(6);
        linkedListTest.insert(4);
        linkedListTest.insert(9);
        linkedListTest.insert(11);
        linkedListTest.insert(8);
        linkedListTest.insert(28);

        linkedListTest.reverseBetween(3, 5);
        linkedListTest.showLinkedList();


    }

}

