import java.util.*;

public class a4_validAnagram{

    public static boolean isAnagram(String s1, String s2){

        HashMap<Character, Integer> hm  = new HashMap<>();
        for(int i=0; i<s1.length(); i++){
            Character ch = s1.charAt(i);
            hm.put(ch, hm.getOrDefault(ch,0)+1);
        }

        for(int i=0; i<s2.length(); i++){
            Character ch = s2.charAt(i);

            if(hm.get(ch) != null){  // n-->value(3)
                if(hm.get(ch)==1){
                    hm.remove(ch);
                }
                else{
                    hm.put(ch,hm.get(ch)-1);
                }
            }
            else{
                return false;
            }
        }

        return hm.isEmpty();  
    }
    public static void main(String[] args) {
        String s1 = "piut";
        String s2 = "tulip";

        boolean is = isAnagram(s1,s2);

        if(is == true){
            System.out.println("Valid");
        }
        else{
            System.out.println("Not Valid");
        }
    }
}