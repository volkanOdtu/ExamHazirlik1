package collections2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Node{
	int id;
	ArrayList<Integer> friends ;
	Node previousNode = null;
	
	public Node(int id ,Node prevNode) {		
		this.id = id;
		if(prevNode!= null)
			this.previousNode = prevNode;
		this.friends = new ArrayList<Integer>();
	}
	
	//mevcut node dan(kendi de dahil) baslayarak tum prevNode larini ekliyoruz
	public LinkedList<Node> collapse(boolean startWithRoot){
		LinkedList<Node> path = new LinkedList<Node>();
		Node tempNode = this;
		while(tempNode!= null) {
			if(startWithRoot)
				path.addLast(tempNode);
			else
				path.addFirst(tempNode);
			tempNode = tempNode.previousNode;
		}
		return path;
	}
}

class BFSData{
	public Queue<Node> toVisitNodes = new LinkedList<Node>();
	public HashMap<Integer, Node> visitedNodes = new HashMap<Integer, Node>();
	
	public BFSData(Node root) {
		Node sourceNode = new Node(root.id, null);
		toVisitNodes.add(sourceNode);
		visitedNodes.put(root.id, sourceNode);
	}
	public boolean isFinished() {
		return toVisitNodes.isEmpty();
	}
}

public class SocialNetwork {
	
	Node searchLevel(HashMap<Integer, Node> people ,BFSData nodeDataPrimary ,BFSData nodeDataSecondary) {
		int count = nodeDataPrimary.toVisitNodes.size();
		for(int i =0 ; i< count ;i++ ) {
			Node nodePrimary = nodeDataPrimary.toVisitNodes.poll();
			//lets check if already visited
			if(nodeDataSecondary.visitedNodes.containsKey(nodePrimary.id))
				return nodePrimary;
			
			//Add primaryNodeFriends to queue
			for(int friendId:nodePrimary.friends) {
				if(!nodeDataPrimary.visitedNodes.containsKey(friendId) ) {	
					Node friendNode = people.get(friendId);
					nodeDataPrimary.visitedNodes.put(friendId, friendNode);
				}
			}
		}
		
		return null;
	}
	
	LinkedList<Node> mergePaths(BFSData nodeDataPrimary ,BFSData nodeDataSecondary ,int connectionId){
		Node nodeEndPrimay = nodeDataPrimary.visitedNodes.get(connectionId); //source
		Node nodeEndSecondary = nodeDataSecondary.visitedNodes.get(connectionId); //destination
		
		LinkedList<Node> pathOne = nodeEndPrimay.collapse(false);
		LinkedList<Node> pathTwo = nodeEndSecondary.collapse(true); // reverse
	
		pathTwo.removeFirst();//remove connection
		pathOne.addAll(pathTwo);
		
		return pathOne;
	}
	
	LinkedList<Node> findPathBetweenBiBFS(HashMap<Integer, Node> peopleHashMap ,int sourceNodeId ,int destinationNodeId){
		BFSData sourceNodeData = new BFSData(peopleHashMap.get(sourceNodeId));
		BFSData destinationNodeData = new BFSData(peopleHashMap.get(destinationNodeId));
		
		while(!sourceNodeData.isFinished() && !destinationNodeData.isFinished()) {
			//Search from source
			Node  collisionNode = searchLevel(peopleHashMap, sourceNodeData, destinationNodeData);
			if(collisionNode!= null)
				return mergePaths(sourceNodeData, destinationNodeData, collisionNode.id);

			//Search from destination
			collisionNode = searchLevel(peopleHashMap, destinationNodeData ,sourceNodeData);
			if(collisionNode!= null)
				return mergePaths(sourceNodeData, destinationNodeData, collisionNode.id);
			
		}
		return null;
	}
	
}
