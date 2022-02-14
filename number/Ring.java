package number;
import java.util.Scanner;
public class Ring {
    public static int N;
    public static int[] rings;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        rings = new int[N];
        for(int i=0; i<N; i++) {
            rings[i] = scanner.nextInt();
        }
        spin();
    }
    private static void spin() {
        for(int i=1; i<N; i++) {
            int gcd = gcd(rings[0], rings[i]);
            System.out.println((rings[0]/gcd)+"/"+(rings[i]/gcd));
        }
    }
    private static int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b, a%b);
    }
}
