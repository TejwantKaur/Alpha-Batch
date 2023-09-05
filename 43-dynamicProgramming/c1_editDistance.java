public class c1_editDistance {

    static int editOp(String s1, String s2){
        int n=s1.length(); int m=s2.length();

        int dp[][]=new int [n+1][m+1];
        for(int i=0; i<n+1; i++){
            for(int j=0; j<m+1; j++){
                if(i==0){
                    dp[i][j]=j;
                }
                if(j==0){
                    dp[i][j]=i;
                }
            }
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(s1.charAt(i)==s2.charAt(j)){
                    dp[i][j]=dp[i-1][j-1];
                } else {
                    int add=dp[i][j-1];
                    int sub=dp[i-1][j];
                    int rep=dp[i-1][j-1];
                    
                    dp[i][j]=Math.min(add,Math.min(sub,rep));
                }
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        String str1="abcdef";
        String str2="bdeg";

        System.out.println(editOp(str1,str2));
    }
}
