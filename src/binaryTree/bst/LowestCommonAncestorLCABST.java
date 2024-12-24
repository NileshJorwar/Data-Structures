package src.binaryTree.bst;

import src.binaryTree.Node;

/*
* LCA: lowest common between the two
* */
public class LowestCommonAncestorLCABST {

    public static void main(String[] args) {
        Node rootNode = new Node(10);
        rootNode.right = new Node(13);
        rootNode.left = new Node(6);
        rootNode.left.left = new Node(4);
        rootNode.left.right = new Node(7);
        rootNode.right.right = new Node(19);
        rootNode.right.right.left = new Node(17);
        Node lca = lca(rootNode, new Node(4), new Node(7));
        Node lca2 = lca2(rootNode, new Node(4), new Node(7));
        System.out.println(lca);
    }

    private static Node lca2(Node rootNode, Node p, Node q) {
        if(rootNode == null)
            return null;
        Node current = rootNode;
        while(current!=null){
            int curr = current.val;
            if(curr> p.val && curr>q.val){
                current = current.left;
            }
            else if(curr< p.val && curr < q.val){
                current = current.right;
            }
            else{
                return current;
            }
        }
        return current;

    }

    private static Node lca(Node rootNode, Node p, Node q) {
        if(rootNode==null)
            return null;
        int curr  = rootNode.val;
        if(curr> p.val && curr > q.val){
            return lca(rootNode.left, p ,q);
        }
        if(curr< p.val && curr < q.val){
            return lca(rootNode.right, p ,q);
        }
        return rootNode;
    }





}
