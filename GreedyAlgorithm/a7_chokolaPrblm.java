import java.util.Arrays;
import java.util.Collections;

public class a7_chokolaPrblm {
    public static void main(String[] args) {
        // int rows=4;
        // int cols=6;

        Integer costVer[] = {2,1,3,1,4}; //cols-1
        Integer costHor[] = {4,1,2}; //rows-1

        Arrays.sort(costVer,Collections.reverseOrder());
        Arrays.sort(costHor,Collections.reverseOrder());

        int h=0, v=0; //horizontal, vertical cuts;
        int hp=1, vp=1; //pieces
        int cost=0;

        while(h < costHor.length && v < costVer.length){
            if(costVer[v]<=costHor[h]){
                // horizontalCut
                cost += costHor[h] * vp;
                hp++;
                h++;
            }
            else{
                // verticalcut
                cost += costVer[v] * hp;
                vp++; 
                v++;
            }   
        }
        while(h < costHor.length){
            cost += costHor[h] * vp;
            hp++;
            h++;
        }
        
        while(v<costVer.length){
            cost += costVer[v] * hp;
            vp++;
            v++;
        }

        System.out.println(cost);
    }
    
}
