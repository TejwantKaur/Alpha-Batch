public class a1_buildTree {
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
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        //       1
        //      / \
        //     2   3
        //    / \   \
        //   4   5   6
        //  / \
        // -1 -1

        binaryTree bt = new binaryTree();
        node root = bt.build(nodes);
        System.out.println(root.data);

    }
}
