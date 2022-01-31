package baekjoon;
import java.util.Scanner;
public class DigitGenerator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int result = 0;
		for(int i=0; i<N; i++) {
			int tmp = i;
			int sum = 0;
			while(tmp != 0) {
				sum += tmp % 10;
				tmp /= 10;
			}
			if(sum+i == N) {
				result = i;
				break;
			}
		}
		System.out.println(result);
		scanner.close();
	}
}

