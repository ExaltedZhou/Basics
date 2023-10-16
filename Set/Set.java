package Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Set<T> {
	public static ArrayList diff(ArrayList A, ArrayList B) {
		ArrayList diff = new ArrayList();
		diff.addAll(A);
		diff.removeAll(B);
		return diff;
	}
	public static ArrayList intersection(ArrayList A, ArrayList B) {
		ArrayList inter = new ArrayList();
		inter.addAll(A);
		inter.retainAll(B);
		return inter;
	}
	public static ArrayList union(ArrayList A, ArrayList B) {
		ArrayList uni = new ArrayList();
		uni.addAll(A);
		uni.addAll(diff(B,A));
		return uni;
	}
	public static boolean equals(ArrayList A, ArrayList B) {
		return (diff(A,B).isEmpty()&&diff(B,A).isEmpty());
	}
	public static boolean subset(ArrayList A, ArrayList B) {
		return equals(A,intersection(A,B));
	}
	public static boolean properSubset(ArrayList A, ArrayList B) {
		return subset(A,B)&&A.size()<B.size();
	}
	
}
