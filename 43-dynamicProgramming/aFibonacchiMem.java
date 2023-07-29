public class aFibonacchiMem {
    public static int fibMem(int n, int dp[]){
        if(n==0 || n==1){
            return n;
        }
        if(dp[n] != 0) {
            return dp[n];
        }
        dp[n] = fibMem(n-1, dp) + fibMem(n-2, dp);
        return dp[n];

    }
    public static void main(String[] args) {
        int n=7;
        int dp[] = new int [n+1];
        System.out.println("fib at idx[" + n + "] ==> " + fibMem(n,dp));
//        printFibSeries(n);
    }
}
