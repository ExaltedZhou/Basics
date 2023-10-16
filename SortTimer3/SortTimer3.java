package SortTimer3;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class SortTimer3 {
	public static void selectionSort(int[] nums) {
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
	public static void selectionSortPrint(int[] nums) {
		System.out.println("Selection Sort:\nnums = " + Arrays.toString(nums));
		int n = nums.length;
        int min, index, temp;
        for (int j = 0; j < n-1; j++) {   
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
            System.out.println("nums = " + Arrays.toString(nums));
        } 
	}
	public static void insertionSort(int[] nums) {
		int n = nums.length;
		int j,k,next;
		for(j = 1; j < n; j++) {
			next = nums[j];
			for(k = j-1; k >= 0; k--)
				if(next >= nums[k]) {
					nums[k+1] = next;
					break;
				}
				else 
					nums[k+1] = nums[k];
			if(k < 0)
				nums[0] = next;
		}
	}
	public static void insertionSortPrint(int[] nums) {
		System.out.println("\nInsertion Sort:\nnums = " + Arrays.toString(nums));
		int n = nums.length;
			int j,k,next;
			for(j = 1; j < n; j++) {
				next = nums[j];
				for(k = j-1; k >= 0; k--)
					if(next >= nums[k]) {
						nums[k+1] = next;
						break;
					}
					else 
						nums[k+1] = nums[k];
				if(k < 0)
					nums[0] = next;
				System.out.println("nums = " + Arrays.toString(nums));
			}
	}
	public static void mergeSort(int[] nums, int left, int right) {
		if(left < right) {
			int middle = (left + right)/2;
			if(left < middle) {
				mergeSort(nums, left, middle); 
			}
			if(middle+1 < right) {
				mergeSort(nums, middle+1, right);
			}
			int m = left; int n = middle+1; int k = 0;
			int result[] = new int[right-left+1];
			while (m <= middle && n <= right) { 
					result[k++]=nums[m]<nums[n]?nums[m++]:nums[n++];	
			}		
			if(n>middle+1) {
				while(m <= middle) { 
					result[k++]=nums[m++];
				}
				while(n<=right) {
					result[k++]=nums[n++];
				}
				int j=0;
				while(left<= right) {
					nums[left++]=result[j++];
				}
			}
		}
	}
	public static void mergeSortPrint(int[] nums, int left, int right) {
		//System.out.println("\nmerge Sort:\nnums = " + Arrays.toString(nums));
		if(left < right) {
			int middle = (left + right)/2;
			if(left < middle) {
				mergeSortPrint(nums, left, middle); 
			}
			if(middle+1 < right) {
				mergeSortPrint(nums, middle+1, right);
			}
			int m = left; int n = middle+1; int k = 0;
			int result[] = new int[right-left+1];
			while (m <= middle && n <= right) { 
				result[k++]=nums[m]<nums[n]?nums[m++]:nums[n++];
			}
			if(n>middle+1) {
				while(m <= middle) { 
					result[k++]=nums[m++];
				}
				while(n<=right) {
					result[k++]=nums[n++];
				}	
				int j=0;
				while(left<= right) {
					nums[left++]=result[j++];
				}					
			}
			System.out.println("nums = " + Arrays.toString(nums));
		}
	}
	public static void quickSort(int[] nums, int left, int right) {
		if(left < right) {
			int p = partition(nums, left, right);
			if(left < p) {
				quickSort(nums, left, p);
			}
			if(p+1 < right) {
				quickSort(nums, p+1, right);
			}
		}
	}
	public static int partition(int[] nums, int left, int right) {
		int pivot = nums[left];
		int i = left-1; int j = right+1;
		while(i < j) {
			for (i++; nums[i] < pivot; i++);
			for (j--; nums[j] > pivot; j--);
			if(i < j) {
				int k = nums[i];
				nums[i] = nums[j];
				nums[j] = k;
			}
		}
		System.out.println("nums = " + Arrays.toString(nums));
		return j; 
	}
	public static void quickSortPrint(int[] nums, int left, int right) {
		if(left < right) {
			System.out.println("\nQuick Sort:\nnums = " + Arrays.toString(nums));
			int p = partition(nums, left, right);
			if(left < p)
				quickSort(nums, left, p);
			if(p+1 < right)
				quickSort(nums, p+1, right);
		}
	}
	public static void main(String[] args) {
		int[] numsSelection = {5,6,4,7,2,1,8,3};
		selectionSortPrint(numsSelection);
		int[] numsInsertion = {5,8,4,6,2,1,7,3};
		insertionSortPrint(numsInsertion);
		int[] numsMerge = {5,3,6,4,2,0,1};
		System.out.println("\nmerge Sort:\nnums = " + Arrays.toString(numsMerge));
		mergeSortPrint(numsMerge, 0, numsMerge.length-1);		
		int[] numsQuick = {5,8,4,7,2,1,6,3};
		quickSortPrint(numsQuick, 0, numsQuick.length-1);
 /*       int seed = 0;
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
            int[] nums3 = new int[n];
            int[] nums4 = new int[n];
            long sum1 = 0;
            long sum2 = 0;
            long sum3 = 0;
            long sum4 = 0;
            int m;
            
            for (int j = 1; j <= numRuns; j++)
            {                    
                for (int i = 0; i < n; i++)
                {
                    m = rand.nextInt(maxRandomValue) + 1;
                    nums1[i] = m;
                    nums2[i] = m;
                    nums3[i] = m;
                    nums4[i] = m;
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

                startTime = System.currentTimeMillis();
                mergeSort(nums3, 0, nums3.length-1);
                endTime = System.currentTimeMillis();
                elapsedTime = endTime - startTime;
                sum3 += elapsedTime;        

                startTime = System.currentTimeMillis();
                quickSort(nums4, 0, nums4.length-1);
                endTime = System.currentTimeMillis();
                elapsedTime = endTime - startTime;
                sum4 += elapsedTime;                    
            }
            long average1 = (long)(1. * sum1 / numRuns);
            long average2 = (long)(1. * sum2 / numRuns);
            long average3 = (long)(1. * sum3 / numRuns);
            long average4 = (long)(1. * sum4 / numRuns);
            System.out.printf("n = %6d   Sort Run Time (milliseconds):  "
                    + "Selection: %4d   Insertion: %4d   Merge: %3d"
                    + "   Quick: %3d\n", 
                    n, average1, average2, average3, average4);
        }*/
        
    }
}

	 
