public class b5_sumOfNodes {
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


    static int sumOfNodes(node root){
        if(root == null){
            return 0;
        }
        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);
        
        return leftSum+rightSum+root.data;
    }
    public static void main(String[] args) {
        // int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        
        int nodes2[] = {1,2,4,-1,-1,5,-1,6,-1,7,-1,-1,3,-1,-1};

        //       1
        //      / \
        //     2   3
        //    / \   \
        //   4   5   6
        //  / \
        // -1 -1

        binaryTree bt = new binaryTree();
        node root = bt.build(nodes2);
        
        System.out.println(sumOfNodes(root));
    }
    
}
