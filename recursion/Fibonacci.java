package baekjoon;
import java.util.Scanner;
public class Fibonacci {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int answer = fibonacci(N);
		System.out.println(answer);
		scanner.close();
	}
	public static int fibonacci(int N) {
		if (N==0) return 0;
		if (N==1) return 1;
		return fibonacci(N-2) + fibonacci(N-1);
	}
}
