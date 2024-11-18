package src.binaryTree;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TraversalsTreeIterativeRecursiveUsingStacks {
    public static void main(String[] args) {
        Node rootNode = new Node(1);
        rootNode.right = new Node(7);
        rootNode.left = new Node(2);
        rootNode.left.left = new Node(3);
        rootNode.left.right = new Node(4);
        rootNode.left.right.left = new Node(5);
        rootNode.left.right.right = new Node(6);

        System.out.println("InOrder");
        inOrder(rootNode);
        System.out.println();
        System.out.println("PreOrder");
        preOrder(rootNode);
        System.out.println();
        System.out.println("PostOrder");
        postOrder(rootNode);
        System.out.println();
        System.out.println("Level Order");
        List<Integer> list = leverOrderTraversal(rootNode);
        System.out.println();
        System.out.println(list);
        System.out.println("Iterative PreOrder...");
        List<Integer> listPreOrder = preOrderIterative(rootNode);
        System.out.println(listPreOrder);
        System.out.println("Iterative InOrder...");
        List<Integer> listInOrder = inOrderIterative(rootNode);
        System.out.println(listInOrder);
        System.out.println("Iterative PostOrder using 2 stacks...");
        List<Integer> listPostOrder = postOrderIterative(rootNode);
        System.out.println(listPostOrder);
        System.out.println("Iterative PostOrder using Single Stack...");
        List<Integer> listPostOrder2 = postOrderIterativeUsingSingleStack(rootNode);
        System.out.println(listPostOrder2);
        List<Integer> inPrePost = inPrePostUsingSingleStack(rootNode);
        System.out.println(inPrePost);
        System.out.println("Practice");
        System.out.println("Iterative: " + preOrderIter(rootNode));
    }

    public static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    public static void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static List<Integer> leverOrderTraversal(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> arrayList = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            arrayList.add(current.data);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return arrayList;
    }

    public static List<Integer> preOrderIter(Node root) {
        List<Integer> ans = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node n = stack.pop();
            ans.add(n.data);
            if (n.right != null) {
                stack.push(n.right);
            }
            if (n.left != null) {
                stack.push(n.left);
            }
        }
        return ans;
    }

    public static List<Integer> preOrderIterative(Node root) {
        System.out.println("Using Stack for preOrder------");
        List<Integer> arrayList = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            arrayList.add(current.data);
            if (current.right != null)
                stack.push(current.right);
            if (current.left != null)
                stack.push(current.left);
        }
        return arrayList;
    }

    public static List<Integer> inOrderIte(Node root) {
        List<Integer> ans = new ArrayList<>();
        Node n = root;
        Stack<Node> stack = new Stack<>();
        while (true) {
            if (n != null) {
                stack.push(n);
                n = n.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                Node k = stack.pop();
                ans.add(k.data);
                n = k.right;
            }
        }
        return ans;
    }

    public static List<Integer> inOrderIterative(Node root) {
        System.out.println("Using Stack for Inorder Traversal------");

        Stack<Node> stack = new Stack<>();
        List<Integer> arrayList = new ArrayList<>();
        Node node = root;
        while (true) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                if (stack.isEmpty())
                    break;
                Node temp = stack.pop();
                arrayList.add(temp.data);
                node = temp.right;
            }
        }
        return arrayList;
    }

    public static List<Integer> postOrderIterative2(Node root){
        System.out.println("Using 2 stacks.");
        Stack<Node> stack1 = new Stack<>();
        Stack<Integer> res = new Stack<>();
        stack1.push(root);
        while(!stack1.isEmpty()){
            Node n = stack1.pop();
            res.push(n.data);
            if(n.left!=null){
                stack1.push(n.left);
            }
            if(n.right!=null){
                stack1.push(n.right);
            }
        }
        return res.stream().collect(Collectors.toList());
    }
    public static List<Integer> postOrderIterative(Node root) {
        System.out.println("Using 2 Stack for Postorder Traversal------");
        Stack<Node> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            Node node = stack1.pop();
            stack2.push(node.data);
            if (node.left != null)
                stack1.push(node.left);
            if (node.right != null)
                stack1.push(node.right);
        }
        List<Integer> list = stack2.stream().collect(Collectors.toList());
//        Collections.sort(list, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2.compareTo(o1);
//            }
//        });
        Collections.reverse(list);
        System.out.println("hi");
        System.out.println("hi");
        return list;
    }

    public static List<Integer> postOrderIterativeUsingSingleStack(Node root) {
        System.out.println("Using 1 Stack for Postorder Traversal------");
        Stack<Node> stack1 = new Stack<>();
        stack1.push(root);
        List<Integer> list = new ArrayList<>();
        Node current = root, temp;
        while (current != null || !stack1.isEmpty()) {
            if (current != null) {
                stack1.push(current);
                current = current.left;
            } else {
                temp = stack1.peek().right;
                if (temp == null) {
                    temp = stack1.pop();
                    list.add(temp.data);
                    while (!stack1.isEmpty() && temp == stack1.peek().right) {
                        temp = stack1.pop();
                        list.add(temp.data);
                    }
                } else
                    current = temp;
            }
        }
        return list;

    }

    public static List<Integer> allTraversalsUsingSingleStack(Node root){
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root,1));

        while(!stack.isEmpty()){

            Pair p = stack.pop();
            if(p.number == 1){
                // preorder
                preOrder.add(p.node.data);
                p.number++;
                stack.push(p);
                if(p.node.left!=null){
                    stack.push(new Pair(p.node.left, 1));
                }
            }
            else if(p.number == 2){
                // preorder
                inOrder.add(p.node.data);
                p.number++;
                stack.push(p);
                if(p.node.left!=null){
                    stack.push(new Pair(p.node.left, 1));
                }
            }
            else{
                postOrder.add(p.node.data);
            }
        }
        return inOrder;
    }


    public static List<Integer> inPrePostUsingSingleStack(Node root) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));

        while (!stack.isEmpty()) {
            Pair p = stack.pop();
            if (p.number == 1) {
                preOrder.add(p.node.data);
                p.number++;
                stack.push(p);
                if (p.node.left != null) {
                    stack.push(new Pair(p.node.left, 1));
                }
            } else if (p.number == 2) {
                inOrder.add(p.node.data);
                p.number++;
                stack.push(p);
                if (p.node.right != null) {
                    stack.push(new Pair(p.node.right, 1));
                }
            } else {
                postOrder.add(p.node.data);
            }
        }
//        ans = Stream.concat(preOrder.stream(), inOrder.stream(), postOrder.stream()).collect(Collectors.toList());
        ans.addAll(preOrder);
        ans.addAll(inOrder);
        ans.addAll(postOrder);
        return ans;
    }

}

class Pair {
    Node node;
    int number;

    Pair(Node node, int number) {
        this.node = node;
        this.number = number;
    }
}
