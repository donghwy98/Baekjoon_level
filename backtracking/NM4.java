package backtracking;
import java.util.Scanner;
public class NM4 {
    public static int N, M;
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();
        arr = new int[M];

        NM4(1,0);
        System.out.println(sb);
    }
    public static void NM4(int at, int level){
        if(level == M){
            for(int num : arr){
                sb.append(num).append(" ");
            }
            sb.append("\n");
           return;
        }
        for(int i=at; i<=N; i++){
            arr[level] = i;
            NM4(i, level+1);
        }
    }
}
