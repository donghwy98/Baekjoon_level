package greedy;
import java.util.Scanner;
public class CoinZero {
    public static int N, K;
    public static int[] coins;
    public static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();
        coins = new int[N];
        for(int i=0; i<N; i++) {
            coins[i] = scanner.nextInt();
        }
        System.out.println(greedy(N-1));
    }
    private static int greedy(int x) {
        for(int i=x; i>=0; i--) {
            while(coins[i] <= K) {
                K -= coins[i];
                count++;
            }
        }
        return count;
    }
}
