package src.binaryTree;

import java.util.*;
import java.util.stream.Collectors;


public class TopViewOfBT {

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
        List<Integer> lists = topViewOfBT(rootNode);
        System.out.println(lists);
    }

    static class Tuple {
        Node node;
        int vertical;

        public Tuple(
                Node node,
                int vertical

        ) {
            this.node = node;
            this.vertical = vertical;

        }
    }

    public static List<Integer> topViewOfBT(Node node) {
        List<Integer> result= new ArrayList<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(node, 0));
        Map<Integer, Integer> map = new TreeMap<>();
        while(!queue.isEmpty()){

            Tuple t = queue.poll();
            int vertical = t.vertical;
            Node n = t.node;

            if(!map.containsKey(vertical)){
                map.put(vertical, n.data);
            }
            if(n.left!=null){
                queue.add(new Tuple(n.left, vertical-1));
            }
            if(n.right!=null){
                queue.add(new Tuple(n.right, vertical+1));
            }

        }
        return new ArrayList<>(map.values());
    }

}
