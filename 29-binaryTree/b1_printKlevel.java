public class b1_printKlevel {
    
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

    static void printKlevel(node root, int lvl, int k){
        if (root == null){
            return;
        }
        if(lvl == k){
            System.out.print(root.data + " ");
            return;
        }
        printKlevel(root.left, lvl+1, k);
        printKlevel(root.right, lvl+1, k);
    }
    public static void main(String args[]){
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

        int k=3;
        printKlevel(root,1,k);
    }
    
}
