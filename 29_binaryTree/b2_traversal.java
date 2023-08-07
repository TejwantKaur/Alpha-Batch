import java.util.*;

public class b2_traversal {

    static class node{
        int data;
        node left; node right;

        public node(int data){
            this.data = data;
            this.left = null; this.right = null;
        }
    }

    static class binaryTree{
        static int idx = -1;

        public node build(int[] nodes){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }

            node newNode = new node(nodes[idx]);
            newNode.left = build(nodes);
            newNode.right = build(nodes);

            return newNode;
        }
    }

    static class traversing{
        private void preOrder(node rootNode) {
        if(rootNode == null){
            return;
        }

        System.out.print(rootNode.data + " ");
        preOrder(rootNode.left);
        preOrder(rootNode.right);
        }
        
        private void inOrder(node rootNode) {
            if(rootNode == null){
                return;
            }

            inOrder(rootNode.left);
            System.out.print(rootNode.data + " ");
            inOrder(rootNode.right);
        }
        
        private void postOrder(node rootNode) {
            if(rootNode == null){
                return;
            }

            postOrder(rootNode.left);
            postOrder(rootNode.right);
            System.out.print(rootNode.data + " ");
        }
        
        private void levelOrder(node rootNode){
            
            if(rootNode == null){
                return;
            }

            Queue<node> q = new LinkedList<>();

            q.add(rootNode);
            q.add(null);

            while(!q.isEmpty()){
                node currNode = q.remove();
                if(currNode == null){
                    System.out.println();
                    
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data + " ");
                    if(currNode.left!=null){
                        q.add(currNode.left);
                    }
                    if(currNode.right!=null){
                        q.add(currNode.right);
                    }
                }
            }
        }
    }
    

    public static void main(String args[]){
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        binaryTree tree = new binaryTree();
        node rootNode = tree.build(nodes);

        traversing print = new traversing();
        print.preOrder(rootNode);
        System.out.println();

        print.inOrder(rootNode);
        System.out.println();

        print.postOrder(rootNode);
        System.out.println();

        print.levelOrder(rootNode);
        System.out.println();
    }

    
    
}
