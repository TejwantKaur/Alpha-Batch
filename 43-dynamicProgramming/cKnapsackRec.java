public class cKnapsackRec {
    private static int maxProfit(int[] val, int[] wt, int W, int idx) {
        if(idx==0 || W == 0) {
            return 0;
        }
        // valid
        int n = idx-1;
        if(wt[n] <= W) {
            // include
            int ans1 = val[n] + maxProfit(val, wt, W - wt[n], n);
            // exclude
            int ans2 = maxProfit(val, wt, W, n);
            return Math.max(ans1, ans2);
        }
        // not-valid
        return maxProfit(val, wt, W, n);
    }
    public static void main(String[] args) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2 ,5 ,1 ,3 ,4};
        int W = 7;

        System.out.println(maxProfit(val, wt, W, val.length));
    }
}
