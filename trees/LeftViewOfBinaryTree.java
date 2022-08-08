package trees;

import java.util.*;

public class LeftViewOfBinaryTree {
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

        //printing left view
        // 25, 12,  7,  6
        printLeftView(root);
        System.out.println("--------");
        printLeftViewUsinglevelOrderTraversal(root);
        System.out.println("--------");
//        printLeftViewHashMap(root);
        printLeftViewUsingRecursion(root);
    }

    static void printLeftView(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        System.out.println("" + root.data);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.left != null) {
                System.out.print(" ," + node.left.data);
                queue.add(node.left);
            }
            if (node.right != null && (node.right.right != null || node.right.left != null))
                queue.add(node.right);
        }
    }

    static void printLeftViewUsinglevelOrderTraversal(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        System.out.print(" " + root.data);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.left != null) {
                System.out.print(" " + root.left.data);
                queue.add(node.left);
            }
            if (node.right != null)
                queue.add(node.right);
        }
    }

//    static Map<Integer, Integer> printLeftViewHashMap(Node root) {
//        Map<Integer, Integer> map = new HashMap<>();
//        Queue<Node> queue = new LinkedList<>();
//        queue.add(root);
//        if (root != null)
//            map.put(0, root.data);
//        int i = 1;
//        while (!queue.isEmpty()) {
//            Node node = queue.poll();
//            if (node.left != null) {
//                if (!map.containsKey(i))
//                    map.put(i, root.data);
//                queue.add(node.left);
//                i++;
//            }
//            if (node.right != null) {
//                queue.add(node.right);
//            }
//        }
//        return map;
//    }

    public static void printLeftViewUsingRecursion(Node root) {
        List<Node> list = new ArrayList<>();
        printLeftViewUsingLevel(root, list, 0);
        for (Node node :
                list) {
            System.out.println(node.data);
        }
    }

    public static void printLeftViewUsingLevel(Node root, List<Node> list, int level) {
        if (root == null) {
            return;
        }

//        if(list.get(level) == null)
//            list.set(level, root);

        if(level == list.size())
            list.add(root);

        printLeftViewUsingLevel(root.left, list, level + 1);
        printLeftViewUsingLevel(root.right, list, level + 1);
    }
}

