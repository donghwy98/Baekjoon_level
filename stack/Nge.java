package stack;
import java.util.Scanner;
public class Nge {
    public static int N;
    public static int[] arr;
    public static int[] stack;
    public static int top = -1;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        arr = new int[N];
        stack = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = scanner.nextInt();
        }
        /**
         * 수열 arr를 앞에서부터 탐색하면서
         * ⅰ) 현재 원소가 이전의 원소보다 작으면 stack에 인덱스를 push
         * ⅱ) 현재 원소가 이전의 원소보다 크면,
         *    현재 원소보다 큰 수가 나올 때까지 stack의 원소를 pop하면서,
         *    pop된 인덱스에 해당하는 arr의 원소들을 현재 arr의 원소로 바꿔줌
         * ⅲ) 탐색이 끝났을때 stack에 저장된 인덱스의 의미는
         *     해당 위치의 arr 원소는 뒤에 큰 수가 없다는 것 => 모두 -1로 바꿔줌
         * ex) arr{9 5 4 8}
         *    idx=0) 9 → stack{0}, arr{9 5 4 8}
         *    idx=1) 9>5 → stack{0 1} arr{9 5 4 8}
         *    idx=2) 5>4 → stack{0 1 2} arr{9 5 4 8}
         *    idx=3) 4<8 → stack{0 1} arr{9 5 8 8}
         *                     arr[1]=5<8 → stack{0} arr{9 8 8 8}
         *                   arr[0]=9>8 → stack{0 3} arr{9 8 8 9}
         *    stack{0 3} → arr{-1 8 8 -1}
         */
        for(int i=0; i<N; i++) {
            while((top != -1) && (arr[stack[top]]<arr[i])) {
                arr[stack[top]] = arr[i];
                top--;
            }
            top++;
            stack[top] = i;
        }
        for(int i=top; i>=0; i--) {
            arr[stack[i]] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for(int n : arr) {
            sb.append(n).append(' ');
        }
        System.out.println(sb);
    }
}
