public class subSets {
    public static void findSubsets(String str,int idx, String ans){
        if(idx==str.length()){
            if(ans.length()==0){
                System.out.println("null");
            }else{
                System.out.println(ans);
            }
            return;
        }
        // Yes Choice 
        findSubsets(str, idx+1, ans+str.charAt(idx));

        // No Choice
        findSubsets(str, idx+1, ans);
    }
    public static void main(String args[]){
        String str = "abc";
        findSubsets(str,0,"");
    }
    
}
