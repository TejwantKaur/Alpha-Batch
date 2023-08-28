// Queues element half one one element
import java.util.*;

public class a7_interleaveTwoHalves {
    
    static void interleave(Queue<Integer> q){
        Queue<Integer> firstHalf = new LinkedList<>();

        int size=q.size() /2;

        // here cant write q.size, as after every iteration size decreases, 
        // so we saved size first and then now using;
        for(int i=0; i<size; i++){
            firstHalf.add(q.remove());
        }

        while(!firstHalf.isEmpty()){
            q.add(firstHalf.remove());
            q.add(q.remove());
        }

        while(!q.isEmpty()){
            System.out.print(q.remove()+"->");
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        interleave(q);
    

    }
}
