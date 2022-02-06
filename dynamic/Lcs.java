package dynamic;
import java.util.Scanner;
public class Lcs {
    public static char[] str1;
    public static char[] str2;
    public static Integer[][] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //toCharArray()는 문자열을 char[] 배열로 반환
        str1 = scanner.nextLine().toCharArray();
        str2 = scanner.nextLine().toCharArray();
        dp = new Integer[str1.length][str2.length];

        System.out.println(LCS(str1.length-1, str2.length-1));
    }
    /**
     *   A C A Y K P
     * C 0 1 1 1 1 1
     * A 1 1 2 2 2 2 ←--이 위치의 [A][P]의 경우
     * P 1 1 2 2 2 3     {C,A}와 {A,C,A,Y,K,P}의 가장 긴 부분수열의 길이 2
     * C 1 2 2 2 2 3
     * A 1 2 3 3 3 3
     * K 1 2 3 3 4 4
     */
    private static int LCS(int x, int y) {
        //인덱스 범위를 벗어날 경우 0 반환
        if(x==-1 || y==-1){
            return 0;
        }
        if(dp[x][y] == null){
            dp[x][y] = 0;
            //str1의 x번째 문자와 str2의 y번째 문자가 같은지 비교
            if(str1[x] == str2[y]) {
                dp[x][y] = LCS(x-1, y-1) + 1;
            }
            //같지 않다면 dp[x-1][y]와 dp[x][y-1]증 큰 값으로 초기화
            else {
                dp[x][y] = Math.max(LCS(x-1, y), LCS(x, y-1));
            }
        }
        return dp[x][y];
    }
}
