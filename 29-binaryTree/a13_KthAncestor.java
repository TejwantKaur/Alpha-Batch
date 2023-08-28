public class a13_KthAncestor {
    
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
    
    static int KthAnc(node root,int n, int k){
        if(root == null){
            return -1;
        }
        if(root.data == n){ return 0;}

        int lDis = KthAnc(root.left, n, k);
        int rDis = KthAnc(root.right, n, k);

        if(lDis == -1 && rDis == -1){
            return -1;
        }
        int max = Math.max(lDis, rDis);

        if(max+1 == k){
            System.out.println(root.data);
            // return root.data;
        }
        return max+1;
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

        KthAnc(root, 4, 1);
    }
}
