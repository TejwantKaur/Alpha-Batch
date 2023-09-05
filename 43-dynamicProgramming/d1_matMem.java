public class d1_matMem {

    static int mul(int[]arr, int i, int j, int dp[][]){
        if(i==j){
            return 0;
        }
        int ans = Integer.MAX_VALUE;

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        for(int k=i; k<j; k++){

            int cost1=mul(arr,i,k,dp);
            int cost2=mul(arr,k+1,j,dp);
            int cost3=arr[i-1]*arr[k]*arr[j];

            int finalCost=cost1+cost2+cost3;
            ans=Math.min(ans,finalCost);
        }
        return dp[i][j] = ans;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,3};
        int n=arr.length;

        int dp[][] = new int[n][n];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(mul(arr,1,n-1,dp));
    }
}
