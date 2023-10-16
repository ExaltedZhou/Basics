package BinarySearchTree;

public class BinarySearchTree<E extends Comparable> {
	 private Node root; 
	    private int size;
	    private boolean firstNodePrinted;
	    private class Node 
	    {
	        public E data; 
	        public Node left; 
	        public Node right;
	    }
	    public BinarySearchTree() 
	    { 
	        root = null; 
	        size = 0; 
	        firstNodePrinted = false;
	    } 
	    public int size() 
	    { 
	        return size; 
	    }	    
	    public boolean isEmpty() 
	    { 
	        return size == 0; 
	    }    
	    public void insertItem(E data) 
	    { 
	        Node newNode = new Node(); 
	        newNode.data = data; 
	        if (size == 0) 
	        { 
	            root = newNode; 
	            size++; 
	        } 
	        else 
	        { 
	            Node node = root; 
	            while (true) 
	            { 
	                int d = data.compareTo(node.data); 
	                if (d==0) 
	                    return; 
	                else if (d<0) 
	                { 
	                    if (node.left == null) 
	                    {  
	                        node.left = newNode; 
	                        size++; 
	                        return; 
	                    } 
	                    else 
	                        node = node.left; 
	                } 
	                else 
	                { 
	                    if (node.right == null) 
	                    {
	                        node.right = newNode; 
	                        size++; 
	                        return; 
	                    } 
	                    else 
	                        node = node.right; 
	                } 
	            } 
	        } 
	    }    
	    private Node search(E key) 
	    { 
	        Node node = root; 
	        while (node != null) 
	        { 
	            int d = key.compareTo(node.data); 
	            if (d == 0) 
	                return node; 
	            else if (d < 0) 
	                node = node.left; 
	            else 
	                node = node.right; 
	        } 
	        return null; 
	    }
	    public boolean inTree(E item) 
	    { 
	        return search(item) != null; 
	    }
	       
	    private Node findParent(Node inputNode) ///
	    {
	    	if(inputNode == root)
	    		return null;
	    	Node node = root;
	    	int d = inputNode.data.compareTo(node.data);
	    	while(inputNode != node) {
	    		Node temp = node;
	    		if(d<0)
	    			node = node.left;
	    		else if(d>0)
	    			node = node.right;	
	    		return temp;
	    	}
	    	return null;
	    } 
	    public void removeItem(E data)
	    {
	        Node node = search(data);
	        if (node != null)
	        {
	            remove(node);
	            size--;
	        }
	    }  
	    private void remove(Node inputNode) ///
	    {
	    	//Node inputNode=search(inputNode.data);
	    	if(inputNode.left!=null || inputNode.right != null) {
	    		Node node = inputNode.right;
	    		while(node.left != null) {
	    			node = node.left;
	    		}	    		
	    		E value = node.data;
	    		remove(node);
	    		inputNode.data = value;
	    	}
	    /*	else if(inputNode.left==null) {
	    		inputNode=inputNode.right;
	    		findParent(inputNode);
	    		remove(inputNode.right);
	    	}
	    	else if(inputNode.right==null) {
	    		inputNode=inputNode.left;
	    		findParent(inputNode);
	    		remove(inputNode.left);
	    	}	*/
	    	else
	    		inputNode = null;
	    		
	    	
	    		
	    }
	    public void printTreeInOrder() 
	    {
	        firstNodePrinted = true;
	        System.out.print("root = " + root.data + ",   tree = [");
	        printInOrder(root);
	        System.out.println("]");
	        System.out.println();
	    }
	    private void printInOrder(Node node) 
	    { 
	        if (node != null) 
	        { 
	            printInOrder(node.left);
	            if(firstNodePrinted)
	            {
	                System.out.print(node.data);
	                firstNodePrinted = false;
	            }
	            else
	                System.out.print(", " + node.data);
	            printInOrder(node.right); 
	        }
	    }
}
