public class Queens {
    public static void print(char[][] board){
        System.out.println("---------Chess Board---------");
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static boolean isSafe(char[][] board, int row, int col){
        // vertical up
        for(int i=row-1; i>=0; i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        // up  left
        for(int i=row-1, j=col-1; i>=0 &&j>=0; i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        // up right
        for(int i=row-1, j=col+1; i>=0 && j<board.length; i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    static int count;
    // public static void sit(char[][] board, int row){
    //     if(row==board.length){
    //         print(board);
    //         count++;
    //         return;
    //     }

    //     // column loop
    //     for(int j=0; j<board.length; j++){
    //         if(isSafe(board,row,j)){
    //             board[row][j] = 'Q';
    //             sit(board,row+1);
    //             board[row][j] = 'x';
    //         }  
    //     }
    // } 
    
    public static boolean sit(char[][] board, int row){
        if(row==board.length){
            print(board);
            count++;
            return true;
        }

        // column loop
        for(int j=0; j<board[0].length; j++){
            if(isSafe(board, row, j)){
                board[row][j] = 'Q';
                if(sit(board, row+1)){
                    return true;
                }
                board[row][j] = 'x';
            }  
        }
        return false;
    }
    
    public static void main(String args[]){
        int n=4;
        char board[][] = new char[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.'; 
            }
        }
        sit(board,0);
        // System.out.println("Number of ways to place queen on " + n + "x" + n + " board=" + count);
    }
    
}
