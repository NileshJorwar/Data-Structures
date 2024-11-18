package src.binaryTree;

import java.util.ArrayList;
import java.util.List;


public class InOrderTraversalLC {
    public static void main(String[] args) {
        TreeNodeSL treeNodeSL = new TreeNodeSL();
        treeNodeSL.val = 1;
        treeNodeSL.left = null;
        treeNodeSL.right = new TreeNodeSL(2);
        treeNodeSL.right.left = new TreeNodeSL(3);

        new InOrderTraversalLC().inorderTraversal(treeNodeSL);
    }

    public List<Integer> inorderTraversal(TreeNodeSL root) {
        if (root == null)
            return null;
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        return res;
    }

    public void inOrder(TreeNodeSL root, List<Integer> res) {
        if (root == null)
            return;
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
    }
}

class TreeNodeSL {
    int val;
    TreeNodeSL left;
    TreeNodeSL right;

    TreeNodeSL() {
    }

    TreeNodeSL(int val) {
        this.val = val;
    }

    TreeNodeSL(int val, TreeNodeSL left, TreeNodeSL right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}