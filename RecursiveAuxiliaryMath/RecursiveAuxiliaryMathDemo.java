package RecursiveAuxiliaryMath;
import java.util.Scanner;
public class RecursiveAuxiliaryMathDemo {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in); 
		System.out.print("Enter three integers whose GCD is to be found -> ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int aa = RecursiveAuxiliaryMath.recursiveGCD(RecursiveAuxiliaryMath.recursiveGCD(a, b),c);
		System.out.print("Enter an integer n to sum the fibonacci series up to fibonacci(n) -> ");
		int n = sc.nextInt();
		int x = 0;
		for(int i = n; i > 0; i--) {
			long bb = RecursiveAuxiliaryMath.recursiveFibonacci(n);
			x += bb;
		}
		System.out.print("Enter the base and exponent, an integer, of a power -> ");
		double r = sc.nextDouble();
		int d = sc.nextInt();
		double cc = RecursiveAuxiliaryMath.recursivePowInt(r, d);	
		System.out.print("Enter two positive integers 1 and j where i < j -> ");
		int dd = 0;
		int i = sc.nextInt();
		int j = sc.nextInt();
		for(int k=i;k<=j;k++) {
			String sk=k+"";
			if(RecursiveAuxiliaryMath.recursiveIsPalindrome(sk, 0, sk.length()-1))
				dd++;
		}		
		System.out.println("\ngcd(" + a + "," + b + "," + c + ") = " + Math.abs(aa));
		System.out.println("Sum up to fibonacci(" + n + ") = " + x);
		System.out.printf("%.6f%s%d%s%.6f", r, " ^ ", d, " = ", cc);
		System.out.println("\nThere are " + dd + " palindromic numbers between " + i + " and " + j);
	}
}













