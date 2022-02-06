package dynamic;
import java.util.Scanner;
public class NumberOfSteps {
    public static int N;
    /**
     * dp[i][j] = i번째 자릿수가 j일때 가능한 경우의 수
     */
    public static Long[][] dp;
    public static long answer = 0;
    final static long MOD = 1000000000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        dp = new Long[N+1][10];
        /**
         * dp 배열을 큰 자릿수부터 탐색하는데
         * 가장 작은 1번째 자리에 도달한 경우(dp[1][~])
         * 경우의 수가 한가지 밖에 없으므로 1로 초기화
         * ex) dp[2][2] = dp[1][1] + dp[1][3]
         *         2    =     1    +    1
         */
        for(int i=0; i<10; i++) {
            dp[1][i] = 1L;
        }
        /**
         * N번째 자리가 1~9일때 가능한 모든 계단수의 개수가
         * dp[N][1~9]에 저장되어 있으므로
         * 그것을 모두 더하면 됨
         */
        for(int i=1; i<=9; i++){
            answer += NOS(N, i);
        }
        System.out.println(answer % MOD);
    }
    /**
     * 반복문과 NOS 메소드를 이용하여
     * 가장 큰 N 자릿수가 1일때
     *    다음 자릿수의 값들을 따져보며 경우의 수를 dp[N][1]에 저장
     * ...
     * 가장 큰 N 자릿수가 9일때 경우의 수를 dp[N][9]에 저장
     */
    //digit은 자릿수, num은 해당 자릿수의 값
    private static long NOS(int digit, int num) {
        //첫째 자리수에 도달하면 탐색 중지
        if(digit == 1) {
            return dp[digit][num];
        }
        //아직 탐색하지 않은 경우
        if(dp[digit][num] == null){
            if(num == 0) { //0의 계단수는 1뿐
                dp[digit][num] = NOS(digit-1, 1);
            }
            else if(num == 9) { //9의 계단수는 8뿐
                dp[digit][num] = NOS(digit-1, 8);
            }
            else { //그 외 num의 계단수는 num-1과 num+1
                dp[digit][num] = NOS(digit-1, num-1) + NOS(digit-1, num+1);
            }
        }
        return dp[digit][num]%MOD;
    }
}
