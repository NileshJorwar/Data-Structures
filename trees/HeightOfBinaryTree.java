package trees;

public class HeightOfBinaryTree {
    public static void main(String[] args) {

        /* Construct the following binary tree
                  25
                /    \
               /      \
              /        \
             12        13
            /  \      /  \
           /    \    /    \
          7      5  6      7
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
        root.right.right = new Node(7);

        int height = computeHeight(root);
        //Note: height of tree is computed by maxHeight(left and right subtree) + 1
        System.out.println("Height of the tree: " + height);
    }

    static int computeHeight(Node root) {
        if (root == null)
            return 0;

        int left = computeHeight(root.left);
        int right = computeHeight(root.right);

        return Math.max(left, right) + 1;

    }
}

