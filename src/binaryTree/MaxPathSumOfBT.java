package src.binaryTree;

/*
 * Balanced Binary Tree:
 *  for every node, height_left(subtree) - height_right(subtree) <=1
 * */
public class MaxPathSumOfBT {
    static int max_sum = 0;

    public static void main(String[] args) {
        Node rootNode = new Node(1);
        rootNode.right = new Node(7);
        rootNode.left = new Node(2);
        rootNode.left.left = new Node(3);
        rootNode.left.right = new Node(4);
        rootNode.left.right.left = new Node(5);
        rootNode.left.right.right = new Node(6);

        int res = maxPathSum(rootNode);
        System.out.println(max_sum + ": maxPathSum");
    }


    public static int maxPathSum(Node node) {
        if (node == null)
            return 0;
        int left = Math.max(0, maxPathSum(node.left));
        int right = Math.max(0, maxPathSum(node.right));
        max_sum = Math.max(max_sum, left + right + node.val);
        return node.val + Math.max(left, right);
    }

}
