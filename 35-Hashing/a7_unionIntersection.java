import java.util.HashSet;

public class a7_unionIntersection{
    
    public static void main(String[] args) {
        int[] arr1={7,3,9};
        int[] arr2={6,3,9,2,9,4};

        HashSet<Integer> hs = new HashSet<>();

        // union
        for(int i=0; i<arr1.length; i++){
            hs.add(arr1[i]);
        }
        for(int i=0; i<arr2.length; i++){
            hs.add(arr2[i]);
        }

        System.out.println(hs);
        hs.clear();

        for(int i=0; i<arr1.length; i++){
            hs.add(arr1[i]);
        }

        int count = 0;
        System.out.print("[ ");
        for(int i=0; i<arr2.length; i++){
            int num = arr2[i];
            
            if(hs.contains(num)){
                count++;
                System.out.print(num + " ");
                hs.remove(num);
            }
        }
        System.out.println("]");

        System.out.println("intersection="+count);

    }
}