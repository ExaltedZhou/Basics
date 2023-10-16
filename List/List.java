package List;

public class List<E> {
    private Node first;
    private Node last;
    private int length;

    private class Node
    {
        public E data;
        public Node next;
        public Node prev;
    }
    public List()
    {
        first = null;
        last = null;
        length = 0;
    }
    public int size()
    {
        return length;
    }
    public void addFirst(E data)
    {
        Node newNode = new Node();
        newNode.data = data;
        if(length == 0)
        {
            first = newNode;
            last = newNode;
        }
        else
        {
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        }
        length++;
    }
    public void addLast(E data)
    {
        Node newNode = new Node();
        newNode.data = data;
        if(length == 0)
        {
            first = newNode;
            last = newNode;
        }
        else
        {
            newNode.prev = last;
            last.next = newNode;
            last = newNode;
        }
        length++;
    }
    public E removeFirst() throws Exception
    {
        if(length == 0)
            throw new Exception("Non-empty list expected");
        E data = first.data;
        if(length == 1)
        {
            first = null;
            last = null;
        }
        else
        {
            first = first.next;
            first.prev = null;
        }
        length--;
        return data;        
    }
    public E removeLast() throws Exception
    {
    	if(length == 0)
            throw new Exception("Non-empty queue expected");
    	E data = last.data;
        if(length == 1) {
        	first = null;
            last = null;
    	}	
        else {
            last = last.prev;
        	last.next = null;
        }
       	length--;
		return data;
    }
    public E getFirst() throws Exception
    {
        if (first == null)
            throw new Exception("Non-empty list expected");
        return first.data;
    }
    public String toString()
    {
    	 String string = "[";
         if(length != 0)
         {
             Node node = first;
             string = string + node.data;
             while(node.next!= null)
             {
                 node = node.next;
                 string = string + "," + node.data;
             }           
         }
         string = string  + "]";
         return string;
    }
    public ListIterator listIterator()
    {
        return new ListIterator();
    }
    private class ListIterator implements ListIteratorInterface<E>
    {
        private Node position;  // the node on the left of the iterator
        private Node previousPosition;  // the previous iterator position
        private boolean isAfterNext;
        private boolean isAfterPrevious;    
        /**
         * Constructs an iterator at the beginning of the linked list.
         */
        public ListIterator()                
        {
            position = null;
            previousPosition = null;
            isAfterNext = false;
            isAfterPrevious = false;
        }
        /**
         * Returns true if there is a node on the right of the iterator;
         * otherwise, returns false.
         */    
        public boolean hasNext()
        {
            if (position == null)
                return first != null;
            else
                return position.next != null;
        }    
        public boolean hasPrevious() //
        {
        	return position.prev != null;
        }
        public E next() throws Exception
        {
            if (!hasNext())
                throw new Exception("next called when the iterator is "
                        + "at the end of the list");
            previousPosition = position;  
            if (position == null)
                position = first;
            else
                position = position.next;
            
            isAfterNext = true;
            isAfterPrevious = false;
            return position.data;
        }
        public E previous() throws Exception
        {
        	if (hasPrevious()) {
                E result = position.data;
                position = position.prev;
                return result;
            }
        	throw new Exception();
        }
        public void add(E data)
        {
            if (position == null)
            {
                addFirst(data);
                position = first;
            }
            else if(position.next == null)
            {
                addLast(data);
                position = last;
            }
            else
            {
                Node newNode = new Node();
                newNode.data = data;
                newNode.next = position.next;
                position.next.prev = newNode;
                newNode.prev = position;
                position.next = newNode;
                position = newNode;
                length++;
            }
            isAfterNext = false;
            isAfterPrevious = false;
        }
        public void remove() throws Exception
        {
        	if(isAfterNext) {
        		position = previousPosition;
        	}
        	else if (isAfterPrevious)
        		previousPosition = position;
        	else 
        		throw new Exception("next called when the iterator is at the end of the list");
        	
        	
        }
        public void set(E data) throws Exception
        {
            if (position == null)
                throw new Exception("set called when the iterator is"
                        + " at the beginning of the list");
            position.data = data;
        }        
    }
    

    
}
