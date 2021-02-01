package hatirlama;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import hatirlama.Chapter2.Node;

class NodeG{
	int data;
	ArrayList<NodeG> adjNodes ;
	
	public NodeG(int data) {
		this.data = data;
		adjNodes = new ArrayList<NodeG>();
	}
	public void addEdge(NodeG node ) {
		adjNodes.add(node);
	}
	
}
class Graph{
	NodeG[] nodes;
	ArrayList<NodeG> visitedNodes;
	
	public Graph(int capacity) {
		nodes = new NodeG[capacity];
		visitedNodes = new ArrayList<NodeG>();
	}
	
	public void BFS(NodeG startingNode ) {
		Queue<NodeG> allItemsQueue = new LinkedList<NodeG>();
		
		allItemsQueue.add(startingNode);
		
	    BFSUtil(allItemsQueue, visitedNodes);	 
	}
	//recursive olmadigi icin BFS oldu
	public void BFSUtil(Queue<NodeG> allItemsQueue ,ArrayList<NodeG> visitedNodes) {
		
		while(!allItemsQueue.isEmpty()) {
			NodeG currNode = allItemsQueue.poll();
			
			if(!visitedNodes.contains(currNode)) {
				visitedNodes.add(currNode);
				System.out.println( currNode.data);
			}
				
			
			for( int i=0 ; i< currNode.adjNodes.size() ; i++) {
				NodeG currAdjNode =currNode.adjNodes.get(i);
				if( ! visitedNodes.contains(currAdjNode))
					allItemsQueue.add(currAdjNode);						
			}			 
		}
	}
	
	public void DFS(NodeG startingNode ) {
		ArrayList<NodeG> visitedNodes = new ArrayList<NodeG>();
		DFSUtil(startingNode, visitedNodes);
	}
	public void DFSUtil( NodeG startingNode ,ArrayList<NodeG> visitedNodes) {
		
		if( !visitedNodes.contains(startingNode) ) {
			System.out.println(startingNode.data);
			visitedNodes.add(startingNode);
			
			for( int i= 0; i < startingNode.adjNodes.size() ;i++)
			{
				NodeG currNode = startingNode.adjNodes.get(i);
				
				if(!visitedNodes.contains(currNode)) {
					
					DFSUtil(currNode, visitedNodes);
				}
					
			}
		}
	}
	
	
}
public class Graphs {

	public static void main(String[] args) {
		
		Graph currGraph = new Graph(4);
		NodeG node0 = new NodeG(0);
		NodeG node1 = new NodeG(1);
		NodeG node2 = new NodeG(2);
		NodeG node3 = new NodeG(3);
		
		node0.addEdge(node1);
		node0.addEdge(node2);
		node1.addEdge(node2);
		node2.addEdge(node0);
		node2.addEdge(node3);
		
		//currGraph.BFS(node0);
		currGraph.DFS(node0);
	}

}
