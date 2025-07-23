public class CircularDoublyLinkedList<E> {
	// nested Node class
	private static class Node<E>{
		private E element;
		private Node<E> prev;
		private Node<E> next;
		public Node(E e, Node<E> p, Node<E> n) {
			element=e;
			prev = p;
			next = n;
		}
		public E getElement() {return element;}
		public Node<E> getPrev() {return prev;}
		public void setPrev(Node<E> prev) {this.prev = prev;}
		public Node<E> getNext() {return next;}
		public void setNext(Node<E> next) {this.next = next;}
	}

	private Node<E> header;
	private int size = 0;

	public CircularDoublyLinkedList() {
		header = new Node<E>(null,null,null);
	}

	public int size() {return size;}
	public boolean isEmpty() {return size==0;}
	
	public E first() {
		if(isEmpty()) return null;
		return header.getNext().getElement();
	}
	
	public E last() {
		if(isEmpty()) return null;
		return header.getNext().getPrev().getElement();
	}
	
	public void addFirst(E e) {
		if(isEmpty()) {
			Node<E> first = new Node<>(e, null, null);
			first.setNext(first);
			first.setPrev(first);
			header.setNext(first);
			size++;
		}
		else {
			addBetween(e, header.getNext().getPrev(), header.getNext());
			header.setNext(header.getNext().getPrev());
		}
	}
	
	public void addLast(E e) {
		if(isEmpty()) addFirst(e);
		else {
			addBetween(e, header.getNext().getPrev(),header.getNext());
		}
	}
	
	public void addBetween(E e, Node<E> predecessor, Node<E> successor) {
		Node<E> newest = new Node<>(e, predecessor, successor);
		predecessor.setNext(newest);
		successor.setPrev(newest);
		size++;
	}
	
	public E removeFirst() {
		if(isEmpty()) return null;
		if(size==1) {
			E firstElement = first();
			header.setNext(null);
			size--;
			return firstElement;
		}
		return remove(header.getNext());
	}
	
	public E removeLast(){
		if(isEmpty()) return null;
		if(size==1) return removeFirst();
		return remove(header.getNext().getPrev());
	}

	public E remove(Node<E> node) {
		Node<E> predecessor = node.getPrev();
		Node<E> successor = node.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		if (node == header.getNext()) {
			header.setNext(successor);
		}
		size--;
		return node.getElement();
	}

	public void rotate() {
		if(!isEmpty()){
			header.setNext(header.getNext().getNext()); // Shifting the first element reference

		}
	}

	public void reverse() {
		if(size==0) return;
		if(size==1) return;

		Node<E> currentNode = header.getNext();
		Node<E> predec = null;
		do{
			predec = currentNode.getPrev();
			currentNode.setPrev(currentNode.getNext());
			currentNode.setNext(predec);
			currentNode=currentNode.getPrev();
		}while(currentNode!=header.getNext());
	}
	
	public String toString() {
		if (isEmpty()) return "[]";

		StringBuilder sb = new StringBuilder();
		Node<E> currentNode = header.getNext();  // Start from the first node
		for (int i = 0; i < size; i++) {
			sb.append(currentNode.getElement());
			if (i < size - 1) sb.append(", ");
			currentNode = currentNode.getNext();
		}
		return sb.toString();
	}
}