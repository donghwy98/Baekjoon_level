package baekjoon;
import java.util.Scanner;
public class Blackjack {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = scanner.nextInt();
		}
		int result = search(arr, N, M);
		System.out.println(result);
		scanner.close();
	}
	static int search(int[] arr, int N, int M) {
		int result=0;
		for(int i=0; i<N-2; i++) {
			if(arr[i]>M) {
				continue;
			}
			for(int j=i+1; j<N-1; j++) {
				if(arr[i]+arr[j] > M) {
					continue;
				}
				for(int k=j+1; k<N; k++) {
					int tmp = arr[i]+arr[j]+arr[k];
					if(M == tmp) {
						return tmp;
					}
					if(result < tmp && tmp < M) {
						result = tmp;
					}
				}
			}
		}
		return result;
	}
}



