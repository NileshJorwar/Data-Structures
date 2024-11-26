package src.binaryTree.parenttarversal;

import src.binaryTree.Node;

import java.util.*;
import java.util.stream.Collectors;


public class PrintAllNodesAtDistanceKBT {

    public static void main(String[] args) {
        Node rootNode = new Node(1);
        rootNode.right = new Node(3);
        rootNode.left = new Node(2);
        rootNode.left.left = new Node(4);
        rootNode.left.right = new Node(10);
        rootNode.left.left.right = new Node(5);
        rootNode.left.left.right.right = new Node(6);
        rootNode.right.left = new Node(7);
//        rootNode.right.right = new Node(10);
        List<Integer> lists = printAllNodeAtDistanceK(rootNode, rootNode.left.right,2);
        System.out.println(lists);
    }

    private static List<Integer> printAllNodeAtDistanceK(Node rootNode, Node target, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Node, Node> parentMap = new HashMap<>();
        //create parent map for each child will be key and have parent node
        markParents(parentMap, rootNode);
        //perform BFS from target node now and hence use visited map
        Map<Node, Boolean> visitedMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(target);
        int level = 0;
        visitedMap.put(target, true);

        while(!queue.isEmpty()){
            int size = queue.size();
            if(level == k){
                break;
            }
            level++;
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if(node.left!=null && visitedMap.get(node.left)==null){
                    visitedMap.put(node.left,true);
                    queue.add(node.left);
                }
                if(node.right!=null && visitedMap.get(node.right)==null){
                    visitedMap.put(node.right,true);
                    queue.add(node.right);
                }
                if(parentMap.get(node)!=null && visitedMap.get(parentMap.get(node))==null){
                    visitedMap.put(parentMap.get(node),true);
                    queue.add(parentMap.get(node));
                }
            }

        }

        result = queue.stream().map(x->x.val).collect(Collectors.toList());

        return result;
    }

    private static void markParents(Map<Node, Node> parentMap, Node rootNode) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(rootNode);
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.left!=null){
                parentMap.put(node.left, node);
                queue.add(node.left);
            }
            if(node.right!=null){
                parentMap.put(node.right, node);
                queue.add(node.right);
            }

        }

    }


}
