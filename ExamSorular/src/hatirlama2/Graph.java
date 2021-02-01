package hatirlama2;

import java.util.LinkedList;
import java.util.Queue;

class Node{
	 int data;
	 LinkedList<Integer> adj;
	 
	 public Node(int data) {
		 this.data = data;
		 adj = new LinkedList<Integer>();
	 }
 }

public class Graph {

	Node[] allNodes;
	
	public Graph(int capacity) {
		allNodes = new Node[capacity];
		for(int i=0 ; i< capacity ; i++)
			allNodes[i] = new Node(i);
	}
	public void addEdge(int node1 ,int node2) {
		allNodes[node1].adj.add(node2);
		allNodes[node2].adj.add(node1);
		
	}
	public void BiDiretionalBFS(int node1 ,int node2) {
	
		//adjNode lari node1 ve node2 nin Queuye atalim
		Queue<Integer> visitedNodes1 = new LinkedList<Integer>();
		Queue<Integer> visitedNodes2 = new LinkedList<Integer>();
		Queue<Integer> nodesQueue1 = new LinkedList<Integer>();
		Queue<Integer> nodesQueue2 = new LinkedList<Integer>();
		
		
		nodesQueue1.add(node1);
		nodesQueue2.add(node2);			
		
		while( !(nodesQueue1.isEmpty()) || !(nodesQueue2.isEmpty())) {
			
			BFSUtil(nodesQueue1,  visitedNodes1 );
			BFSUtil(nodesQueue2,  visitedNodes2 );
			if( compareQueues(visitedNodes1, visitedNodes2) ) return;
			
		}
	}
	
	public void BFSUtil(Queue<Integer> nodesQueue1 , Queue<Integer> visitedNodes1 ) {
		
		int currNode1 , adjNodeCurr1   ;
		//Queue lari disardan veriyoruz 
		
		//while(!nodesQueue1.isEmpty()) {
			
			currNode1 = nodesQueue1.poll(); 
			
			if(!visitedNodes1.contains(currNode1)) {
				System.out.println(currNode1);
				visitedNodes1.add(currNode1);
				
				for(int i =0; i< allNodes[currNode1].adj.size() ; i++) {
					adjNodeCurr1 = allNodes[currNode1].adj.get(i);
					
					if(!visitedNodes1.contains(adjNodeCurr1)) {
						nodesQueue1.add(adjNodeCurr1);
					}
				}
				//if (compareQueues(nodesQueue1, nodesQueue2)) break;
			}
			
		//}		
	}
	
	public boolean compareQueues(Queue<Integer> nodesQueue1 ,Queue<Integer> nodesQueue2 ) {
		
		for( Integer node1: nodesQueue1) {
		
			if(nodesQueue2.contains(node1)) {
				System.out.println("There is an intersection at :" + node1);
				return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Graph curGraph = new Graph(15);
		
		Node node0 = new Node(0);
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		Node node9 = new Node(9);
		Node node10 = new Node(10);
		Node node11 = new Node(11);
		Node node12 = new Node(12);
		Node node13 = new Node(13);
		
		curGraph.addEdge(0, 4);
		curGraph.addEdge(1, 4);
		curGraph.addEdge(4, 6);
		curGraph.addEdge(2, 5);
		curGraph.addEdge(3, 5);
		curGraph.addEdge(5, 6);
		curGraph.addEdge(6, 7);
		curGraph.addEdge(7, 8);
		
		curGraph.addEdge(8, 9);
		curGraph.addEdge(8, 10);
		curGraph.addEdge(9, 11);
		curGraph.addEdge(9, 12);
		curGraph.addEdge(10, 13);
		curGraph.addEdge(10, 14);
		
		curGraph.BiDiretionalBFS(0,14);
	}
}
