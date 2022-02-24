package stack;
import java.util.Scanner;
public class Zero {
    public static int K;
    public static int[] arr;
    public static int top = -1;
    public static int sum = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        K = scanner.nextInt();
        arr = new int[K];
        for(int i=0; i<K; i++) {
            int num = scanner.nextInt();
            if(num==0){
                //top이 가리키는 위치만 1 감소
                top--;
            }
            else {
                top++;
                arr[top] = num;
            }
        }
        for(int i=0; i<=top; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
    }
}
