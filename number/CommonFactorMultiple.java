package number;
import java.util.Scanner;
public class CommonFactorMultiple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        System.out.println(gcd(num1, num2));
        System.out.println(lcm(num1, num2));
    }
    //최대공약수 구하는 방법
    private static int gcd(int num1, int num2) {
        if(num2==0)
            return num1;
        return gcd(num2, num1%num2);
    }
    //최소공배수 구하는 방법
    private static int lcm(int num1, int num2) {
        return num1 * num2 / gcd(num1, num2);
    }
}
