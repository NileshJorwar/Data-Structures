package trees;

public class SizeOfBinaryTree {
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

        int size = computeSize(root);
        //Note: size of tree is computed by counting nodes in tree  + 1
        System.out.println("Size of the tree: " + size);
    }

    static int computeSize(Node root) {
        if (root == null)
            return 0;

        int left = computeSize(root.left);
        int right = computeSize(root.right);

        return left +  right + 1;

    }
}

