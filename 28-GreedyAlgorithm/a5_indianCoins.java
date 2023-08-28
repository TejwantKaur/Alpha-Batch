import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class a5_indianCoins {
    public static void main(String[] args) {
        Integer coins[] = {1,2,5,10,20,50,100,500,1000,2000};
        Arrays.sort(coins,Comparator.reverseOrder());
        
        int count=0;
        int amt=3688;
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0; i<coins.length; i++){
            if(coins[i]<=amt){
                while(coins[i]<=amt){
                    count++;
                    ans.add(coins[i]);
                    amt-=coins[i];
                }
            }   
        }
        System.out.println(count);
        System.out.println(ans);
    }
}
