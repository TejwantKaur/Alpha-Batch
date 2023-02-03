public class Sudoku {
    public static void print(int sudoku[][]){
        
        for(int i=0; i<sudoku.length; i++){
            for(int j=0; j<sudoku[0].length; j++){
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isValidMove(int[][] board, int row, int col, int val){
        for(int i=0; i<board.length; i++){
            if(board[i][col] == val || board[row][i] == val){
                return false;
            }
        }

        int sr = (row/3)*3;
        int sc = (col/3)*3;

        for(int i=sr; i<sr+3; i++){
            for(int j=sc; j<sc+3; j++){
                if(board[i][j] == val){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean solveSudoku(int[][] sudoku, int row, int col){
        
        if(col == sudoku[0].length){
            col = 0; 
            row++;
        }
        if(row == sudoku.length){
            return true;
        }

        if(sudoku[row][col] != 0){
            return solveSudoku(sudoku,row,col+1);
        }

        for(int i=1; i<=9; i++){

            if(isValidMove(sudoku,row,col,i)){
                sudoku[row][col] = i;

                if(solveSudoku(sudoku,row,col+1)){
                    return true;
                }
            }
            sudoku[row][col] = 0;
        }

        return false;    
    }

    public static void main (String args[]){
        int sudoku[][] = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0}, 
            {6, 0, 0, 1, 9, 5, 0, 0, 0}, 
            {0, 9, 8, 0, 0, 0, 0, 6, 0}, 
            {8, 0, 0, 0, 6, 0, 0, 0, 3}, 
            {4, 0, 0, 8, 0, 3, 0, 0, 1}, 
            {7, 0, 0, 0, 2, 0, 0, 0, 6}, 
            {0, 6, 0, 0, 0, 0, 2, 8, 0}, 
            {0, 0, 0, 4, 1, 9, 0, 0, 5}, 
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        

        if(solveSudoku(sudoku,0,0)){
            System.out.println("Solution Exists");
            print(sudoku);
        }else{
            System.out.println("Solution does'nt exists");
        }
    }
}
