package trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalOfBinaryTree {
    public static void main(String[] args) {

        /* Construct the following binary tree
                  25
                /    \
               /      \
              /        \
             12        13
            /  \      /  \
           /    \    /    \
          7      5  6      8
         /
        /
       3

       */


        Node root = new Node(25);
        root.left = new Node(12);
        root.right = new Node(13);
        root.left.left = new Node(7);
        root.left.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(8);

        //printing nodes in level wise
        // 25, 12, 13, 7, 5 , 6, 8, 3
        levelOrderTraversal(root);

    }

    static void levelOrderTraversal(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(" " + node.data);
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
    }
}

