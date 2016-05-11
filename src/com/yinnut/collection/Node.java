package com.yinnut.collection;

public class Node {
	private Node prevNode;
	private Node nextNode;
	private Object value;
	
	public Node() {
		
	}

	public Node(Node prevNode, Node nextNode, Object value) {
		this.prevNode = prevNode;
		this.nextNode = nextNode;
		this.value = value;
	}

	public Node getPrevNode() {
		return prevNode;
	}

	public void setPrevNode(Node prevNode) {
		this.prevNode = prevNode;
	}

	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	

	
	
}
