package src.binaryTree.serialization;

import src.binaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeBinaryTree {
    public static void main(String[] args) {
        Node rootNode = new Node(1);
        rootNode.right = new Node(3);
        rootNode.left = new Node(2);
        rootNode.right.left = new Node(4);
        rootNode.right.right = new Node(5);

        String rs = serializeBT(null);
        Node r = deSerializeBT(rs);
        System.out.println(rs);
    }

    private static Node deSerializeBT(String rs) {
        if(rs.equals("#,")){
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        String[] values = rs.split(",");
        Node root = new Node(Integer.parseInt(values[0]));
        queue.add(root);
        for (int i = 1; i < values.length; i++) {
            Node parent = queue.poll();
            if(!values[i].equals("#")){
                Node left = new Node(Integer.parseInt(values[i]));
                parent.left = left;
                queue.add(left);
            }
            if(!values[++i].equals("#")){
                Node right = new Node(Integer.parseInt(values[i]));
                parent.right = right;
                queue.add(right);
            }
        }
        return root;
    }

    private static String serializeBT(Node rootNode) {
        //using level order traversal
        Queue<Node> queue = new LinkedList<>();
        queue.add(rootNode);
        StringBuilder res = new StringBuilder();
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            if (n == null) {
                res.append("#,");
                continue;
            }
            res.append(n.data).append(",");
            queue.add(n.left);
            queue.add(n.right);

        }
        return res.toString();
    }
}
