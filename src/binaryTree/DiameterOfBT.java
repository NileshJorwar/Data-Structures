package src.binaryTree;

/*
 * Balanced Binary Tree:
 *  for every node, height_left(subtree) - height_right(subtree) <=1
 * */
public class DiameterOfBT {

    public static void main(String[] args) {
        Node rootNode = new Node(1);
        rootNode.right = new Node(7);
        rootNode.left = new Node(2);
        rootNode.left.left = new Node(3);
        rootNode.left.right = new Node(4);
        rootNode.left.right.left = new Node(5);
        rootNode.left.right.right = new Node(6);
        int max_global = 0;
        diameter(rootNode,max_global);
        System.out.println(max_global + ": diameter");
    }


    public static int diameter(Node node, int max_global) {
        if (node == null)
            return 0;
        int left = diameter(node.left, max_global);
        int right = diameter(node.right, max_global);
        max_global = Math.max(left + right, max_global);
        int ht = 1 + Math.max(left, right);
        return ht;
    }

}
