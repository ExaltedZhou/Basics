package statisticsdemo;

import java.util.Scanner;

public class Fibonacci 
{
    public static long iterativeFibonacci(int n)
    {
        if(n == 0)
            return 0;
        else if(n == 1)
            return 1;
        else
        {
            long a, b, sum = 0;
            a = 1;
            b = 0;
            for(int i = 2; i <= n; i++)
            {
                sum = a + b;
                b = a;
                a = sum;
            }
            return sum;
        }
    }
    
    public static long recursiveFibonacci(int n)
    {
        if(n == 0)
            return 0;
        else if(n == 1)
            return 1;
        else
            return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }
   
    public static void main(String[] args) 
    {
       Scanner scan = new Scanner(System.in);
       System.out.print("Enter n: ");
       int n = scan.nextInt();
       long fib;
       long startTime, endTime, elapsedTime;
       startTime = System.currentTimeMillis();
       fib = iterativeFibonacci(n);
       endTime = System.currentTimeMillis();
       elapsedTime = endTime - startTime;
       System.out.printf("Iterative Fibonacci(%d) = %d   Time (millisec) = "
               + "%d\n", n, fib, elapsedTime);
       startTime = System.currentTimeMillis();
       fib = recursiveFibonacci(n);
       endTime = System.currentTimeMillis();
       elapsedTime = endTime - startTime;
       System.out.printf("Recursive Fibonacci(%d) = %d   Time (millisec) = "
               + "%d\n", n, fib, elapsedTime);
    }    
}