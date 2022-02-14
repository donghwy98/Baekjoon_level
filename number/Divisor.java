package number;
import java.util.Arrays;
import java.util.Scanner;
public class Divisor {
    public static int n;
    public static int[] divisors;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        divisors = new int[n];
        for(int i=0; i<n; i++) {
            divisors[i] = scanner.nextInt();
        }
        System.out.println(findN());
    }
    //1과 N을 받지 않으므로
    //약수들 중 최솟값과 최댓값을 곱하면 N
    private static int findN() {
        Arrays.sort(divisors);
        int min = divisors[0];
        int max = divisors[n-1];
        return min*max;
    }
}
