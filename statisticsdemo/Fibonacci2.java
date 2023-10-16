package statisticsdemo;

import java.util.Scanner;
public class Fibonacci2 
{
    
    public static long f0 = 0, f1 = 0, f2 = 0;
    public static long iterativeF(int n)
    {
        if(n == 0)
            return 0;
        else if(n == 1)
            return 1;
        else
        {
            long a, b, Fn = 0;
            b = 0;
            a = 1;
            for(int i = 2; i <= n; i++)
            {
                Fn = a + b;
                b = a;
                a = Fn;
            }
            return Fn;
        }
    }
    
    public static long F(int n)
    {
        if(n == 0)
            return 0;
        else if(n == 1)
            return 1;
        else
        {
            long Fn;
            if(n == 2)
            {
                f1++;
                f0++;
            }
            if(n == 3)
            {
                f2++;
                f1++;
            }
            if(n == 4)
            {
                f2++;
            }
            Fn = F(n - 1) + F(n - 2);
            return Fn;
        }
    }
   
    public static void main(String[] args) 
    {
       Scanner scan = new Scanner(System.in);
       System.out.print("Enter n: ");
       int n = scan.nextInt();
       long fib;
       long startTime, endTime, elapsedTime;
       startTime = System.currentTimeMillis();
       fib = iterativeF(n);
       endTime = System.currentTimeMillis();
       elapsedTime = endTime - startTime;
       System.out.printf("Iterative Fib(%d) = %d   Time (millisec) = %d\n", 
               n, fib, elapsedTime);
       startTime = System.currentTimeMillis();
       fib = F(n);
       endTime = System.currentTimeMillis();
       elapsedTime = endTime - startTime;
       System.out.printf("Recursive Fib(%d) = %d   Time (millisec) = %d\n", 
               n, fib, elapsedTime);
       
       System.out.println("n = " + n + "   f0 = " + f0 + "   f1 = " + f1 
               + "   f2 = " + f2);
    }
    
}