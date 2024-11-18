package src.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
* width of BT : No of nodes in a level between any nodes
* */
public class MaxWidthOfBT {

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
        int maxWidthOfBT = maxWidthOfBT(rootNode);
        System.out.println(maxWidthOfBT);
    }

    private static int maxWidthOfBT(Node rootNode) {
        int ans = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(rootNode, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            int min = queue.peek().number;
            int last = 0, first = 0;
            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                Node node = pair.node;
                int num = pair.number;
                int current_id = num - min;
                if (i == 0) {
                    first = current_id;
                }
                if (i == size - 1) {
                    last = current_id;
                }
                if (node.left != null) {
                    queue.add(new Pair(node.left, current_id * 2 + 1));
                }
                if (node.right != null) {
                    queue.add(new Pair(node.right, current_id * 2 + 2));
                }
            }
            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }


}
