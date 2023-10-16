package Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class SetDemo extends Set{
	public static void setOperationsDemo(ArrayList s1, ArrayList s2, ArrayList s3) {
		String s11 = s1.toString();
		s11 = s11.substring(1, s11.length() - 1);
		String s12 = s2.toString();
		s12 = s12.substring(1, s12.length() - 1);
		String s13 = s3.toString();
		s13 = s13.substring(1, s13.length() - 1);
		System.out.println("\ns1= {"+ s11 + "}");
		System.out.println("s2= {"+ s12 + "}");
		System.out.println("s3= {"+ s13 + "}");
		System.out.println("(s1 - s2) u (s2 - s1) = " + union(diff(s1,s2),diff(s2,s1)));
		System.out.println("(s1 u s2) - (s1 u s2) = " + diff(union(s1,s2),intersection(s2,s1)));
		System.out.println("Is ( s1 - s2) n (s2 - s1) empty? " + 
		intersection(diff(s1, s2), diff(s2,s1)).isEmpty());
		System.out.println("Are s1 n ( s2 u s3) and (s1 n s2) u (s1 n s3) equal? " + 
		equals(intersection(s1,union(s2,s3)),union(intersection(s1,s2),intersection(s1,s3))));
		System.out.println("Are (s1 n s2) u (s2 n s3) and (s1 u s3) equal? " +
		equals(union(intersection(s1,s2),intersection(s2,s3)),union(s1,s3)));
		System.out.println("Is (s1 - s2) a subset of s2? " + subset(diff(s1,s2),s2));
		System.out.println("Is (s1 - s2) u (s2 n s3) a subset of s1 " + 
		subset(union(diff(s1,s2),intersection(s2,s3)),s1));
		System.out.println("Is ( s1 - s2) u (s2 n s3) a proper subset of s1? " +
		properSubset(union(diff(s1,s2),intersection(s2,s3)),s1));
		System.out.println("Max element in s1 = " + getMax(s1));
		System.out.println("Max element in s2 = " + getMax(s2));
		System.out.println("Max element in s3 = " + getMax(s3));
	}
		public static <T extends Comparable> T getMax(ArrayList<T> s) {
			int n = s.size();
			T max = s.get(0);
			for(int i = 1; i<n;i++) {
				if((s.get(i)).compareTo(max)>0) {
					max = s.get(i);
				}
			}
			//System.out.println("Max value in s1 = " + max);
			return max;
		}
		public static void main(String[]args) {
			ArrayList s1 = new ArrayList(Arrays.asList(4,2,5,1,3));
			ArrayList s2 = new ArrayList(Arrays.asList(7,3,2,9,5));
			ArrayList s3 = new ArrayList(Arrays.asList(5,8,3,2,4));
			setOperationsDemo(s1,s2,s3);
			ArrayList s4 = new ArrayList(Arrays.asList("D","B","A","E","C"));
			ArrayList s5 = new ArrayList(Arrays.asList("G","I","C","B","E"));
			ArrayList s6 = new ArrayList(Arrays.asList("F","C","H","B","D"));
			setOperationsDemo(s4,s5,s6);
			ArrayList s7 = new ArrayList(Arrays.asList("Gina","Bob","Jim","Anna","Mary"));
			ArrayList s8 = new ArrayList(Arrays.asList("Tom","Hal","Marcy","Bob","Anna"));
			ArrayList s9 = new ArrayList(Arrays.asList("Hal","Mary","Bob","Sara","Gina"));
			setOperationsDemo(s7,s8,s9);
			

		}
		
}
