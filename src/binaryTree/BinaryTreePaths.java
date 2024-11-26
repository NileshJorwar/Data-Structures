package src.binaryTree;

import java.util.ArrayList;
import java.util.List;


public class BinaryTreePaths {

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
        List<String> answer = new ArrayList<>();
        binaryTreePaths(rootNode, "", answer);
//        List<String> answer2 =  binaryTreePaths(rootNode);
        System.out.println(answer);
    }


    private static void binaryTreePaths(Node node, String path, List<String> answer) {
        if (node.left == null && node.right == null) {
            answer.add(path+node.val);
        }
        if(node.left!=null)
            binaryTreePaths(node.left, path + node.val + "->", answer);
        if(node.right!=null)
            binaryTreePaths(node.right, path + node.val + "->", answer);
    }


}
