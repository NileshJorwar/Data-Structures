package src.binaryTree;


public class MaxDepthHeightOfBinaryTree {
    public static void main(String[] args) {
        Node rootNode = new Node(1);
        rootNode.right = new Node(7);
        rootNode.left = new Node(2);
        rootNode.left.left = new Node(3);
        rootNode.left.right = new Node(4);
        rootNode.left.right.left = new Node(5);
        rootNode.left.right.right = new Node(6);
        int h = findMaxDepthOrHeitghOfBT(rootNode);
        System.out.println("Height/Depth: "+h);
    }

    public static int findMaxDepthOrHeitghOfBT(Node node){
        if(node==null)
            return 0;
        int leftH = findMaxDepthOrHeitghOfBT(node.left);
        int rightH = findMaxDepthOrHeitghOfBT(node.right);

        return 1 + Math.max(leftH, rightH);
    }

}
