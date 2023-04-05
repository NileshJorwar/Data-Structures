package src.practice;

import java.util.LinkedList;
import java.util.Queue;
public class BinaryTree_LevelOrderTraversal {
	static Node root = null;

	class Node {
		char key;
		Node left, right;
	}

	Node insert(Node root, char data) {
		if (root == null) {
			Node node = new Node();
			node.key = data;
			node.left = node.right = null;
			return node;
		} else if (data <= root.key)
			root.left = insert(root.left, data);
		else
			root.right = insert(root.right, data);
		return root;
	}
	
	void levelOrder(Node root)
	{
		if(root==null)
			return ;
		Queue<Node> queue=new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty())
		{
			Node current=queue.peek();
			queue.poll();
			System.out.println(current.key);
			if(current.left!=null)
				queue.add(current.left);
			if(current.right!=null)
				queue.add(current.right);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree_LevelOrderTraversal bst = new BinaryTree_LevelOrderTraversal();
		root = bst.insert(root, 'A');
		root = bst.insert(root, 'B');
		root = bst.insert(root, 'Z');
		root = bst.insert(root, 'D');
		root = bst.insert(root, 'C');
		root = bst.insert(root, 'M');
		bst.levelOrder(root);
		System.out.println("Time Complexity - O(n)-- no of nodes");
	}
}


