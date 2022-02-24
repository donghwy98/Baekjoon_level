package stack;
import java.util.Scanner;
public class Balance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String s;
        while(true) {
            s = scanner.nextLine();
            if(s.equals(".")) {
                break;
            }
            sb.append(balance(s)).append("\n");
        }
        System.out.println(sb);
    }
    private static String balance(String s) {
        char[] arr = new char[s.length()];
        int top = 0;
        for(char c : s.toCharArray()) {
            if(c == '(' || c == '[') {
                arr[top] = c;
                top++;
            }
            else if(c == ')') {
                if(top == 0 || arr[top-1] != '(') {
                    return "no";
                }
                else {
                    top--;
                }
            }
            else if(c == ']') {
                if(top == 0 || arr[top-1] != '[') {
                    return "no";
                }
                else {
                    top--;
                }
            }
        }
        if(top == 0) {
            return "yes";
        }
        else {
            return "no";
        }
    }
}
