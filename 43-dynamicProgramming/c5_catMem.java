import java.util.Arrays;

public class c5_catMem {

    static int catMem(int n, int[]dp){
        if(n==0||n==1){
            return 1;
        }
        
        if(dp[n] != -1){
            return dp[n];
        }
        
        int ans=0;
        for(int i=0; i<n; i++){
            ans += catMem(i,dp)*catMem(n-i-1,dp);
        }
        dp[n]=ans;
        return dp[n];
    }
    public static void main(String[] args) {
        int n=4;
        
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        
        System.out.println(catMem(n,dp));
        for(int i=0;i<dp.length; i++){
            System.out.print(dp[i] + " ");
        }
    }
    
}
