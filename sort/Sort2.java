package sort_12;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class Sort2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = scanner.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i=0; i<N; i++) {
			arr.add(scanner.nextInt());
		}
		Collections.sort(arr);
		for(int val : arr) {
			sb.append(val).append('\n');
		}
		System.out.println(sb);
		scanner.close();
	}
}
