package src.binaryTree;

/*
 * Balanced Binary Tree:
 *  for every node, height_left(subtree) - height_right(subtree) <=1
 * */
public class CheckIfBalancedBT {
    public static void main(String[] args) {
        Node rootNode = new Node(1);
        rootNode.right = new Node(7);
        rootNode.left = new Node(2);
        rootNode.left.left = new Node(3);
        rootNode.left.right = new Node(4);
        rootNode.left.right.left = new Node(5);
        rootNode.left.right.right = new Node(6);
        boolean isBalancedBT = checkBalancedTree(rootNode);
        int isBalancedBT2 = checkBalancedTreeUsingHeight(rootNode);
        System.out.println("is Balanced BT: " + isBalancedBT);
        System.out.println("is Balanced BT2 : " + (isBalancedBT2 == -1 ? false : true));
    }

    public static boolean checkBalancedTree(Node node) {
        if (node == null)
            return true;
        int leftH = height(node.left);
        int rightH = height(node.right);
        //checking this root level
        if (Math.abs(leftH - rightH) > 1)
            return false;

        //checking at every node level
        boolean left = checkBalancedTree(node.left);
        boolean right = checkBalancedTree(node.right);

        if (left || right)
            return false;
        return true;
    }

    public static int height(Node node) {
        if (node == null)
            return 0;
        int leftH = height(node.left);
        int rightH = height(node.right);
        return 1 + Math.max(leftH, rightH);

    }

    public static int checkBalancedTreeUsingHeight(Node node) {
        if (node == null)
            return 0;
        int leftH = height(node.left);
        int rightH = height(node.right);
        if (leftH == -1 || rightH == -1)
            return -1;
        if (Math.abs(leftH - rightH) > 1)
            return -1;
        return 1 + Math.max(leftH, rightH);
    }

}
