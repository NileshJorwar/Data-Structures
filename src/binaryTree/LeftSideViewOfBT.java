package src.binaryTree;

import java.util.*;


public class LeftSideViewOfBT {

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
        List<Integer> lists = leftSideViewOfBT(rootNode);
        System.out.println(lists);
    }

    static class Tuple {
        Node node;
        int level;

        public Tuple(
                Node node,
                int level

        ) {
            this.node = node;
            this.level = level;

        }
    }

    public static List<Integer> leftSideViewOfBT(Node node) {
        List<Integer> result= new ArrayList<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(node, 0));
        Map<Integer, Integer> map = new TreeMap<>();
        while(!queue.isEmpty()){

            Tuple t = queue.poll();
            int level = t.level;
            Node n = t.node;
            //TODO: first traverse to left and overwrite with right node values per level
            map.put(level, n.val);
            if(n.right!=null){
                queue.add(new Tuple(n.right,level+1));
            }
            if(n.left!=null){
                queue.add(new Tuple(n.left,level+1));
            }


        }
        return new ArrayList<>(map.values());
    }

}
