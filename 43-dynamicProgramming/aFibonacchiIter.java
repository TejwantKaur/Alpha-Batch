public class aFibonacchiIter {
    public static int fibIter(int n, int dp[]){
        dp[0] = 0; dp[1] = 1;

        for(int i=2; i<n+1; i++){
            dp[i] = dp[i-1] + dp[i-2];
            System.out.print(dp[i] + " ");
        }
        return dp[n];
    }
    public static void print(int dp[]){
        System.out.print("Fibonacchi Series ==> ");
        for (int i=0; i<dp.length; i++){
            System.out.print(dp[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 7;
        int dp[] = new int [n+1];
        System.out.println("fibIter at idx[" + n + "] ==> " + fibIter(n, dp));
        print(dp);
    }
}
