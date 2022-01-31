package backtracking;
import java.util.Scanner;
public class Sudoku {

    public static int[][] arr = new int[9][9];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                arr[i][j] = scanner.nextInt();
            }
        }
        sudoku(0,0);
    }

    public static void sudoku(int row, int col) {
        //행이 다 채워졌으면 다음 행으로 이동
        if(col==9) {
            sudoku(row+1, 0);
            return;
        }
        //행과 열이 다 채워졌으면 출력
        if(row==9) {
            for(int i=0; i<9; i++) {
                for(int j=0; j<9; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
            //return을 하면 상위 메소드로 돌아가므로 exit으로 종료
            System.exit(0);
        }
        //0이면 가능한 수 탐색
        if(arr[row][col] == 0) {
            for(int num=1; num<=9; num++) {
                //중복되는 수 확인
                if(check(row, col, num)) {
                    arr[row][col] = num;
                    sudoku(row, col+1);
                }
            }
            //수를 채우고 확인하기 때문에 나중에 이상하면 0 다시 빠져나오면서 0으로 채움
            arr[row][col] = 0;
            return;
        }
        sudoku(row, col+1);
    }

    public static boolean check(int row, int col, int num) {
        //같은 행에서 겹치는지 확인
        for(int i=0; i<9; i++) {
            if(arr[row][i] == num) {
                return false;
            }
        }
        //같은 열에서 겹치는지 확인
        for(int i=0; i<9; i++) {
            if(arr[i][col] == num) {
                return false;
            }
        }
        //3*3칸에서 겹치는지 확인
        int mini_row = (row/3)*3; //속해있는 3*3의 첫 행
        int mini_col = (col/3)*3; //속해있는 3*3의 첫 행

        for(int i=mini_row; i<mini_row+3; i++) {
            for(int j=mini_col; j<mini_col+3; j++) {
                if(arr[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

}
