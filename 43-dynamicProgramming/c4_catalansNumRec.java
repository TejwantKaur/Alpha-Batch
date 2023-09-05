public class c4_catalansNumRec {

    static int catRec(int n){
        if(n==0||n==1){
            return 1;
        }
        int ans=0;
        for(int i=0; i<n; i++){
            ans += catRec(i)*catRec(n-i-1);
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.print(catRec(4));
    }
    
}
