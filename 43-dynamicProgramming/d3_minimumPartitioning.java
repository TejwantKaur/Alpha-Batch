public class d3_minimumPartitioning{

    static int minPar(int[]arr){
        int n=arr.length;
        
        int sum=0;
        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
        }
        int W=sum/2;
        int dp[][] = new int[n+1][W+1];

        // bottom-up
        for(int i=1; i<n+1; i++){
            for(int j=1; j<W+1; j++){
                // valid
                int wt=arr[i-1];
                if(wt<=j){
                    int ans1=wt+dp[i-1][j-wt];
                    int ans2=dp[i-1][j];
                    dp[i][j]=Math.max(ans1,ans2);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        int sum1=dp[n][W];
        int sum2=sum-sum1;
        return Math.abs(sum1-sum2);
    }
    public static void main(String[] args) {
        int nums[] = {1,6,11,5};
        System.out.println(minPar(nums));
    }
}