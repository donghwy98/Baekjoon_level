package baekjoon;
import java.util.Scanner;
public class MovieDirector {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int apocalypseNum = 666;
		int count = 1;
		while(count != N) {
			apocalypseNum++;
			if(String.valueOf(apocalypseNum).contains("666")) {
				count++;
			}
		}
		System.out.println(apocalypseNum);
		scanner.close();
	}
}
