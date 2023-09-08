import java.util.HashMap;

public class a9_lengthOfLargestSubArrayWithSum0 {
    public static void main(String[] args) {
        HashMap<Integer,Integer> map=new HashMap<>();
        // sum idx
        int sum=0; int len=0;
        // int[] arr={15,-2,2,-8,1,7,10,23};
        int []arr={3,4,5};

        for(int j=0; j<arr.length; j++){
            sum+=arr[j];
            if(map.containsKey(sum)){
                len=Math.max(len,j-map.get(sum)); //j(currIdx)-newIdx
            }
            else {
                map.put(sum,j);
            }
        }
        System.out.println("Largest length subarray of length " + len);
    }
}
