package circularlinkedlist;

class Node {
	int data;
	Node next;
	
	Node(int data) {
		this.data = data;
		next = null;
	}
}

public class CircularLinkedList {
	
	static Node insertBegin(Node head, int data) {
		Node node = new Node(data);
		if(head == null) {
			node.next = node;
		} else {
			Node temp = head;
			while(temp.next != head) {
				temp = temp.next;
			}
			temp.next = node;
			node.next = head;
		}
		return node;
	}
	
	static Node insertEnd(Node head, int data) {
		Node node = new Node(data);
		if(head == null) {
			node.next = node;
			return node;
		} else {
			Node temp = head;
			while(temp.next != head) {
				temp = temp.next;
			}
			temp.next = node;
			node.next = head;
			return head;
		}
	}
	
	static Node deleteBegin(Node head) {
		if(head == null || head.next == head) return null;
		Node temp = head;
		while(temp.next != head) temp = temp.next;
		temp.next = head.next;
		return temp.next;
	}
	
	static Node deleteKthNode(Node head, int k) {
		if(head == null) return null;
		if(k == 1) return deleteBegin(head);
		Node temp = head;
		for(int i=0; i<k-2; i++) {
			temp = temp.next;
		}
		temp.next = temp.next.next;
		return head;
	}
	
	static void traversal(Node head) {
		if(head == null) return;
		
		Node temp = head;
		System.out.print(temp.data + " ");
		temp = temp.next;
		while(temp != head) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		CircularLinkedList list = new CircularLinkedList();
		Node head = list.insertBegin(null, 10);
		head = list.insertBegin(head, 20);
		list.traversal(head);
		head = list.insertEnd(head, 30);
		head = list.insertEnd(head, 40);
		list.traversal(head);
		head = list.deleteBegin(head);
		list.traversal(head);
		head = list.deleteKthNode(head, 2);
		list.traversal(head);
	}
}
