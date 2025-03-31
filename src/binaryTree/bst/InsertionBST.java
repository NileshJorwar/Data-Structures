package src.binaryTree.bst;

import src.binaryTree.Node;

public class InsertionBST {

    public Node insertIntoBST(Node root, int val) {
        if(root==null){
            return new Node(val);
        }
        if(root.val>val){
            root.left = insertIntoBST(root.left,val);
        }
        else{
            root.right = insertIntoBST(root.right,val);
        }
        return root;
    }
}
