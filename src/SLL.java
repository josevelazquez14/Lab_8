

public class SLL<E> {
	private static class SNode<E> {
		private E element; 
		private SNode<E> next;
		private SNode<E> first;
		private SNode<E> last;
		public SNode(E element, SNode<E> next) {
			
			this.element = element;
			this.next = next;
			this.first = null;
			this.last = null;
			
		}
		public SNode(E element) { this(element, null); } 
		public SNode() { this(null, null); }
		public E getElement() { return element; }
		public void setElement(E element) { this.element = element; }
		public SNode<E> getNext() { return next; }
		public void setNext(SNode<E> next) { this.next = next; }
		public SNode<E> first() {
			return first;
		}
		public SNode<E> last(){
			return last;
		}
	}

	private SNode<E> first; 
	private int size = 0; 	
	public void addFirst(E e) { 
		first = new SNode<>(e, first); 
		size++; 
	}

	// returns string formed by elements in this list, separated by spaces
	public String toString() { 
		String s = ""; 
		SNode<E> current = first; 
		while (current != null) { 
			s += " " + current.getElement(); 
			current = current.getNext(); 
		}
		return s; 
	}	


	public void reverse() { 
		if (size > 1)  
			first = recReverse(first).first(); 
	} 


	private Pair<SNode<E>> recReverse(SNode<E> current){
		Pair<SNode<E>> p = recReversePair(new Pair<SNode<E>>(null, current));
		return new Pair<SNode<E>>(p.last(), current);
	}

	private Pair<SNode<E>> recReversePair(Pair<SNode<E>> pair) { 
		if  (pair.last().getNext() == null) {
			pair.last().setNext(pair.first());
			return pair;
		}
		SNode<E> a = pair.last().getNext();
		pair.last().setNext(pair.first());
		
		return recReversePair(new Pair<SNode<E>>(pair.last(), a));
	}


}
