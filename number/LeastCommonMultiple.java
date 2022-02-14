package number;
import java.util.Scanner;
public class LeastCommonMultiple {
    public static int T;
    public static int[] A;
    public static int[] B;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();
        A = new int[T];
        B = new int[T];
        for(int i=0; i<T; i++) {
            A[i] = scanner.nextInt();
            B[i] = scanner.nextInt();
        }
        for(int i=0; i<T; i++){
            //최대공약수
            int tmp = gcd(A[i], B[i]);
            //두 수를 곱하고 최대공약수로 나누면 최소공배수
            System.out.println(A[i]*B[i]/tmp);
        }
    }
    private static int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b,a%b);
    }
}
