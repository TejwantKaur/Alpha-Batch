import java.util.Deque;
import java.util.LinkedList;

public class a11_queueUsingDq {
    static class Queue{
        Deque<Integer> dq = new LinkedList<>();

        public void add(int data){
            dq.addLast(data);
        }

        public int remove(){
            return dq.removeFirst();
        }

        public int peek(){
            return dq.getFirst();
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);

        System.out.println(q.peek());
        System.out.println(q.remove());
        System.out.println(q.remove());

    }
}
