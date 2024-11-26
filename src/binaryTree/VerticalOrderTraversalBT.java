package src.binaryTree;

import java.util.*;

/*
 * Balanced Binary Tree:
 *  for every node, height_left(subtree) - height_right(subtree) <=1
 * */
public class VerticalOrderTraversalBT {

    public static void main(String[] args) {
        Node rootNode = new Node(1);
        rootNode.right = new Node(3);
        rootNode.left = new Node(2);
        rootNode.left.left = new Node(4);
        rootNode.left.right = new Node(10);
        rootNode.left.left.right = new Node(5);
        rootNode.left.left.right.right = new Node(6);
        rootNode.right.left = new Node(7);
        rootNode.right.right = new Node(10);
        List<List<Integer>> lists = verticalOrderTraversal(rootNode);
        System.out.println(lists);
    }

    static class Tuple {
        Node node;
        int vertical;
        int level;

        public Tuple(
                Node node,
                int vertical,
                int level
        ) {
            this.node = node;
            this.vertical = vertical;
            this.level = level;
        }
    }

    public static List<List<Integer>> verticalOrderTraversal(Node node) {
        List<List<Integer>> result = new ArrayList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>>
                map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(node, 0, 0));
        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            int level = tuple.level;
            int vertical = tuple.vertical;
            Node node1 = tuple.node;

            if (!map.containsKey(vertical)) {
                map.put(vertical, new TreeMap<>());
            }
            if (!map.get(vertical).containsKey(level)) {
                map.get(vertical).put(level, new PriorityQueue<Integer>());
            }

            map.get(vertical).get(level).add(node1.val);
            if (node1.left != null) {
                queue.add(new Tuple(node1.left, vertical - 1, level + 1));
            }
            if (node1.right != null) {
                queue.add(new Tuple(node1.right, vertical + 1, level + 1));
            }
        }

        for (TreeMap<Integer, PriorityQueue<Integer>> map1: map.values()){
            result.add(new ArrayList<>());
            for (PriorityQueue<Integer> priorityQueue:map1.values()){
                while (!priorityQueue.isEmpty()){
                    result.get(result.size()-1).add(priorityQueue.poll());
                }
            }
        }

        return result;
    }

}
