public class a1_fibonacchiRec {
    public static int fib(int n){
        if(n==0 || n==1) {
            return n;
        }
        return fib(n-1) + fib(n-2);
    }
    public static void printFibSeries(int n){
        System.out.print("Fibonacchi Series for n[" + n + "] ==> ");
        for(int i=0; i<n; i++){
            System.out.print(fib(i) + " ");
        }
    }
    public static void main(String args[]){
        int n=5;
        System.out.println("fib at idx[" + n + "] ==> " + fib(n));
        printFibSeries(n);
    }
}
