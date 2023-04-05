package src.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class ZigZagTraversal {
    public static void main(String[] args) {
        Node rootNode = new Node(1);
        rootNode.right = new Node(7);
        rootNode.left = new Node(2);
        rootNode.left.left = new Node(3);
        rootNode.left.right = new Node(4);
        rootNode.left.right.left = new Node(5);
        rootNode.left.right.right = new Node(6);
        List<Integer> ans = zigZagTraversal(rootNode);
        System.out.println(ans + ": zigzag pattern");
    }
    /*
    *           1
    *       2       7
    * 3         4
    *        5      6
    * */
    public static List<Integer> zigZagTraversal(Node rootNode) {
        List<Integer> ans = new ArrayList<>();
        if (rootNode == null)
            return ans;
        Queue<Node> queue = new LinkedList<>();
        queue.add(rootNode);
        boolean leftRightFlag = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> temp = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
                if(leftRightFlag)
                    temp.addFirst(node.data);
                else{
                    temp.addLast(node.data);
                }
            }
            ans.addAll(temp);
            leftRightFlag=!leftRightFlag;
        }
        return ans;

    }


}
