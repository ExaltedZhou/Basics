package List;

public interface ListIteratorInterface<E> {
	 public boolean hasNext();
	    public boolean hasPrevious();
	    public E next() throws Exception;
	    public E previous() throws Exception;
	    public void add(E data);
	    public void remove() throws Exception;
	    public void set(E data) throws Exception;
	    
}
