package collections2;

public class DoubleLinked {

	DoubleEndedLinkedList firstLink;
	DoubleEndedLinkedList lastLink;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DoubleLinked deneme = new DoubleLinked();
		deneme.insertInFirstPosition("Kadikoy", "2");
		deneme.insertInFirstPosition("Kadikoy", "6");
		deneme.insertInFirstPosition("Kadikoy", "3");
		
		deneme.print();
		
	}
	public void print() {
		DoubleEndedLinkedList currentNode = firstLink;

		while(currentNode!= null) {
			System.out.println(currentNode.homeAddress + ":" + currentNode.homeNumber);
			currentNode = currentNode.next;
		}
	}
	public  void insertInFirstPosition(String homeAddress ,String homeNumber ) {
		DoubleEndedLinkedList tempNode = new DoubleEndedLinkedList(homeAddress, homeNumber);
		
		if( firstLink == null ) {
			firstLink = tempNode;
			return;
		}
				
		firstLink.prev = tempNode;
		tempNode.next = firstLink;
		firstLink = tempNode;
		
	}

	
	static class DoubleEndedLinkedList{
		public String homeAddress;
		public String homeNumber;
		
		public DoubleEndedLinkedList(String homeAddress ,String homeNumber ) {
			this.homeAddress = homeAddress;
			this.homeNumber = homeNumber;
		}
		
		public DoubleEndedLinkedList next = null;
		public DoubleEndedLinkedList prev = null;
		
		
	}
}
