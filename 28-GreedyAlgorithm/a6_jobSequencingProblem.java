import java.util.ArrayList;
import java.util.Collections;

public class a6_jobSequencingProblem {
    static class job{
        int deadLine; 
        int profit;
        int id;
        
        public job(int d, int p, int i){
            this.deadLine=d;
            this.profit=p;
            this.id=i;
        }
    }
    public static void main(String[] args) {
        int jobsInfo[][] = {{4,20},{1,10},{1,40},{1,30}};

        ArrayList<job> jobs = new ArrayList<>();
        for(int i=0; i<jobsInfo.length; i++){
            jobs.add(new job(jobsInfo[i][0],jobsInfo[i][1],i));
        }
        // descending
        Collections.sort(jobs,(obj1,obj2)->obj2.profit-obj1.profit);

        ArrayList<Integer> ans = new ArrayList<>();
        int time=0;

        for(int i=0; i<jobs.size(); i++){
            job curr = jobs.get(i);

            if(curr.deadLine>time){ 
                // 1>0?yes 1>1?no 4>1?yes 1>2?no
                ans.add(curr.id);
                time++;
            }
        }
        // print ans
        System.out.println(ans);
        for(int i=0; i<ans.size(); i++){
            System.out.print(ans.get(i)+" ");
        }
    }
}
