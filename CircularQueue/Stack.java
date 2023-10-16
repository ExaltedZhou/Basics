package CircularQueue;

public interface Stack<E> 
{
    public int size();
    public boolean isEmpty();
    public void push(E data);
    public E top() throws Exception;
    public E pop() throws Exception;    
}
