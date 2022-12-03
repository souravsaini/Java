package binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {
	int key;
	Node left;
	Node right;
	
	Node(int key) {
		this.key = key;
		left = right = null;
	}
}

public class BinaryTree {
	static void inorder(Node root) {
		if(root != null) {
			inorder(root.left);
			System.out.print(root.key + " ");
			inorder(root.right);
		}
	}
	
	static void preorder(Node root) {
		if(root != null) {
			System.out.print(root.key + " ");
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	static void postorder(Node root) {
		if(root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.key + " ");
		}
	}
	
	static void levelOrder(Node root) {
		if(root == null) return;
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(q.isEmpty() == false) {
			Node curr = q.poll();
			System.out.print(curr.key + " ");
			if(curr.left != null) q.add(curr.left);
			if(curr.right != null) q.add(curr.right);
		}
	}
	
	static void spiralOrder(Node root) {
		if(root == null) return;
		
		Stack<Node> st1 = new Stack<>();
		Stack<Node> st2 = new Stack<>();
		st1.push(root);
		
		while(!st1.empty() && !st2.empty()) {
			while(!st1.empty()) {
				Node temp = st1.pop();
				System.out.print(temp.key + " ");
				if(temp.left != null) st2.push(temp.left);
				if(temp.right != null) st2.push(temp.right);
			}
			while(!st2.empty()) {
				Node temp = st2.pop();
				System.out.print(temp.key + " ");
				if(temp.right != null) st1.push(temp.right);
				if(temp.left != null) st1.push(temp.left);
			}
		}
	}
	
	static int height(Node root) {
		if(root == null) return 0;
		
		int heightLeft = height(root.left);
		int heightRight = height(root.right);
		return Math.max(heightLeft, heightRight) + 1;
	}
	
	static void printNodesAtLevel(Node root, int k) {
		if(root == null) return;
		if(k == 0) {
			System.out.print(root.key);
			return;
		}
		printNodesAtLevel(root.left, k-1);
		printNodesAtLevel(root.right, k-1);
	}
	
	static int size(Node root) {
		if(root == null) return 0;
		
		return size(root.left) + size(root.right) + 1;
	}
	
	static int maximum(Node root) {
		if(root == null) return Integer.MIN_VALUE;
		
		return Math.max(root.key, Math.max(maximum(root.left), maximum(root.right)));
	}
	
	static boolean isHeightBalanced(Node root) {
		if(root == null) return true;
		int lh = height(root.left);
		int rh = height(root.right);
		return (Math.abs(lh-rh) <= 1) && isHeightBalanced(root.left) && isHeightBalanced(root.right); 
	}
	
	static int maximumWidth(Node root) {
		if(root == null) return 0;
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		int res = 0;
		while(q.isEmpty() == false) {
			int count = q.size();
			res = Math.max(res, count);
			for(int i=0; i<count; i++) {
				Node curr = q.poll();
				if(curr.left != null) q.add(curr.left);
				if(curr.right != null) q.add(curr.right);
			}
		}
		return res;
	}
	
	static int diameter(Node root) {
		if(root == null) return 0;
		
		int d1 = height(root.left) + height(root.right) + 1;
		int d2 = diameter(root.left);
		int d3 = diameter(root.right);
		
		return Math.max(d1, Math.max(d2,  d3));
	}
}
