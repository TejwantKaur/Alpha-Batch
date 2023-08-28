import java.util.ArrayList;
import java.util.LinkedList;

public class a2_implementation{

    static class HashMap<K,V> {
        
        private class Node{
            K key;
            V value;

            public Node (K key, V val){
                this.key = key;
                this.value = val;
            }
        }
        private int N;
        private int n;
        private LinkedList<Node> buckets[];

        public HashMap(){
            this.N = 4;
            this.buckets = new LinkedList[4];

            for(int i=0; i<N; i++){
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunc(K key) {
            int hc = key.hashCode(); // can be -1234567 or 131469
            return Math.abs(hc)%N; //btw N and absolute(+ve)
        }

        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi]; // store
            int di=0;

            for(int i=0; i<ll.size(); i++){
                Node curr = ll.get(i);
                if(curr.key == key){
                    return di;
                }
                di++;
            }
            return -1;
        }
        
        private void rehash() {
            LinkedList<Node> oldBuck[] = buckets;
            buckets = new LinkedList[N*2];
            N*=2;
            
            for(int i=0; i<buckets.length; i++){
                buckets[i] = new LinkedList<>();
            }
            // add nodes in new bucket;
            for(int i=0; i<oldBuck.length; i++){
                LinkedList<Node> ll = oldBuck[i];

                for(int j=0; j<ll.size(); j++){
                    Node curr=ll.remove();
                    put(curr.key, curr.value);
                }
            }
        }

        public void put(K key, V value){
            int bi = hashFunc(key); // bucketIndex
            int di = searchInLL(key,bi); // dataIndex valid else -1(create) 
        
            if(di!=-1){
                Node curr = buckets[bi].get(di);
                curr.value = value;
            }else{
                buckets[bi].add(new Node (key,value));
                n++;
            }

            // rehash
            double lambda = n/N; // nodes/buckets.size
            if(lambda>2){
                rehash();
            }
        }

        public boolean containsKey(K key){
            int bi = hashFunc(key);
            int di = searchInLL(key, bi);

            if(di!=-1){
                return true;
            }
            else{
                return false;
            }
        }
        
        public V get(K key){
            int bi = hashFunc(key);
            int di = searchInLL(key, bi);

            if(di!=-1){
                Node curr = buckets[bi].get(di);
                return curr.value;
            }

            return null;
        } 

        public V remove(K key){
            int bi = hashFunc(key);
            int di = searchInLL(key, bi);

            if(di!=-1){
                Node curr = buckets[bi].remove(di);
                n--;
                return curr.value;
            }
            return null;
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();

            for(int i=0; i<buckets.length; i++){
                LinkedList<Node> ll = buckets[i];

                for(Node curr : ll){
                    keys.add(curr.key);
                }
            }
            return keys;
        }
        public static void main(String[] args) {
            
            HashMap<String,Integer>hm = new HashMap<>();
            hm.put("Amritsar",200);
            hm.put("Canada",70);
            hm.put("Nepal",50);
            hm.put("USA",120); 
            hm.put("India",100);
            hm.put("China",150);
            
            // System.out.println(hm);


            ArrayList<String> keys = hm.keySet();
            for (String s : keys) {
                System.out.print(s + " ");
            }
            System.out.println();
            System.out.println(hm.get("Amritsar"));
            System.out.println(hm.remove("Amritsar"));
            System.out.println(hm.get("Amritsar"));
        }
        
    } 
}