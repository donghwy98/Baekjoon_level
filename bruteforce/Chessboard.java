package baekjoon;
import java.util.Scanner;
public class Chessboard {
	public static boolean[][] arr;
	public static int min = 64;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		arr = new boolean[N][M];
		scanner.nextLine();
		for(int i=0; i<N; i++) {
			String str = scanner.nextLine().trim();
			for(int j=0; j<M; j++) {
				if(str.charAt(j)=='W') {
					arr[i][j] = true;
				} else {
					arr[i][j] = false;
				}
			}
		}
		int N_row = N-7;
		int M_col = M-7;
		for(int i=0; i<N_row; i++) {
			for(int j=0; j<M_col; j++) {
				find(i, j);
			}
		}
		System.out.println(min);
		scanner.close();
	}
	public static void find(int x, int y) {
		int end_x = x+8;
		int end_y = y+8;
		int count = 0;
		boolean bool = arr[x][y];
		for(int i=x; i<end_x; i++) {
			for(int j=y; j<end_y; j++) {
				if (arr[i][j] != bool) {
					count++;
				}
				bool = (!bool);
			}
			bool = (!bool);
		}
		count = Math.min(count, 64 - count);
		min = Math.min(min, count);
	}
}
