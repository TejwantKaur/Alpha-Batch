import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class a1_activitySelection{
    public static void main(String[] args) {
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};

        int maxAct=0;
        ArrayList<Integer> ans = new ArrayList<>();

        // sorting
        int activities[][]=new int[start.length][3]; //idx, start, end
        for(int i=0; i<start.length; i++){
            activities[i][0]=i;
            activities[i][1]=start[i];
            activities[i][2]=end[i];
        }

        // lambda function
        Arrays.sort(activities,Comparator.comparingDouble(o->o[2]));
        
        // 1st-Activity
        // maxAct=1;
        // ans.add(0); //index;
        // int lastEndingTime=end[0];

        // for(int i=1; i<end.length; i++){
        //     if(start[i]>=lastEndingTime){
        //         maxAct++;
        //         ans.add(i);
        //         lastEndingTime=end[i];
        //     }
        // }

        maxAct=1;
        ans.add(activities[0][0]);
        int lastEndingTime=activities[0][2];

        for(int i=1; i<end.length; i++){
            if(activities[i][1]>=lastEndingTime){
                maxAct++;
                ans.add(activities[i][0]);
                lastEndingTime=activities[i][2];
            }
        }

        System.out.println(maxAct);

        for(int i=0; i<ans.size(); i++){
            System.out.print("A"+ans.get(i) +" ");
        }
    }
}