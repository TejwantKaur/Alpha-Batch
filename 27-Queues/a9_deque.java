import java.util.*;

public class a9_deque {
    public static void main(String[] args) {
        Deque<Integer> dq = new LinkedList<>();
        dq.addFirst(2);
        dq.addFirst(3);
        dq.addLast(7);

        System.out.println(dq);
    }
}
