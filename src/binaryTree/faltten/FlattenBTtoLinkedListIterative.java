package src.binaryTree.faltten;

import src.binaryTree.Node;

import java.util.Stack;

public class FlattenBTtoLinkedListIterative {
    static Node prev = null;
    public static void main(String[] args) {
        Node rootNode = new Node(1);
        rootNode.right = new Node(5);
        rootNode.left = new Node(2);
        rootNode.left.left = new Node(3);
        rootNode.left.right = new Node(4);
        rootNode.right.right = new Node(6);
        rootNode.right.right.left = new Node(7);
        flattenTreeToLinkedList(rootNode);
        System.out.println();
    }

    public static void flattenTreeToLinkedList(Node rootNode) {
        Stack<Node> stack = new Stack<>();
        stack.push(rootNode);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
            if(!stack.isEmpty()){
                node.right=stack.peek();
            }
            node.left=null;
        }
    }
}
