package src.binaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class PostorderTraversal {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        src.binaryTree.Node rootNode = new src.binaryTree.Node(1);
        rootNode.right = new src.binaryTree.Node(7);
        rootNode.left = new src.binaryTree.Node(2);
        rootNode.left.left = new src.binaryTree.Node(3);
        rootNode.left.right = new src.binaryTree.Node(4);
        rootNode.left.right.left = new src.binaryTree.Node(5);
        rootNode.left.right.right = new src.binaryTree.Node(6);
        List<Integer> ans = posOrderTraversal(rootNode);
        System.out.println(ans + ": boundary traversal");
    }

    private static List<Integer> posOrderTraversal(Node rootNode) {
        Node node = rootNode;
        // one stack<Node> for keeping left and right;
        // and second stack<integer> to store the top of first stack ;
        // and then print second stack
        Stack<Node> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        List<Integer> result = new Stack<>();
        stack1.push(rootNode);
        while(!stack1.isEmpty()){
            Node n = stack1.pop();
            stack2.push(n.val);
            if(n.left!=null)
                stack1.push(n.left);
            if(n.right!=null)
                stack1.push(n.right);

        }
        return result;
    }
}


