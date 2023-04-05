package src.LinkedListPractice;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/*
* We are given head, the head node of a linked list containing unique integer values.

We are also given the list nums, a subset of the values in the linked list.

Return the number of connected components in nums, where two values are connected if they appear consecutively in the linked list.

*/
public class LinkedListComponent {
    Node head;

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

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LinkedListComponent list = new LinkedListComponent();
        list.insert(0);
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        int re = list.numComponents(new int[]{0, 3, 1, 4});
        System.out.println("Result:" + re);
    }

    public int numComponents(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Node node = head;
        for (int i : nums)
            set.add(i);
        int count = 0;
        while (node != null) {
            if ((set.contains(node.data) && (node.next == null) ||
                    !set.contains(node.next.data)))
            {
                count++;
            }
            node = node.next;
        }
        return count;
    }
}
