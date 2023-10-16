package sumseries;

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
public class SortTimer 
{
    public static void selectionSort(int[] nums)
    {
        int n = nums.length;
        int min, index, temp;
        for (int j = 0; j < n-1; j++)
        {   
            min = nums[j];
            index = j;
            for(int k = j+1; k < n; k++)
                if(nums[k] < min)
                {   
                    min = nums[k]; 
                    index = k;
                }
            if(index != j)
            {
                temp = nums[j];
                nums[j] = nums[index];
                nums[index] = temp;
            }
        }
    }

    

    
    /**
     * Uses the insertion sort to sort an array of integers into increasing
     * order.
     * @param nums the array to be sorted
     */
    public static void insertionSort(int[] nums)
    {
        int n = nums.length;
        int j, k, next;
        for(j = 1; j < n; j++)
        {
            next = nums[j];
            for(k = j-1; k >= 0; k--)
                if(next >= nums[k])
                {
                    nums[k+1] = next;
                    break;
                }
                else
                    nums[k+1] = nums[k];
            if(k < 0)
                nums[0] = next;
        }
    }


    public static void main(String[] args) 
    {
        
        System.out.println();
        
        int seed = 0;
        Random rand = new Random(seed);
        int maxRandomValue = 1000000;
        int numRuns = 3;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the starting value for the length n of "
                + "the array to be sorted, the stepsize by which n is "
                + "increased, and the number of steps: ");
        int start = in.nextInt();
        int stepSize = in.nextInt();
        int numSteps = in.nextInt();
        int end = start + numSteps * stepSize;
        System.out.println();
        
        for (int n = start; n <= end; n += stepSize)
        {            
            int[] nums1 = new int[n];
            int[] nums2 = new int[n];
            long sum1 = 0;
            long sum2 = 0;
            int m;
            
            for (int j = 1; j <= numRuns; j++)
            {                    
                for (int i = 0; i < n; i++)
                {
                    m = rand.nextInt(maxRandomValue) + 1;
                    nums1[i] = m;
                    nums2[i] = m;
                }
                
                long startTime = System.currentTimeMillis();
                selectionSort(nums1);
                long endTime = System.currentTimeMillis();
                long elapsedTime = endTime - startTime;
                sum1 += elapsedTime;        
                
                startTime = System.currentTimeMillis();
                insertionSort(nums2);
                endTime = System.currentTimeMillis();
                elapsedTime = endTime - startTime;
                sum2 += elapsedTime;        

            }
            long average1 = (long)(1. * sum1 / numRuns);
            long average2 = (long)(1. * sum2 / numRuns);
            System.out.printf("n = %6d   Sort Run Time (milliseconds):  "
                    + "Selection: %4d   Insertion: %4d\n", 
                    n, average1, average2);
        }
        
    }
    
}