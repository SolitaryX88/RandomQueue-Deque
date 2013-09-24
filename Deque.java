import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {

	private Node first;
	private Node last;
	private int size;

	public Deque() { // construct an empty deque
		first = null;
		last = null;
		size = 0;
	}

	private class Node {
		private Item item;
		private Node next;
		private Node prev;
	}

	public boolean isEmpty() { // is the deque empty?
		return size < 1;
	}

	public int size() { // return the number of items on the deque
		return size;
	}

	public void addFirst(Item item) { // insert the item at the front

		if (item == null)
			throw new java.lang.NullPointerException();

		if (isEmpty()) {
			first = new Node();
			first.item = item;
			first.next = null;
			first.prev = null;
			last = first;
			size++;
			return;
		}

		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		first.prev = null;
		oldfirst.prev = first;
		size++;
	}

	public void addLast(Item item) { // insert the item at the end

		if (item == null)
			throw new java.lang.NullPointerException();

		if (isEmpty()) {
			last = new Node();
			last.item = item;
			last.next = null;
			last.prev = null;
			first = last;
			size++;
			return;
		}

		Node newLast = new Node();
		newLast.item = item;
		newLast.prev = this.last;
		this.last.next = newLast;
		last = newLast;

		size++;

	}

	public Item removeFirst() { // delete and return the item at the front
		if (isEmpty())
			throw new java.util.NoSuchElementException();

		if (size == 1) {

			Item item = first.item;
			first.item = null;
			first.next = first.prev = null;
			first = null;
			last = null;
			size--;
			return item;
		}

		Node newFirst = first.next;
		newFirst.prev = null;

		Item item = first.item;

		first.item = null;
		first = null;

		first = newFirst;

		size--;
		return item;
	}

	public Item removeLast() { // delete and return the item at the end
		if (isEmpty())
			throw new java.util.NoSuchElementException();

		Item item = last.item;
		last.item = null;
		
		if (!(last.prev == null)) {
			Node newLast = last.prev;
			newLast.next = null;
			last = newLast;
		}

		size--;

		return item;
	}

	public Iterator<Item> iterator() { // return an iterator over items in order
										// from front to end
		return new DequeIter();
	}

	private class DequeIter implements Iterator<Item> {

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return size>1;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			if (isEmpty())
				throw new java.util.NoSuchElementException();

			return removeFirst();
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			throw new java.lang.UnsupportedOperationException();

		}

	}

}
