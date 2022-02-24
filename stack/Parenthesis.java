package stack;
import java.util.Scanner;
public class Parenthesis {
    public static int T;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();
        for(int i=0; i<T; i++) {
            System.out.println(parenthesis(scanner.next()));
        }
    }
    public static String parenthesis(String s) {
        int top = 0;
        int[] arr = new int[s.length()];
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            //arr=>스택, '('=>push, ')'=>pop
            if(c == '(') {
                arr[top] = 1;
                top++;
            }
            else if(c == ')') {
                top--;
                if(top<0) {
                    return "NO";
                }
                arr[top] = 0;
            }
        }
        //한글자씩 검사를 마치고 top이 첫 위치로 돌아오면 YES
        if(top == 0) {
            return "YES";
        }
        else {
            return "NO";
        }
    }
}
