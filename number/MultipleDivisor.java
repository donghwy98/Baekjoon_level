package number;
import java.util.Scanner;
public class MultipleDivisor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            if (num1 == 0 && num2 == 0)
                break;
            //num1이 num2의 약수인 경우
            if (num2 % num1 == 0)
                System.out.println("factor");
            //num1이 num2의 배수인 경우
            else if(num1 % num2 == 0)
                System.out.println("multiple");
            else
                System.out.println("neither");
        }
    }
}
