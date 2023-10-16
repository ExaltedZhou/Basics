package statisticsdemo;
import java.util.Scanner;
public class SumSeries 
{
    public static double iterativeSum(double a, int n, double d)
    {
        double sum = 0;
        for(int i = 1; i <= n; i++)
            sum += a + (i - 1)*d;
        return sum;
    }
    public static double recursiveSum(double a, int n, double d)
    {
        if(n == 1)
            return a;
        else
        {
            double sum;
            sum = a + (n - 1)*d + recursiveSum(a, n-1, d);
            return sum;
        }
    }    
    public static void main(String[] args) 
    {
         Scanner scan = new Scanner(System.in);
         System.out.print("Enter a, n, d: ");
         double a = scan.nextDouble();
         int n = scan.nextInt();
         double d = scan.nextDouble();
         double sum;
         long startTime = System.currentTimeMillis();
         sum = iterativeSum(a, n, d);
         long endTime = System.currentTimeMillis();
         long elapsedTime = endTime - startTime;
         
         System.out.printf("a = %.1f   n = %d   d = %.1f   "
                 + "Iterative Sum = %.1f     Time (millisecs) = %d\n", 
                 a, n, d, sum, elapsedTime);
         
         startTime = System.currentTimeMillis();
         sum = recursiveSum(a, n, d);
         endTime = System.currentTimeMillis();
         elapsedTime = endTime - startTime; 
         System.out.printf("a = %.1f   n = %d   d = %.1f   "
                 + "Recursive Sum = %.1f     Time (millisecs) = %d\n", 
                 a, n, d, sum, elapsedTime);
    }    
}
