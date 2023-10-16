package BinarySearchTree3;

public interface BinarySearchTree3Interface<E extends Comparable> 
{
    public int size();
    public boolean isEmpty(); 
    public void insertItem(E item);
    public boolean inTree(E item); 
    public void removeItem(E item); 
    public void printTreeInOrder(); 
    public void printTreeInPreOrder(); 
    public void printTreeInPostOrder();
} 