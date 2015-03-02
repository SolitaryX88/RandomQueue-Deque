import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {
	private int size;
	private Item[] arr;

	@SuppressWarnings("unchecked")
	public RandomizedQueue() { // construct an empty randomized queue}
		size = 0;
		arr = (Item[]) new Object[2];
	}

	public boolean isEmpty() { // is the queue empty?
		return size < 1;
	}

	public int size() { // return the number of items on the queue
		return size;
	}

	public void enqueue(Item item) { // add the item
		if (item == null)
			throw new java.lang.NullPointerException();

		if (size == arr.length)
			resize(2 * arr.length); // double size of array if necessary
		arr[size++] = item; // add item
	}

	public Item dequeue() { // delete and return a random item
		if (isEmpty())
			throw new java.util.NoSuchElementException();

		int r = StdRandom.uniform(0, size);
		Item item = arr[r];
		arr[r] = arr[size - 1];

		if (size > 0 && size == arr.length / 4)
			resize(arr.length / 2);

		size--;

		return item;
	}

	// resize the underlying array holding the elements
	@SuppressWarnings("unchecked")
	private void resize(int capacity) {
		assert capacity >= size;
		Item[] temp = (Item[]) new Object[capacity];
		for (int i = 0; i < size; i++) {
			temp[i] = arr[i];
		}
		arr = temp;
	}

	public Item sample() { // return (but do not delete) a random item
		if (isEmpty())
			throw new java.util.NoSuchElementException();
		return arr[StdRandom.uniform(0, size)];
	}

	public Iterator<Item> iterator() { // return an independent iterator over
										// items in random order
		return new RndQueue();
	}

	private class RndQueue implements Iterator<Item> {
		// private int iterSize;
		// private Item[] iteArr;
		//
		private RndQueue() {
			// this.iterSize =size;
			// iteArr = arr;
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return !isEmpty();

		}

		@Override
		public Item next() {
			if (isEmpty())
				throw new java.util.NoSuchElementException();
			// TODO Auto-generated method stub

			return dequeue();
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			throw new java.lang.UnsupportedOperationException();

		}

	}
}