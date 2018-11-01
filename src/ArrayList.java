import javax.xml.soap.Node;

public class ArrayList<E> {

	private static class Node<E> {
		private E element; 
		private Node<E> next;
		public Node(E element, Node<E> next) {
			super();
			this.element = element;
			this.next = next;
		}
		public Node(E element) { this(element, null); } 
		public Node() { this(null, null); }
		public E getElement() { return element; }
		public void setElement(E element) { this.element = element; }
		public Node<E> getNext() { return next; }
		public void setNext(Node<E> next) { this.next = next; }
		public Node<E> first() {
			// TODO Auto-generated method stub
			return this.first();
		}	
	}

	private E elements[];
	private  Node<E> first = null; 
	private int size = 0; 	
	public void addFirst(E e) { 
		first = new Node<>(e, first); 
		size++; 
	}

	public ArrayList<Pair<E>> lessThan(E e) { 
		ArrayList<Pair<E>> result = new ArrayList<>();     // and empty ArrayList object
		if (size > 0) 
			recLessThan(first, e, result);   // passing only reference to result
		return result; 
	}



	private void recLessThan(Node<E> fr, E e, ArrayList<Pair<E>> result) { 
		if (fr != null) { 
			if (((Comparable<E>) fr.getElement()).compareTo(e) < 0)
				 result.add((Pair<E>) fr.getElement());
			recLessThan(fr.getNext(), e, result);  // passing reference to result
		}
	} 




	public void add(E obj) {
		if (obj == null){
			throw new IllegalArgumentException("Argument object cannot be null.");
		}
		else {
			if (this.size == this.elements.length){
				reAllocate();
			}
			this.elements[this.size++] = obj;
			return;
		}
	}

	private void reAllocate() {
		// create a new array with the twice the size
		E newElements[] = (E[]) new Object[2*this.elements.length];
		// copy all values into the new array
		for (int i=0; i < this.size; ++i){
			newElements[i] = this.elements[i];
		}
		// replace old elmenets with newElements
		this.elements = newElements;
	}

	public ArrayList<Pair<E>> consecutiveIncreasingPairs() { 
		ArrayList<Pair<E>> result = new ArrayList<>();     // and empty ArrayList object
		if (size > 0) 
			recCIP(first, result); 
		return result; 
		
	}

	private void recCIP(Node<E> current, ArrayList<Pair<E>> result) {
		if(current.getNext() != null) {
			if(((Comparable<E>)current.getElement()).compareTo(current.getNext().getElement()) < 0) {
				result.addFirst( new Pair<E>(current.getElement(), current.getNext().getElement()));
				recCIP(current.getNext(), result);
			}
		}
		
	}

}
