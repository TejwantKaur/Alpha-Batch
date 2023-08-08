public class Main {

    static class node{
        int data;
        node left;
        node right;

        public node(int d){
            this.data = d;
            this.left = null;
            this.right = null;
        }
    }
    public static void main(String[] args) {

        //           1                   
        //         /   \                
        //        2     3              
        //       / \   / \
        //      4   5 6   7

        node root = new node(1);
        root.left = new node(2);
        root.left.left = new node(4);
        root.left.right = new node(5);
        root.right = new node(3);
        root.right.left = new node(6);
        root.right.right = new node(7);

        //          1                   
        //         / \                
        //        2   3              
        //       / \   \
        //      4   5   6

        node root2 = new node(1);
        root2.left = new node(2);
        root2.left.left = new node(4);
        root2.left.right = new node(5);
        root2.right = new node(3);
        root2.right.right = new node(6);

    }
}