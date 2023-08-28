public class a2_circularArray {
    static class Queue{
        int arr[];
        int size;
        int rear;
        int front;

        Queue(int n){
            arr=new int[n];
            size=n;
            rear=-1;
            front=-1;
        }

        public boolean isEmpty(){
            return rear==-1 && front==-1;
        }

        public boolean isFull(){
            return (rear+1)%size==front;
        }

        public void add(int data){
            if(isFull()){
                System.out.println("Queue Full");
                return;
            }
            // add 1st Element
            if(front==-1){
                front=0;
            }
            rear=(rear+1)%size;
            arr[rear]=data;
        }

        public int peek(){
            if(isEmpty()){
                System.out.println("Queue Empty");
                return -1;
            }
            return arr[front];
        }

        public int remove(){
            if(isEmpty()){
                System.out.println("Queue Empty");
                return -1;
            }
            
            int res=arr[front];
            
            // delete last element
            if(rear==front){
                rear=front=-1;
            }
            else{
                front=(front+1)%size;
            }
            return res;
        }

    }
    public static void main(String[] args) {
        Queue q= new Queue(3);
        q.add(1); q.add(2); q.add(31);

        System.out.println(q.remove());
        System.out.println(q.remove());
        q.add(2); q.add(34);
        
        System.out.println(q.peek());

        while(!q.isEmpty()){
            System.out.print(q.remove()+" ");
        }
    }
}
