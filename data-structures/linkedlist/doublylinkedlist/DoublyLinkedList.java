package doublylinkedlist;

class Node {
	int data;
	Node next;
	Node prev;
	
	Node(int data) {
		this.data = data;
		next = null;
		prev = null;
	}
}

public class DoublyLinkedList {
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
		if(head != null) {
			head.prev = temp;
		}
		return temp;
	}
	
	static Node insertEnd(Node head, int data) {
		Node node = new Node(data);
		if(head == null) {
			head = node;
			return head;
		}
		
		Node temp = head;
		while(temp.next != null) temp = temp.next;
		
		node.prev = temp;
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
		node.prev = temp;
		temp.next = node;
		return head;
	}
	
	static Node insertInMid(Node head, int data){
        Node node = new Node(data);
        if(head == null) {
            head = node;
            return head;
        }
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        node.next = slow.next;
        node.prev = slow;
        slow.next.prev = slow;
        slow.next = node;
        return head;
    }
	
	static Node deleteBegin(Node head) {
		if(head == null || head.next == null) return null;
		head = head.next;
		head.prev = null;
		return head;
	}
	
	static Node deleteEnd(Node head) {
		if(head == null || head.next == null) return null;
		Node temp = head;
		while(temp.next.next != null) temp = temp.next;
		temp.next.prev = null;
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
	
	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		Node head = list.insertEnd(null, 40);
		head = list.insertBegin(head, 10);
		head = list.insertBegin(head, 20);
		head = list.insertEnd(head, 30);
		head = list.insertAtGiven(head, 50, 1);
		list.traverse(head);
		head = list.deleteBegin(head);
		list.traverse(head);
		head = list.deleteEnd(head);
		list.traverse(head);
		head = list.insertInMid(head, 100);
		list.traverse(head);
	}
}
