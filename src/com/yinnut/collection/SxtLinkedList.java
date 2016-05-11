package com.yinnut.collection;


public class SxtLinkedList {
	private Node head;
	private Node tail;
	private int size;
	
	
	public SxtLinkedList() {
		head = new Node(null,null,null);
		tail = new Node(head,null,null);
		head.setNextNode(tail);
		size = 0;
	}

	public int size() {		
		return size;
	}
	
	public boolean isEmpty() {		
		return size==0;
	}
	
	public boolean contains(Object o) {
		
		return false;
	}

	public boolean add(Object e) {
		Node beforeTailNode = tail.getPrevNode();
		Node newNode = new Node(beforeTailNode,tail,e);
		beforeTailNode.setNextNode(newNode);
		tail.setPrevNode(newNode);
		
		size++;
		return true;
	}
	
	public boolean remove(Object o) {
		Node cursor = head.getNextNode();
		boolean found = false;
		
		while (! cursor.equals(tail)) {
			Object value = cursor.getValue();
			if (o.equals(value)) {
				Node prevNode = cursor.getPrevNode();
				Node nextNode = cursor.getNextNode();
				prevNode.setNextNode(cursor.getNextNode());
				nextNode.setPrevNode(prevNode);
				
				found = true;
				size--;
				return found;
			}
			cursor = cursor.getNextNode();
		}
		
		return false;
	}
	
	public Object get(int index) {
		Node cursor = head.getNextNode();
		if (tail.equals(cursor)) {
			return null;
		}
		
		int count = 0;
		
		while (count < index && ! tail.equals(cursor)) {
			cursor = cursor.getNextNode();
			count++;
		}
		
		return cursor.getValue();
	}
	
	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public Node getTail() {
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}

	public static void main(String[] args) {
		SxtLinkedList sxtLinkedList = new SxtLinkedList();
		sxtLinkedList.add("aaa");
		sxtLinkedList.add("bbb");
		sxtLinkedList.add("ccc");
		
		System.out.println(sxtLinkedList.size());
		
//		Node aaaNode = sxtLinkedList.getHead();
//		while (! aaaNode.equals(sxtLinkedList.getTail())) {
//			System.out.println(aaaNode.getValue());
//			aaaNode = (Node)aaaNode.getNextNode();
//		}
		
		System.out.println(sxtLinkedList.get(1));
		System.out.println(sxtLinkedList.get(5));
		
		sxtLinkedList.remove("bbb");
		System.out.println(sxtLinkedList.get(1));
	}
}

