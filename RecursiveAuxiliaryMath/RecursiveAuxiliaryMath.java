//class prints first and last day of class
//Albert Zhou
//csc 1351 - 02
//azhou2
//2/5/2021
package RecursiveAuxiliaryMath;
public class RecursiveAuxiliaryMath {
	public static boolean recursiveIsPalindrome(String num, int i , int j) {
		int n = num.length();
		if(n == 1||n==0) {
			return true;
		}
		else if (n>1&&num.charAt(i) == num.charAt(j) && i<=j) { 
			num = num.substring(i + 1, j);
            return recursiveIsPalindrome(num, i, j);
		}
        return false;
	}
	public static long recursiveFibonacci(int n) {
		  if(n == 0)
			  return 0;
	      else if(n == 1)
	          return 1;
	      else
	    	  return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
	}
	public static int recursiveGCD(int a, int b) {
		if(b == 0) 
			return a;
		if(a == 0) 
			return b;
		else
			return recursiveGCD(b, a%b);
	}
	public static double recursivePowInt(double a, int n) {
		if(n == 1) 
			return a;
		else if(n == 0)
			return 1;
		else if(n == -1)
			return 1/a;
		else if(n > 0)	
			return a*recursivePowInt(a, n - 1);
		else
			return recursivePowInt(a, n + 1)/a;
	}
}
