package BinarySearchTree;

public interface BinarySearchTreeInterface<E extends Comparable> {
	public int size();
    public boolean isEmpty(); 
    public void insertItem(E data);
    public boolean inTree(E data); 
    public void removeItem(E data); 
    public void printTreeInOrder(); 
}
