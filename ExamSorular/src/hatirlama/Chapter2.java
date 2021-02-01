package hatirlama;

import java.util.LinkedList;
import java.util.Queue;

public class Chapter2 {

	static class Node{
		Node left ,right;
		int data ;
		public Node(int data) {
			this.data = data;
		}
	}
	
	public  Node findAandCreatePlace(Node root ,int data) {
		if(root == null) {
			Node node = new Node(data);
			return node;
		}
		else {
			if( data > root.data  )
				root.right = findAandCreatePlace(root.right, data);
			else
				root.left = findAandCreatePlace(root.left, data);
			
			return root;
		}
	}
	static Node rootNode;
	public static void insertNotRecursive(int data) {
		if(rootNode == null) {
			rootNode = new Node(data);
		}else {
			Node currentNode = rootNode;
			Node tempNodeToBound = rootNode;
			boolean willBoundToLeft = false;
			
			while(currentNode!= null) {
				if(data > currentNode.data) {
					currentNode = currentNode.right;
					willBoundToLeft = false;
				}
				else {
					currentNode = currentNode.left;
					willBoundToLeft = true;
				}
			}
			if(willBoundToLeft)
				currentNode.left = new Node(data);
			else
				currentNode.right = new Node(data);

		}
	}
	
	public static void printByLevel() {
		Queue<Node> myNodesQueue = new LinkedList<Node>();
		
		myNodesQueue.add(rootNode);
		Node currNode;
		
		while(!myNodesQueue.isEmpty()) {
			 currNode= myNodesQueue.poll();
			 System.out.println(currNode.data);
			 if(currNode.left != null) {
				 myNodesQueue.add(currNode.left);
			 }
			 if(currNode.right!= null) {
				 myNodesQueue.add(currNode);
			 }	 
		}
	}
	
	public static void printInOrder(Node node) {
		if(node == null)
			return;
		
		printInOrder(node.left);
		System.out.println(node.data); //root
		printInOrder(node.right);
	}
	public static void printPostOrder(Node node) {
		if(node == null)
			return;
		printPostOrder(node.left);
		printPostOrder(node.right);
		System.out.println(node.data);
	}
	public int height(Node root) {
		int result =0 , resultLeft =0 ,resultRight = 0;
		
		if(root == null)
			return 0;
		
		
		if(root.left != null )
			resultLeft = 1 + height(root.left);
		
		if(root.right != null)
			resultRight = 1 + height(root.right);
			
		result = resultLeft;
		
		if(resultRight > resultLeft ) result = resultRight;

			
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chapter2 chp = new Chapter2();
		Node root = null;
		
		root = chp.findAandCreatePlace(root, 5);
		root = chp.findAandCreatePlace(root, 3);
		root = chp.findAandCreatePlace(root, 8);
		root = chp.findAandCreatePlace(root, 1);
		root = chp.findAandCreatePlace(root, 2);
		root = chp.findAandCreatePlace(root, 7);
		root = chp.findAandCreatePlace(root, 9);
		root = chp.findAandCreatePlace(root, 10);
		
		//int height =chp.height(root);
				
		//System.out.println(height);
		printInOrder(root);
	}

}
