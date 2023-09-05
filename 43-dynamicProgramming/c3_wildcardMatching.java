public class c3_wildcardMatching{

    static boolean isMatch(String s, String t){
        int n=s.length(); int m=t.length();
        boolean dp[][] = new boolean[n+1][m+1];

        dp[0][0]=true;

        // if t=empty col=0 
        for(int i=1; i<n+1; i++){
            dp[i][0]=false;
        }

        // s=empty
        for(int j=1; j<m+1; j++){
            if(t.charAt(j-1) == '*'){
                dp[0][j] = dp[0][j-1];
            }
        }

        // bottom-up
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(s.charAt(i-1)==t.charAt(j-1) || t.charAt(j-1) == '?'){
                    dp[i][j]=dp[i-1][j-1];
                } else if(t.charAt(j-1) == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                } else {
                    dp[i][j]=false;
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        String s="baaabab";
        String t="a*****ba*****ab";
        // ans=true;

        System.out.println(isMatch(s, t));

    }
}