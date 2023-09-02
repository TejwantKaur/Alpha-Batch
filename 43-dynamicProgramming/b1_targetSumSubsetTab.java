public class b1_targetSumSubsetTab {

    static boolean targetSum(int items[], int sum){
        int n=items.length; int m=sum;
        boolean dp[][] = new boolean [n+1][m+1];

        for(int i=0; i<n+1; i++){
            dp[i][0]=true;
        } 
        // i=items, j=sum
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                int val=items[i-1]; // i-1=0
                // include val<W & W-wt
                if(val<=j && dp[i-1][j-val]==true){
                    dp[i][j] = true;
                }
                // exclude
                else if(dp[i-1][j]==true){
                    dp[i][j] = true;
                }
            }
        }
        print(dp);
        return dp[n][m];
    }
    public static void print(boolean[][] dp){
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int arr[] = {6,7,5,6};
        int tarSum = 9;

        System.out.println(targetSum(arr,tarSum));
    }
}
