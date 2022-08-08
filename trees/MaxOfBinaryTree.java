package trees;

public class MaxOfBinaryTree {
    public static void main(String[] args) {

        /* Construct the following binary tree
                  25
                /    \
               /      \
              /        \
             12        13
            /  \      /  \
           /    \    /    \
          7      5  6      8
         /
        /
       3

       */


        Node root = new Node(25);
        root.left = new Node(12);
        root.right = new Node(13);
        root.left.left = new Node(7);
        root.left.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(8);

        int max = computeMax(root);
        //Note: max of tree is computed by comparing max in left subtree with max of right subtree and with root node value
        System.out.println("Max of the tree: " + max);
    }

    static int computeMax(Node root) {
        if (root == null)
            return Integer.MIN_VALUE;

        int left = computeMax(root.left);
        int right = computeMax(root.right);

        return Math.max(root.data, Math.max(left, right));

    }
}

