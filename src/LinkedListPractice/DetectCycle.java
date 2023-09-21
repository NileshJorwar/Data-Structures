package src.LinkedListPractice;

import java.util.HashSet;
import java.util.Set;

public class DetectCycle {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(5);
        list.insert(10);
        list.insert(12);
        list.insert(15);
        list.insert(30);
    }

    public boolean hasCycle(Node head) {
        //Flyod's Cycle Detection Algo
        //User slow and fast pointers
        Node slow = head;
        Node fast = head;
        while(fast !=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle2(Node head) {
        //Using HashSet
        Set<Node> set = new HashSet<>();
        Node temp = head;

        while(temp!=null){
            if(set.contains(temp))
            {
                return true;
            }else{
                set.add(temp);
            }

            temp=temp.next;
        }
        return false;
    }
}
