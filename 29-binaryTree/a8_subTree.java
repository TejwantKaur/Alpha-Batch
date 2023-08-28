public class a8_subTree {
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
    
    static boolean isIdentical(node root, node sub){
        if(root == null && sub == null){
            return true;
        }
        else if(root == null || sub == null || root.data != sub.data){
            return false;
        }
        if(!isIdentical(root.left, sub.left)){
            return false;
        }
        if(!isIdentical(root.right, sub.right)){
            return false;
        }
        return true;
    }
    
    static boolean isSubTree(node root, node sub){
        if(root == null){
            return false;
        }

        if(root.data == sub.data){
            if(isIdentical(root, sub)){
                return true;
            }
        }
        return isSubTree(root.left, sub) || isSubTree(root.right, sub);
    }
    public static void main(String[] args) {


        //          1                   2
        //         / \                 / \
        //        2   3               4   5
        //       / \   \
        //      4   5   6
        //     / \
        //    -1 -1


        node root = new node(1);
        root.left = new node(2);
        root.left.left = new node(4);
        root.left.right = new node(5);
        root.right = new node(3);
        root.right.right = new node(6);


        node sub = new node(2);
        sub.left = new node(4);
        sub.right = new node(5);


        System.out.println(isSubTree(root, sub));

    }
}
