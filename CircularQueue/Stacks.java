package CircularQueue;

public class Stacks<E> implements Stack<E> 
{
    private Node head;
    private int length;
    
    private class Node
    {
        public E data;
        public Node prev;
    }
    
    public Stacks()
    {
        head = null;
        length = 0;
    }
    
    public int size()
    {
        return length;
    }
    
    public boolean isEmpty()
    {
        return length == 0;
    }
    
    public void push(E data)
    {
        Node newNode = new Node();
        newNode.data = data;
        if(length == 0)
            newNode.prev = null;
         else
            newNode.prev = head;
        head = newNode;
        length++;
    }
    
    public E top() throws Exception
    {
        if(length == 0)
            throw new Exception("Non-empty stack expected");
        return head.data;
    }
    
    public E pop() throws Exception
    {
        if(length == 0)
            throw new Exception("Non-empty stack expected");
        E data = head.data;
        if(length == 1)
            head = null;
        else
            head = head.prev;
        length--;
        return data;
    }
    
    public String toString()
    {
        String string = "]";
        if(length > 0)
        {
            Node node = head;
            string = node.data + string;
            while(node.prev != null)
            {
                node = node.prev;
                string = node.data + ", " + string;
            }
        }
        string = "[" + string;
        return string;
    }    
}