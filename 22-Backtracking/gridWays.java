public class gridWays {
    public static int ways(int i, int j, int rows, int cols){
        // Base Case
        if(i==rows && j==cols){
            return 1;
        }
        else if(i > rows || j > cols){ // boundary
            return 0;
        }

        int w1 = ways(i+1,j,rows,cols);
        int w2 = ways(i, j+1, rows, cols);

        return w1+w2;
    }

    public static void main(String args[]){
        int rows = 3, cols = 3;
        System.out.println(ways(0,0,rows-1,cols-1));
    }
    
}
