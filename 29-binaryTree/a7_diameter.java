public class a7_diameter {
    // max nodes from leaf node to leaf node

    static class node{
        int data; 
        node left;
        node right;

        public node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    static class binaryTree{
        static int idx=-1;
        
        public node build(int nodes[]){
            idx++;
            
            if(nodes[idx]==-1){
                return null;
            }
            node newNode = new node(nodes[idx]);
            newNode.left = build(nodes);
            newNode.right = build(nodes);

            return newNode;
        }
    }
   
    static void preOrder(node root){
        
        if(root == null){
            System.out.print("-1 ");
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }
    
    static int ht(node root){
        
        if(root == null){
            return 0;
        }
        int lht = ht(root.left);
        int rht = ht(root.right);

        return Math.max(lht , rht)  + 1;
    }
    
    static int diam2(node root){
        if(root == null){
            return 0;
        }
        int ld = diam2(root.left);
        int lht = ht(root.left);
        int rd = diam2(root.right);
        int rht = ht(root.right);

        return Math.max(Math.max(ld,rd) , lht+rht+1);
    }
    
    static class info{
        int di;
        int ht;

        public info(int d, int h){
            this.di = d;
            this.ht = h;
        }
    }
    static info diam(node root){

        if(root == null){
            return new info(0,0);
        }
        
        info linfo = diam(root.left);
        info rinfo = diam(root.right);


        int diam = Math.max(Math.max(linfo.di,rinfo.di), linfo.ht + rinfo.ht + 1);
        int ht = Math.max(linfo.ht, rinfo.ht) + 1;

        return new info(diam,ht);
    }
    public static void main(String[] args) {
        int nodes[] = {1,2,4,8,9,-1,-1,-1,-1,5,-1,6,-1,7,-1,-1,3,-1,-1}; //7
        // int nodes2[] = {1,2,4,8,-1,-1,-1,5,-1,6,-1,7,-1,-1,3,-1,-1}; //6


    //           1
    //          / \
    //         2   3
    //        / \   
    //       4   5   
    //      /     \
    //     8       6
    //    /         \
    //    9          7

        binaryTree bt = new binaryTree();
        node root = bt.build(nodes);
        // preOrder(root);
        System.out.println();

        // System.out.println(root.data);
        System.out.println(diam(root).di);

    }
}
