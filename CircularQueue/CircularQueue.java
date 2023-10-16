package CircularQueue;
import java.util.*; 

public class CircularQueue<E> implements CircularQueueInterface<E> {
	private int length;
	private Node head;
	private Node rear;
	private class Node{
		public E data; 
		public Node next;
		public E dequeue() {
	        E data = head.data;
	        if(length == 1)
	        {
	            head = null;
	            rear = null;
	        }
	        else
	            head = head.next;
	        length--;
	        return data;
		}
		public E enqueue(E data) {
			Node newNode = new Node();
			newNode.data = data;
			newNode.next = null;
			rear.next = newNode;
			return data;
		}

	}
	public CircularQueue() {
		rear = null;
		head = rear;
		length = 0;
	}
	public int size() {
		return length;
	}
	public boolean isEmpty() {
		return length == 0;
	}
	public void enqueue(E data) {	
		Node newNode = new Node();
		newNode.data = data;
		newNode.next = null;
		if(length == 0)
			head = newNode;
		else 
			rear.next = newNode;
		length++;
		rear = newNode;
	}
	public E front() throws Exception {
		if(length == 0)
			throw new Exception("Non-empty queue expected");
		return head.data;
	}
	public E dequeue() throws Exception {
		if(length == 0)
            throw new Exception("Non-empty queue expected");
        E data = head.data;
        if(length == 1)
        {
            head = null;
            rear = null;
        }
        else
            head = head.next;
        length--;
        return data;
	}
	public void rotatecounterclockwise() {
/*		Node node = new Node();
		int x = node.length();
		for(int i = 0; i < x; i++) {
			node.dequeue();
			} 	*/	
	}
	public void rotateclockwise() {	
		Node node = new Node();
		E next1 = node.enqueue(head.data);
		E next = node.dequeue();
	}
	 public String toString()
	    {
	       String string = "]";
	       if(length != 0)
	       {
	           Node node = head;
	           string = node.data + string;
	           while(node.next != null)
	           {
	               node = node.next;
	               string = node.data + ", " + string;
	           }           
	       }
	       string = "[" + string;
	       return string;
	    }    
	
}
