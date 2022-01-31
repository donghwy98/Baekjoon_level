package baekjoon;
import java.util.Scanner;
public class Factorial {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int answer = factorial(N);
		System.out.println(answer);
		scanner.close();
	}
	public static int factorial(int N) {
		if(N<=1) return 1;
		return N*factorial(N-1);
	}
}
