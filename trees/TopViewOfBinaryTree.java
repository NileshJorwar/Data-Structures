package trees;

import java.util.*;

public class TopViewOfBinaryTree {
    public static void main(String[] args) {
        // Horizontal distance is specified if traversing left and right
        /* Construct the following binary tree
                  hd = 0
                  25
                /    \
               /      \
              /        \
      hd=-1 12        13 hd=1
            /  \
           /    \
    hd=-2 7      5 hd=0
                 /  \
                /    \
         hd=-1 6      8 hd=1

       */

        // Top View = 7, 12 , 25, 13
        // Bottom View = 7, 6, 8, 13
        // Needs to perform level order traversal , hence queue like structure and map to store the result
        Node root = new Node(25);
        root.left = new Node(12);
        root.right = new Node(13);
        root.left.left = new Node(7);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(8);

        List<Integer> list = prinTopView(root);
        System.out.println(list);
    }
    static class Pair{
        int hd;
        Node node;
        Pair(int hd, Node node){
            this.hd = hd;
            this.node = node;
        }
    }
    static List<Integer> prinTopView(Node root){
        Queue<Pair> queue = new ArrayDeque<>();
        Map<Integer, Integer> map = new TreeMap<>();
        queue.add(new Pair(0, root));
        while (!queue.isEmpty()){

            Pair current = queue.poll();
            if(!map.containsKey(current.hd))
            {
                map.put(current.hd, current.node.data);
            }
            if(current.node.left!=null)
                queue.add(new Pair(current.hd -1, current.node.left));
            if(current.node.right!=null)
                queue.add(new Pair(current.hd +1, current.node.right));
        }
        List<Integer> a = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            a.add(entry.getValue());
        }

        return a;
    }
}

