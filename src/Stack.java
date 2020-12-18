public class Stack<E> {
	
	@SuppressWarnings("hiding")
	private class StackItem<E> {
		private final E e;
		public E get() {
			return e;
		}
		public StackItem(E e) {
			this.e = e;
		}
	}
	
	private static int next;
	private static final int maxSize = 100;
	
	private StackItem<E>[] stack;
	
	@SuppressWarnings("unchecked")
	public Stack() {
		stack = new StackItem[maxSize];
		next = 0;
		i = 0;
	}
	
	
	int i;
	
	public void add(E e) {
		try {
			stack[next++] = new StackItem<E>(e);
		}catch(ArrayIndexOutOfBoundsException ex) {
			throw new StackOverflowError("Index " + (next + 1) + " out of bounds for size " + maxSize);
		}
	}
	
	public E godown() {
		return stack[--next].get();
	}
	
	public E getCurrent() {
		return stack[next].get();
	}
	
	public int getPosition() {
		return next;
	}
	
	public E pack() {
		E result = stack[0].get();
		stack = null;
		return result;
	}
}
