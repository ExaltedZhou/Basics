package CircularQueue;

public class StackDemo 
{
    public static void main(String[] args)
    {
        try
        {
            Stacks<Integer> nums = new Stacks<>();
            nums.push(12);
            System.out.printf("%d pushed onto the stack.\n",nums.top());
            nums.push(4);
            System.out.printf("%d pushed onto the stack.\n",nums.top());
            nums.push(51);
            System.out.printf("%d pushed onto the stack.\n",nums.top());
            nums.push(1);
            System.out.printf("%d pushed onto the stack.\n",nums.top());
            nums.push(16);
            System.out.printf("%d pushed onto the stack.\n",nums.top());
            nums.push(5);
            System.out.printf("%d pushed onto the stack.\n\n",nums.top());
            System.out.println("Stack = " + nums);
            System.out.println();
            
            if (!nums.isEmpty())
                System.out.println("The stack is not empty.");
            else
                System.out.println("The stack is empty.");
            System.out.println();
            
            while (!nums.isEmpty())
            {
                System.out.printf("%d is at the top of the stack.\n",
                        nums.top());
                System.out.printf("%d has been popped off of the stack.\n",
                        nums.pop());
                System.out.println("Stack = " + nums);
                System.out.println();
            }
            
            if (!nums.isEmpty())
                System.out.println("The stack is not empty.");
            else
                System.out.println("The stack is empty.");
            System.out.println();
           
            System.out.println("Calling nums.top()");
            System.out.printf("%d is at the top of the stack.\n",
                    nums.top());           
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
