package number;
import java.util.Scanner;
public class BinomialCoefficient_1 {
    public static int N;
    public static int K;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();
        /**
         * (nk) = nCk = C(n,k) = n! / (n-k)!k!
         */
        System.out.println( factorial(N) / (factorial(N-K)*factorial(K)) );
    }

    private static int factorial(int N) {
        //0팩토리얼은 1
        if(N==0){
            return 1;
        }
        return N*factorial(N-1);
    }
}
