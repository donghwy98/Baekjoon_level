package number;
import java.util.Scanner;
public class FactorialZero {
    public static int N;
    public static int answer = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        /**
         * 뒷자리에 0이 n개 존재하면
         * 소인수분해 결과 2와 5가 n쌍 존재한다는 의미
         * (즉, 5의 개수에 따라 값이 변화)
         *   >> 5로 나누면서 누적합 계산
         */
        while(N >= 5) {
            answer += N/5;
            N /= 5;
        }
        System.out.println(answer);
    }
}
