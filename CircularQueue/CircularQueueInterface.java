package CircularQueue;

public interface CircularQueueInterface<E> {
	public int size();
	public boolean isEmpty();
	public void enqueue(E item);
	public E front() throws Exception;
	public E dequeue() throws Exception;
	public void rotateclockwise();
	public void rotatecounterclockwise();
}
