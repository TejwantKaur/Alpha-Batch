public class Permutation {
    public static void findPer(String str, String ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            String newStr = str.substring(0,i) + str.substring(i+1, str.length());
            findPer(newStr,ans+ch); 
        }

    }
    public static void main(String args[]){
        String str = "abc";
        findPer(str,"");
    }
    
}
