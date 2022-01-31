package backtracking;
import java.util.Scanner;
public class NM3 {
    public static int[] arr;
    public static int N, M;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        arr = new int[M];
        NM3(0);
        System.out.println(sb);
        scanner.close();
    }
    public static void NM3(int level) {
        if(level == M) {
            for(int i=0; i<M; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1; i<=N; i++){
            arr[level] = i;
            NM3(level+1);
        }
    }
}
