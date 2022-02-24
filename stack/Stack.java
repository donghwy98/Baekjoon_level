package stack;
import java.util.Scanner;
public class Stack {
    public static int[] stack;
    public static int size = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = scanner.nextInt();
        stack = new int[N];
        for(int i=0; i<N; i++) {
            String command = scanner.next();
            switch(command) {
                case "push":
                    push(scanner.nextInt());
                    break;
                case "pop":
                    sb.append(pop()).append("\n");
                    break;
                case "size":
                    sb.append(size()).append("\n");
                    break;
                case "empty":
                    sb.append(empty()).append("\n");
                    break;
                case "top":
                    sb.append(top()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
    public static void push(int num) {
        stack[size] = num;
        size++;
    }
    public static int pop() {
        if(size==0) {
            return -1;
        }
        else {
            int num = stack[size-1];
            stack[size-1] = 0;
            size--;
            return num;
        }
    }
    public static int size() {
        return size;
    }
    public static int empty() {
        if(size==0) {
            return 1;
        }
        else {
            return 0;
        }
    }
    public static int top() {
        if(size==0) {
            return -1;
        }
        else {
            return stack[size-1];
        }
    }
}
