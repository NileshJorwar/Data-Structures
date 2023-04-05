package src.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    //using single stack
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode node = root, temp;
        while (true) {
            if (node != null) {
                stack1.push(node);
                node = node.left;
            } else {
                temp = stack1.peek().right;
                if (temp == null) {
                    temp = stack1.pop();
                    list.add(temp.val);
                    while (!stack1.isEmpty() && temp == stack1.peek().right) {
                        temp = stack1.pop();
                        list.add(temp.val);
                    }
                } else {
                    node = temp;
                }
            }
        }

    }

}
