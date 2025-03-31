package src.binaryTree.bst;

import src.binaryTree.Node;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class TwoSumInBST {
    Set<Integer> set = new HashSet<>();

    public boolean findTarget(Node root, int k) {
        if (root.left == null && root.right == null)
            return false;
        inorderTraversal(root);
        for (int i : set) {
            if (set.contains(k - i) && i != (k - i))
                return true;
        }
        return false;
    }

    public void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        set.add(root.val);
        inorderTraversal(root.right);
    }

    //Another Solution
    public boolean findTarget2(Node root, int k) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Set<Integer> set = new HashSet<>();
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(set.contains(k-node.val)){
                return true;
            }
            set.add(node.val);
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
        return false;
    }
}
