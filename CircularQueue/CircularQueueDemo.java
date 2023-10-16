package CircularQueue;

public class CircularQueueDemo {
	 public static void main(String[] args) {
		 try {
		 CircularQueue<String> circularQueue = new CircularQueue();
	     circularQueue.enqueue("S");
         System.out.println("S inserted in the queue.");
	     circularQueue.enqueue("T");
         System.out.println("T inserted in the queue.");
	     circularQueue.enqueue("R");
         System.out.println("R inserted in the queue.");
	     circularQueue.enqueue("E");
         System.out.println("E inserted in the queue.");
	     circularQueue.enqueue("S");
         System.out.println("S inserted in the queue.");
	     circularQueue.enqueue("S");
         System.out.println("S inserted in the queue.");
	     circularQueue.enqueue("E");
         System.out.println("E inserted in the queue.");
	     circularQueue.enqueue("D");
         System.out.println("D inserted in the queue.");
         System.out.println("\nQueue = " + circularQueue);
         if (!circularQueue.isEmpty())
             System.out.println("\nThe queue is not empty.");
         else
             System.out.println("\nThe queue is empty.");
         System.out.println();
         
		 CircularQueue<String> circularQueue1 = new CircularQueue();
		 circularQueue1.enqueue("S");
	     circularQueue1.enqueue("T");
	     circularQueue1.enqueue("R");
	     circularQueue1.enqueue("E");
	     circularQueue1.enqueue("S");
	     circularQueue1.enqueue("S");
	     circularQueue1.enqueue("E");
	     circularQueue1.enqueue("D");
	     
         circularQueue1.rotatecounterclockwise();
         System.out.print("After rotating counterclockwise, queue = " + circularQueue1 + "\n");
         circularQueue1.rotateclockwise();
         System.out.print("After rotating clockwise, queue = " + circularQueue1);
           
         System.out.println("\n");

         while(!circularQueue.isEmpty()) {
        	 System.out.println(circularQueue.front() + " is at the front of the queue.");
             System.out.println(circularQueue.front() + " has been removed from the queue.");
             circularQueue.dequeue();
             System.out.println("Queue " + circularQueue + "\n");
         }
         if (!circularQueue.isEmpty())
             System.out.println("The queue is not empty.");
         else
             System.out.println("The queue is empty.");
         System.out.println();
         System.out.println("Calling nums.front()");
         System.out.printf("%c is at the front of the queue.\n",
                 circularQueue.front());
		 
		 }
		 catch(Exception e){
			 System.out.println(e);
		 }
	 }
}