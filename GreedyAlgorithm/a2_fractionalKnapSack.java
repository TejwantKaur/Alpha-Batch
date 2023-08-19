import java.util.Arrays;
import java.util.Comparator;

public class a2_fractionalKnapSack{

    static int findProfit(int[]val, int[]wt, int W){
        double ratio[][] = new double[val.length][2];
        for(int i=0; i<ratio.length; i++){
            ratio[i][0]=i; //idx
            ratio[i][1]=val[i]/(double)wt[i]; //ratio val/wt;
        }
        // ascendingOrder
        Arrays.sort(ratio,Comparator.comparingDouble(o->o[1]));
        // 4 5 6 
        
        int finalVal=0;
        for(int i=ratio.length-1; i>=0; i--){  // 6 5 4
            int idx = (int) ratio[i][0];
            if(W>=wt[idx]){
                // include fullItem
                finalVal+=val[idx];
                W-=wt[idx];
            }else{
                // include fractionalTerm
                finalVal+=(ratio[i][1]*W);
                W=0;
                break;
            }
        }
        return finalVal;
    }
    public static void main(String[] args) {

        int val[]={60,100,120};
        int wt[]={10,20,30};
        int W=50;
        
        int knap = findProfit(val,wt,W);
        System.out.println(knap);

    }
}