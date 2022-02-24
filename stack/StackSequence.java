package stack;
import java.util.Scanner;
public class StackSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = scanner.nextInt();
        int[] stack = new int[N];
        int idx = 0;
        int startNum = 0;
        for(int i=0; i<N; i++) {
            int num = scanner.nextInt();
            if(num > startNum) {
                for(int j=startNum+1; j<=num; j++) {
                    stack[idx] = j;
                    idx++;
                    sb.append('+').append('\n');
                }
                startNum = num;
            }
            else if(stack[idx-1] != num) {
                System.out.println("NO");
                return;
            }
            idx--;
            sb.append('-').append("\n");
        }
        System.out.println(sb);
    }
}
