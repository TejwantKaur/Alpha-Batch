public class a4_htOfTree {
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

    static int height(node root){
        if(root == null){
            return 0;
        }

        int leftHt = height(root.left);
        int rightHt = height(root.right);

        return Math.max(leftHt, rightHt) + 1;
    }
    
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        // int nodes2[] = {1,2,4,-1,-1,5,-1,6,-1,7,-1,-1,3,-1,-1};

        //       1
        //      / \
        //     2   3
        //    / \   \
        //   4   5   6
        //  / \
        // -1 -1

        binaryTree bt = new binaryTree();
        node root = bt.build(nodes);
        
        System.out.println(height(root)); 
        
    }
}
