import java.util.Arrays;
public class a3_minAbsDiff {
    // Minimum Absolute Difference

    public static void main(String[] args) {
        int A[] = {1,4,7,8};
        int B[] = {2,3,6,5};
        // int ans=0;

        Arrays.sort(A); Arrays.sort(B);
        int minDiff=0;

        for(int i=0; i<A.length; i++){
            minDiff+=Math.abs(A[i]-B[i]);
        }
        System.out.println(minDiff);
    }
}
