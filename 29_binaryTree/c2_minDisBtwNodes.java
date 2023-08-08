public class c2_minDisBtwNodes {

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
    
    static int lcaDis(node root, int n){
        if(root == null){
            return-1;
        }
        if(root.data == n){
            return 0;
        }

        int lDis = lcaDis(root.left, n);
        int rDis = lcaDis(root.right, n);

        if(lDis ==-1 && rDis == -1){
            return -1;
        }
        else if(lDis == -1){
            return rDis + 1;
        }
        return lDis + 1;
    }
    static node lca(node root, int n1, int n2){
        if(root == null || root.data == n1 || root.data ==n2){
            return root;
        }

        node leftLca = lca(root.left, n1, n2);
        node rightLca = lca(root.right, n1, n2);

        if(leftLca == null){return rightLca;}
        if(rightLca == null){return leftLca;}

        // if(leftLca != null && rightLca != null)
        return root;
    }

    static int minDis(node root, int n1, int n2){
        node lca = lca(root, n1, n2);

        int dis1 = lcaDis(lca, n1);
        int dis2 = lcaDis(lca, n2);

        return dis1+dis2;
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
        root.right.right.left = new node(8);
    
        System.out.println(minDis(root, 8, 4));
    }
    
}
