package number;
import java.util.Scanner;
public class CombiZero {
    public static long N, M;
    public static long count5, count2;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextLong();
        M = scanner.nextLong();
        /**
         * nCm = n! / (n-m)!m!의 0의 개수는
         * 2와 5의 승수 중 겹치는 값(최솟값)
         */
        count5 = five_power_n(N) - five_power_n(N-M) - five_power_n(M);
        count2 = two_power_n(N) - two_power_n(N-M) - two_power_n(M);
        System.out.println(Math.min(count5, count2));
    }
    //5의 승수를 구하는 함수
    private static long five_power_n(long num) {
        int count = 0;
        while(num >= 5) {
            count += (num/5);
            num /=5;
        }
        return count;
    }
    //2의 승수를 구하는 함수
    private static long two_power_n(long num) {
        int count = 0;
        while(num >= 2) {
            count += (num/2);
            num /=2;
        }
        return count;
    }
}
