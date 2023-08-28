public class b5_transformToSumTree {
    
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
   
    static int transform(node root){
        if(root == null){
            return 0;
        }
        
        int lChild = transform(root.left);
        int rChild = transform(root.right);
        int data = root.data;

        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;
       
        root.data = lChild + newLeft + rChild + newRight;
        
        return data;
    }
    static void preOrder(node root){
        if(root == null ){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
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

        transform(root);
        preOrder(root);
    }

}
