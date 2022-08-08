package trees;

import java.util.*;

public class FlattenBinaryTreeToDLL {
    static Node head = null, prev = null;

    public static void main(String[] args) {
        /* Construct the following binary tree
                  hd = 0
                  25
                /    \
               /      \
              /        \
      hd=-1 12        13 hd=1
            /  \
           /    \
    hd=-2 7      5 hd=0
                 /  \
                /    \
         hd=-1 6      8 hd=1

       */
        // Need to have previous and head nodes to convert to Doubly Linked List
        // InOrder
        Node root = new Node(25);
        root.left = new Node(12);
        root.right = new Node(13);
        root.left.left = new Node(7);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(8);

        convertToDLL(root);
        Node node = head;
        while (node != null) {
            System.out.println(node.data);
            node = node.right;
        }
    }

    static void convertToDLL(Node root) {
        if (root == null)
            return;
        convertToDLL(root.left);
        if (prev == null)
            head = root;
        else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        convertToDLL(root.right);
    }
}

