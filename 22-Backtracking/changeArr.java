public class changeArr {
    public static void printArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void addValue(int[] arr, int idx, int val){
        if(idx == arr.length){
            printArr(arr);
            return;
        }
        arr[idx] = val;
        addValue(arr, idx+1, val+1); // recursive process
        arr[idx] = arr[idx]-2; // backtracking
    }
    public static void main(String args[]){
        int arr[] = new int [5];
        addValue(arr,0,1);
        printArr(arr);
    }
}
