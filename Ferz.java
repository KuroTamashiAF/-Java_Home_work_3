

public class Ferz {
    static int size = 8;
    static int board[][]= new int [size][size];

    public static void main(String[] args) {
        
        checkPosition(board, 0,0 );
        solve(board, 0);
        for (int i = 0;i<board.length;i++){
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]);
                if(j==board.length-1){
                    System.out.println();
                }
                
            }
        }

        
    }
    
    public static boolean checkPosition(int[][] board, int row, int column) {
        // проверка строки
        for (int i = 0; i < column; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }
        //проверка по диагонали вверх
        for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
       //проверка по диагонали вниз
        for (int i = row + 1, j = column - 1; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean solve(int[][] board, int column) {
        if (column >= board.length) {
            return true;
        }

        for (int i = 0; i < board.length; i++) {
            if (checkPosition(board, i, column)) {
                
                board[i][column] = 1;
                if (solve(board, column + 1)) {
                    return true;
                }
                board[i][column] = 0;
            }
        }
        return false;
    }

}