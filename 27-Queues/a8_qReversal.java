import java.util.*;

public class a8_qReversal {
    static void qRev(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();

        while(!q.isEmpty()){
            s.push(q.remove());
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        }

    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);

        
        qRev(q);
        
        while(!q.isEmpty()){
            System.out.print(q.remove()+"->");
        }
        System.out.println("null");
    }
}
