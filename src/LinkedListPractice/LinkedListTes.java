package src.LinkedListPractice;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListTes {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(40);

        head.next = temp1;
        temp1.next = temp2;
        LinkedListTes.printList(head);
    }
    static void printList(Node head){
        while(head.next!=null)
        {
            System.out.println(head.data);
            head=head.next;
        }
        System.out.println(head.data);


    }
}
