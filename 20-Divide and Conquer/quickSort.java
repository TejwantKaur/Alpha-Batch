public class quickSort {

    public static void print(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void qSort(int[] arr, int si, int ei){
        if(si >= ei){
            return;
        }
        // last element
        int idx = partition(arr,si,ei);
        qSort(arr,si,idx-1);
        qSort(arr,idx+1,ei);
    }

    public static int partition(int arr[], int si, int ei){
        int pivotElement = arr[ei];
        int i=si-1; // to make space

        for(int j=si; j<ei; j++){
            if(arr[j] <= pivotElement){
                i++;
                int temp =  arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }   
        }
        i++;
        int temp=arr[i];
        arr[i] = arr[ei];
        arr[ei] = temp;

        return i;
    }

    public static void main(String args[]){
        int arr[] = {9,5,2,-1,7,3};
        qSort(arr,0,arr.length-1);
        print(arr);
    }
}
