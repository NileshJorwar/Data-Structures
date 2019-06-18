import java.util.Scanner;

public class BinarySearchTree {
	static Node root = null;

	class Node {
		int key;
		Node left, right;
	}

	Node insert(Node root, int data) {
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

	void printInorder(Node root) {
		if (root != null) {
			printInorder(root.left);
			System.out.println(root.key);
			printInorder(root.right);
		}
	}

	void printPreorder(Node root) {
		if (root != null) {
			System.out.println(root.key);
			printPreorder(root.left);
			printPreorder(root.right);
		}
	}

	void printPostorder(Node root) {
		if (root != null) {
			printPostorder(root.left);
			printPostorder(root.right);
			System.out.println(root.key);
		}
	}

	void search(Node root, int data) {
		if (root == null) {
			System.out.println("data not found");
			return;
		} else if (data == root.key)
			System.out.println("Data found");
		else if (data <= root.key)
				search(root.left, data);
		else
			search(root.right, data);
	}

	int findMinIterative(Node node) {
		if (node == null)
			return -1;
		while (node.left != null) {
			node = node.left;
		}
		return node.key;
	}

	int findMinRecursive(Node node) {
		if (node == null)
			return -1;
		else if (node.left == null)
			return node.key;
		return findMinRecursive(node.left);
	}

	int findMaxIterative(Node node) {
		if (node == null)
			return -1;
		while (node.right != null) {
			node = node.right;
		}
		return node.key;
	}

	int findMaxRecursive(Node node) {
		if (node == null)
			return -1;
		else if (node.right == null)
			return node.key;
		return findMaxRecursive(node.right);
	}

	int findHeightofBST(Node node) {
		if (node == null)
			return 0;
		else {
			int leftHeight = findHeightofBST(node.left);
			int rightHeight = findHeightofBST(node.right);
			if (leftHeight > rightHeight)
				return leftHeight + 1;
			else
				return rightHeight + 1;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree bst = new BinarySearchTree();
		root = bst.insert(root, 10);
		root = bst.insert(root, 110);
		root = bst.insert(root, 5);
		root = bst.insert(root, 6);
		root = bst.insert(root, 11);
		root = bst.insert(root, 22);
		System.out.println("PreOrder");
		bst.printPreorder(root);
		System.out.println("InOrder");
		bst.printInorder(root);
		System.out.println("PostOrder");
		bst.printPostorder(root);
		System.out.println("Enter Element to be searched");
		Scanner sc = new Scanner(System.in);
		// int searchData=sc.nextInt();
		System.out.println("Search Element Status:");
		// bst.search(root,searchData);
		bst.search(root, 22);
		System.out.println("Iterative Min in BST");
		int min = bst.findMinIterative(root);
		System.out.println("Iterative Min: " + min);

		System.out.println("Recursive Min in BST");
		int minR = bst.findMinRecursive(root);
		System.out.println("Recursive Min: " + minR);

		System.out.println("Iterative Max in BST");
		int max = bst.findMaxIterative(root);
		System.out.println("Iterative Max: " + max);

		System.out.println("Recursive Max in BST");
		int maxR = bst.findMaxRecursive(root);
		System.out.println("Recursive Max: " + maxR);

		System.out.println("Height of  BST");

		System.out.println("BST Height: " + bst.findHeightofBST(root));

		System.exit(0);
	}

}
