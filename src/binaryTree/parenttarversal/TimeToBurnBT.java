package src.binaryTree.parenttarversal;

import src.binaryTree.Node;

import java.util.*;
import java.util.stream.Collectors;


public class TimeToBurnBT {

    public static void main(String[] args) {
        Node rootNode = new Node(1);
        rootNode.right = new Node(3);
        rootNode.left = new Node(2);
        rootNode.left.left = new Node(4);
        rootNode.left.right = new Node(10);
        rootNode.left.left.right = new Node(5);
        rootNode.left.left.right.right = new Node(6);
        rootNode.right.left = new Node(7);
        int time = amountOfTime(rootNode, 3);
        System.out.println(time);
    }

    public static int amountOfTime(Node root, int start) {
        Map<Node, Node> parentMap = new HashMap<>();
        //find the parent 5,1 and 3,1 etc.
        findParentMap(root, parentMap);
        Node[] target = new Node[1];

        //Target set
        findTargetNode(root, start, target);
        // now perform the BFS
        Map<Node, Boolean> visitedMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        visitedMap.put(target[0], true);
        queue.add(target[0]);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.left != null && visitedMap.get(node.left) == null) {
                    queue.add(node.left);
                    visitedMap.put(node.left, true);
                }
                if (node.right != null && visitedMap.get(node.right) == null) {
                    queue.add(node.right);
                    visitedMap.put(node.right, true);
                }
                if (parentMap.get(node) != null && visitedMap.get(parentMap.get(node)) == null) {
                    queue.add(parentMap.get(node));
                    visitedMap.put(parentMap.get(node), true);
                }

            }
        }
        return level-1;
    }

    public static void findTargetNode(Node root, int start, Node[] target) {
        if (root == null)
            return;
        if (root.data == start) {
            target[0] = root;
            return;
        }
        findTargetNode(root.left, start, target);
        findTargetNode(root.right, start, target);
    }

    public static void findParentMap(Node root, Map<Node, Node> parentMap) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            if (n.left != null) {
                queue.add(n.left);
                parentMap.put(n.left, n);
            }
            if (n.right != null) {
                queue.add(n.right);
                parentMap.put(n.right, n);
            }
        }

    }


}
