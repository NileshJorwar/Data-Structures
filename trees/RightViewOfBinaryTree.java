package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewOfBinaryTree {
    public static void main(String[] args) {

        /* Construct the following binary tree
                  25
                /    \
               /      \
              /        \
             12        13
            /  \
           /    \
          7      5
                 /  \
                /    \
                6      8
       */


        Node root = new Node(25);
        root.left = new Node(12);
        root.right = new Node(13);
        root.left.left = new Node(7);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(8);

        //printing right view
        // 25, 13,  5,  8
        printRightViewUsingRecursion(root);
    }

    public static void printRightViewUsingRecursion(Node root) {
        List<Node> list = new ArrayList<>();
        printRightViewUsingLevel(root, list, 0);
//        printRightViewUsingLevel2(root, list, 0);
        for (Node node :
                list) {
            System.out.println(node.data);
        }
    }

    public static void printRightViewUsingLevel(Node root, List<Node> list, int level) {
        if (root == null) {
            return;
        }

        if(level == list.size())
            list.add(root);

        printRightViewUsingLevel(root.right, list, level + 1);
        printRightViewUsingLevel(root.left, list, level + 1);
    }

    public static void printRightViewUsingLevel2(Node root, List<Node> list, int level) {
        if (root == null) {
            return;
        }


        printRightViewUsingLevel2(root.left, list, level + 1);
        printRightViewUsingLevel2(root.right, list, level + 1);
    }
}

