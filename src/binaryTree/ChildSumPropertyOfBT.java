package src.binaryTree;

/*
 * At any time node's value should be left+right nodes values
 * */
public class ChildSumPropertyOfBT {

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
        childSumProperty(rootNode);
        System.out.println();
    }

    private static void childSumProperty(Node root) {
        if (root == null) {
            return;
        }
        int child = 0;
        if (root.left != null) {
            child += root.left.val;
        }
        if (root.right != null) {
            child += root.right.val;
        }
        if (child >= root.val) {
            root.val = child;
        } else {
            if (root.left != null)
                root.left.val = root.val;
            if (root.right != null)
                root.right.val = root.val;
        }
        childSumProperty(root.left);
        childSumProperty(root.right);

        int total = 0;
        if (root.left != null) {
            total += root.left.val;
        }
        if (root.right != null) {
            total += root.right.val;
        }
        if (root.left != null || root.right != null) {
            root.val = total;
        }
    }


}
