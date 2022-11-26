class Node {
	int data;
	Node next;
	
	Node(int data) {
		this.data = data;
		next = null;
	}
}

public class LinkedList {
	static int length(Node head) {
		Node temp = head;
		int count = 0;
		while(temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}
	
	static Node insertBegin(Node head, int data) {
		Node temp = new Node(data);
		temp.next = head;
		head = temp;
		return head;
	}
	
	static Node insertEnd(Node head, int data) {
		Node node = new Node(data);
		node.next = null;
		Node temp = head;
		if(head == null) {
			head = node;
			return head;
		}
		while(temp.next != null) temp = temp.next;
		
		temp.next = node;
		return head;
	}
	
	static Node insertAtGiven(Node head, int data, int pos) {
		if(pos < 0 || pos > length(head)) return head;
		if(head == null || pos == 0) return insertBegin(head, data);
		if(pos == length(head)) return insertEnd(head, data);
		
		Node node = new Node(data);
		Node temp = head;
		for(int i=0; i<pos-1; i++) {
			temp = temp.next;
		}
		node.next = temp.next;
		temp.next = node;
		return head;
	}
	
	static Node deleteBegin(Node head) {
		if(head == null) return null;
		return head.next;
	}
	
	static Node deleteEnd(Node head) {
		if(head == null || head.next == null) return null;
		Node temp = head;
		while(temp.next.next != null) temp = temp.next;
		temp.next = null;
		return head;
	}
	
	static void traverse(Node head) {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	static int search(Node head, int data) {
		int pos = 0;
		Node temp = head;
		while(temp != null) {
			if(temp.data == data) return pos;
			pos++;
			temp = temp.next;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		Node head = list.insertEnd(null, 10);
		head = list.insertEnd(head, 20);
		head = list.insertBegin(head, 30);
		list.traverse(head);
		head = list.insertAtGiven(null, 10, 0);
		head = list.insertAtGiven(head, 20, 1);
		head = list.insertAtGiven(head, 30, 2);
		head = list.insertAtGiven(head, 100, 0);
		head = list.insertAtGiven(head, 200, 2);
		list.traverse(head);
		head = list.deleteBegin(head);
		head = list.deleteEnd(head);
		list.traverse(head);
		System.out.println(list.search(head, 200));
		System.out.println(list.search(head, 30));
		
	}
}


