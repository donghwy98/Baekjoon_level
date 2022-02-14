package number;
import java.util.Scanner;
public class SpotCheck {
    public static int N;
    public static int[] arr;
    public static int tmpGcd;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = scanner.nextInt();
        }
        /**
         * 임의의 두 정수 A1과 A2가 있고,
         * "나누었을 때 나머지가 같은 M"을 구하려면
         *    A1=(a1*M)+r, A2=(a2*M)+r
         *    A1-A2 = (a1-a2)*M
         *    M은 A1-A2의 약수(=A1과 A2의 공약수)
         *
         * ex) 6, 34, 38에서 M을 구하려면
         *     |6-34| = 28
         *     |34-38| = 4
         *     28과 4의 공약수를 구하면 됨
         */
        findM();
    }
    private static void findM() {
        tmpGcd = Math.abs(arr[0]-arr[1]);
        for(int i=2; i<N; i++) {
            tmpGcd = gcd(tmpGcd, Math.abs(arr[i]-arr[i-1]));
        }
        for(int i=2; i<=tmpGcd; i++) {
            if(tmpGcd%i == 0) {
                System.out.print(i+" ");
            }
        }
    }
    private static int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b, a%b);
    }
}
