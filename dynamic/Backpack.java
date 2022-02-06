package dynamic;
import java.util.Scanner;
public class Backpack {
    public static int N;
    public static int K;
    public static int[] W;
    public static int[] V;
    //dp[n][w] : 최대 무게가 w이고 n번째 물건까지 탐색했을 때의 최대 가치
    public static Integer[][] dp;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();
        W = new int[N];
        V = new int[N];
        dp = new Integer[N][K+1];
        for(int i=0; i<N; i++) {
            W[i] = scanner.nextInt();
            V[i] = scanner.nextInt();
        }
        System.out.println(dpValue(N-1, K));
    }
    /**
     * dp[i][k] : i=물건 인덱스, k=가방 최대 무게
     * i＼k  0  1  2  3  4  5  6  7
     *  1    0  0  0  0  0  0 13 13
     *  2    0  0  0  0  8  8 13 13
     *  3    0  0  0  6  8  8 13 14
     *  4    0  0  0  6  8 12 13 14
     */
    private static int dpValue(int i, int k) {
        if(i<0){
            return 0;
        }
        if(dp[i][k]==null) {
            if(W[i] > k) { //현재 i번째 물건의 무게가 k를 초과하는 경우(이전 i값 탐색)
                dp[i][k] = dpValue(i-1, k);
            }
            else if(W[i] <= k) { //현재 물건을 담을 수 있는 경우
                /**
                 * i번째 물건을 담고 남은 무게 => k-W[i]
                 * 최대 무게가 k-W[i]일 때, i-1번째 물건까지 담은 경우의 최대 가치 => dp[i-1][k-W[i]]
                 * 그러므로 현재 물건이 i번째이고, 최대 무게가 k일때
                 *   1) i-1번째 물건까지 넣은 최대가치 dpValue(i-1, k)
                 *   2) i번째 물건의 가치 V[i]와
                 *      i번째 물건을 넣고 남은 무게에 대해서 i-1번째 물건까지 넣은 최대가치 dpValue(i-1, kW[i])의 합
                 * 이 두가지 중 최댓값을 저장
                 */
                dp[i][k] = Math.max(dpValue(i-1, k), dpValue(i-1, k-W[i]) + V[i]);
            }
        }
        return dp[i][k];
    }
}
