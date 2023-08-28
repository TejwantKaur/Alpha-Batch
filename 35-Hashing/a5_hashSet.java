import java.util.*;

public class a5_hashSet {
    public static void main(String[] args) {
        
        HashSet<String> cities = new HashSet<>();
        cities.add("China");
        cities.add("India");
        cities.add("USA");
        cities.add("Canada");
        cities.add("Amritsar");
        cities.add("Nepal");

        System.out.println(cities);

        Iterator it = cities.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
        System.out.println();
        
        for(String city : cities){
            System.out.print(city +" ");
        }
        System.out.println();

        System.out.println("------------LinkedHashSet------------");
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("China");
        lhs.add("India");
        lhs.add("USA");
        lhs.add("Canada");
        lhs.add("Amritsar");
        lhs.add("Nepal");

        System.out.println(lhs);

        System.out.println("------------TreeSet------------");
        TreeSet<String> ts = new TreeSet<>();
        ts.add("China");
        ts.add("India");
        ts.add("USA");
        ts.add("Canada");
        ts.add("Amritsar");
        ts.add("Nepal");

        System.out.println(ts);
    }
    
}
