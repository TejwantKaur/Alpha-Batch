import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class a9_topView {

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

    static class info {
        node node;
        int hd;

        public info(node n, int h){
            this.node = n;
            this.hd = h;
        }
    }

    static void topViewFunc(node root){
        
        // levelOrder
        Queue <info> q = new LinkedList<>();
        HashMap<Integer, node> hm = new HashMap<>();
        int min=0, max=0;
        
        q.add(new info(root,0));
        q.add(null);

        while(!q.isEmpty()){
            info curr= q.remove();
            
            if(curr == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }
                q.add(null);
            }
            else{
                if(!hm.containsKey(curr.hd)){
                    hm.put(curr.hd, curr.node);
                }
                if(curr.node.left != null){
                    q.add(new info(curr.node.left, curr.hd-1));
                    min = Math.min(min,curr.hd-1);
                }
                if(curr.node.right != null){
                    q.add(new info(curr.node.right, curr.hd+1));
                    max = Math.max(max,curr.hd+1);
                }
            }

        }
        System.out.println(hm);

        for(int i=min; i<=max; i++){
            System.out.print(hm.get(i).data + " ");
        } 
    }

    public static void main(String args[]){

        //          1                   
        //         / \                
        //        2   3              
        //       / \   \
        //      4   5   6

        node root = new node(1);
        root.left = new node(2);
        root.left.left = new node(4);
        root.left.right = new node(5);
        root.right = new node(3);
        root.right.right = new node(6);

        node root2 = new node(1);
        root2.left = new node(2);
        root2.right = new node(3);
        root2.left.right = new node(4);
        root2.left.right.right = new node(5);
        root2.left.right.right.right = new node(6);
    

        topViewFunc(root2);
        // System.out.println(hm);
    }
    
}
