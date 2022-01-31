package sort_12;
import java.util.Scanner;
public class Sort1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[] arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = scanner.nextInt();
		}
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				if(arr[i]>arr[j]) {
					int tmp = arr[j];
					arr[j] = arr[i];
					arr[i] = tmp;
				}
			}
		}
		for(int val : arr) {
			System.out.println(val);
		}
		scanner.close();
	}
}
