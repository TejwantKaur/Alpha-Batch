import java.util.ArrayList;

public class b2_lowestCommonAncestor {

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
    
    static boolean getPath(node root, int n, ArrayList<node> path){
        if(root==null){
            return false;
        }
        path.add(root);
        
        if(root.data == n){
            return true;
        }
        boolean findLeft = getPath(root.left, n, path);
        boolean findRight = getPath(root.right, n, path);

        if(findLeft || findRight){
            return true;
        }
        
        path.remove(path.size()-1);
        return false;
    }
    
    static node lca (node root, int n1, int n2){
        ArrayList<node> path1 = new ArrayList<>();
        ArrayList<node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        // lca
        int i=0;
        for(; i<path1.size() && i<path2.size(); i++){
            if(path1.get(i) != path2.get(i)){
                break;
            }
        }
        // return last equal node
            return path1.get(i-1);
    }
    static node lca2 (node root, int n1, int n2){
        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }

        node leftLca = lca2(root.left, n1, n2);
        node rightLca = lca2(root.right, n1, n2);

        if(leftLca == null){
            return rightLca;
        }
        if(rightLca == null){
            return leftLca;
        }

        return root;
    }
    public static void main(String[] args) {
        
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

        System.out.println(lca2(root2, 5, 4).data);
    }
    
}
