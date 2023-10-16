package BinarySearchTree3;


public class BinarySearchTree3<E extends Comparable> 
                              implements BinarySearchTree3Interface<E>
{
    private Node root; 
    private int size;
    private boolean firstNodePrinted;
    private boolean completeTree;
    private boolean nullChildFound;
    
    private class Node 
    {
        public E data; 
        public Node left; 
        public Node right;
    } 
    
    public BinarySearchTree3() 
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

    public boolean inTree(E data) 
    { 
        return search(data) != null; 
    }
    
    private Node findParent(Node inputNode) 
    { 
        if (inputNode == root) 
            return null; 
        Node node = root; 
        while(true) 
        { 
            int d = inputNode.data.compareTo(node.data);
            if (d < 0) 
            { 
                if (inputNode == node.left) 
                    return node; 
                node = node.left; 
            } 
            else 
            {
                if (inputNode == node.right) 
                    return node; 
                node = node.right; 
            } 
        } 
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
    
    /** 
     * A recursive auxiliary method for the removeItem method  
     */ 
    private void remove(Node inputNode)
    {
        Node parent, node, replacementNode;
        E replacementData;
        if (inputNode.left != null && inputNode.right != null)
        {
            // Case 1 : The input node has both a left child and a right child.
            node = inputNode.right;
            while (node.left != null)
                node = node.left;
            replacementData = node.data;
            remove(node);
            inputNode.data = replacementData;
            return;
        }
        else if(inputNode.left != null && inputNode.right == null)                
        {
            // Case 2 : The input node has a left child but not a right child.
            replacementNode = inputNode.left;
        }
        else if(inputNode.right != null && inputNode.left == null)                
        {
            // Case 3 : The input node has a right child but not a left child. 
            replacementNode = inputNode.right;
        }
        else
        {
            // Case 4 : The input node has neither a left child nor a right child.
            replacementNode = null;
        }
        parent = findParent(inputNode);
        if (parent == null)
            root = replacementNode;
        else if (parent.left == inputNode)
            parent.left = replacementNode;
        else
            parent.right = replacementNode;
    }

    public void printTreeInOrder() 
    {
        firstNodePrinted = true;
        System.out.println("root = " + root.data);
        System.out.print("tree in order      = [");
        printInOrder(root);
        System.out.println("]");
    }

    /** 
     * A recursive auxiliary method for the printTreeInOrder method.
     * First it prints all of the left descendants of the inputNode,
     * then it prints the input node,
     * then it prints all of the right descendants of the input node.
     */ 
    private void printInOrder(Node inputNode) 
    { 
        if (inputNode != null) 
        { 
            printInOrder(inputNode.left);
            if(firstNodePrinted)
            {
                System.out.print(inputNode.data);
                firstNodePrinted = false;
            }
            else
                System.out.print(", " + inputNode.data);
            printInOrder(inputNode.right); 
        }
    }

    public void printTreeInPreOrder() 
    {
        firstNodePrinted = true;
        System.out.print("tree in pre-order  = [");
        printInPreOrder(root);
        System.out.println("]");
    }

    /** 
     * A recursive auxiliary method for the printTreeInPreOrder method.
     * First it prints the input node,
     * then it prints all of the left descendants of the input node,
     * then it prints all of the right descendants of the input node.
     * Refer to the printInOrder method in the starter code.
     */ 
    private void printInPreOrder(Node inputNode) 
    { 
    	if (inputNode == null) {
    	      return;
    	    }
    		printInPreOrder(inputNode.left);
    	    System.out.printf("%s ", inputNode.data);
    	    printInPreOrder(inputNode.right);
    }

    public void printTreeInPostOrder() 
    {
        firstNodePrinted = true;
        System.out.print("tree in post-order = [");
        printInPostOrder(root);
        System.out.println("]");
    }

    /** 
     * A recursive auxiliary method for the printTreeInPostOrder method.
     * First it prints all of the left descendants of the input node,
     * then it prints all of the right descendants of the input node,
     * then it prints the input node.
     * Refer to the printInOrder method in the starter code.
     */ 
    private void printInPostOrder(Node inputNode) 
    { 
        // Implement this method.
    }
    
    public void printHeight()
    {
        System.out.println("height = " + height(root));
    }

    /** 
     * A recursive auxiliary method for the printHeight method.
     * It computes the "height" of a subtree -- the number of
     * nodes along the longest path from the top node of the
     * subtree down to the farthest leaf node. 
     */ 
    private int height(Node topNode)
    {
		return size;
        // Implement this method.
    }    

    public void printTreeInLevelOrder()
    {
        int currentLevel, printLevel;
        int h = height(root);
        System.out.println("tree in level order:");
        for (printLevel = 1; printLevel <= h; printLevel++)
        {
            currentLevel = 1;
            printNodesInLevel(root, currentLevel, printLevel);
            System.out.println();
        }
    }
    
    /** 
     * A recursive auxiliary method for the printTreeInLevelOrder method.
     * It prints the nodes in the level denoted as printLevel.
     */ 
    private void printNodesInLevel(Node inputNode,int currentLevel,int printLevel)
    {
        // Implement this method.
    }
    
    public boolean isFullTree(E data) throws Exception 
    {
        Node topNode = search(data);
        if (topNode == null) 
            throw new Exception("Data item expected to be in tree.");
        return isFull(topNode);
    }
    
    /** 
     * A recursive auxiliary method for the isFullTree method.  
     * It returns true if the subtree rooted at topNode is full,
     * otherwise it returns false.
     */ 
    private boolean isFull(Node topNode)
    {
        if(topNode.left == null && topNode.right == null)
            return true;
        else if(topNode.left != null && topNode.right != null)
            return isFull(topNode.left) && isFull(topNode.right);
        else
            return false;
    }
    
    /**
     * Recursively determines the size (number of nodes) in the subtree
     * rooted at the input node.
     */
    public int sizeOfTree(Node inputNode) 
    {
		return size;
        // Implement this method.
    }
    
    public boolean isPerfectTree(E data) throws Exception
    {
        Node topNode = search(data);
        if (topNode == null) 
            throw new Exception("Data item expected to be in tree.");
        return isPerfect(topNode);    
    }
    
    /** 
     * An auxiliary method for the isPerfectTree method.  
     * It returns true if the subtree rooted at the input node is perfect,
     * otherwise it returns false.
     */ 
    private boolean isPerfect(Node inputNode)
    {
		return completeTree;
        // Implement this method.
    }

    public boolean isCompleteTree(E data) throws Exception
    {
        Node topNode = search(data);
        if (topNode == null) 
            throw new Exception("Data item expected to be in tree.");
        int currentLevel, levelToBeChecked;
        int h = height(topNode);
        completeTree = true;
        for (levelToBeChecked = 1; levelToBeChecked <= h-1; levelToBeChecked++)
        {
            currentLevel = 1;
            nullChildFound = false;
            isComplete(topNode, currentLevel, levelToBeChecked);
        }
        return completeTree;
    }

    private void isComplete(Node node, int currentLevel, int levelToBeChecked)
    {
        if(node == null)
            return;
        if(currentLevel == levelToBeChecked)
        {
            if(node.left != null)
            {
                if(nullChildFound)
                    completeTree = false;
            }
            else
                nullChildFound = true;
            if(node.right != null)
            {
                if(nullChildFound)
                    completeTree = false;
            }
            else
                nullChildFound = true;
        }
        else
        {
            currentLevel++;
            isComplete(node.left, currentLevel, levelToBeChecked);
            isComplete(node.right, currentLevel, levelToBeChecked);
        }           
    }
        
}
