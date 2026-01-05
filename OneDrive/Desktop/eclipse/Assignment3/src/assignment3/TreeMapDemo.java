package assignment3;
import java.util.*;

public class TreeMapDemo {
    public static void main(String[] args) {

        // 1. TreeMap() default constructor
        TreeMap<Integer, String> tm1 = new TreeMap<>();
        tm1.put(3, "C++");
        tm1.put(1, "Java");
        tm1.put(2, "Python");
        System.out.println("tm1: " + tm1);

        // 2. TreeMap(Map m) constructor
        TreeMap<Integer, String> tm2 = new TreeMap<>(tm1);
        System.out.println("tm2 (copy of tm1): " + tm2);

        // 3. TreeMap(Comparator c) constructor (reverse order)
        TreeMap<Integer, String> tm3 = new TreeMap<>(Collections.reverseOrder());
        tm3.put(1, "One");
        tm3.put(2, "Two");
        tm3.put(3, "Three");
        System.out.println("tm3 (reverse order): " + tm3);

        // 4. TreeMap(SortedMap sm)
        TreeMap<Integer, String> tm4 = new TreeMap<>(tm1.subMap(1, 3));
        System.out.println("tm4 (subMap of tm1): " + tm4);

        // put()
        tm1.put(4, "JavaScript");
        System.out.println("After put(): " + tm1);

        // get()
        System.out.println("Value of key 2: " + tm1.get(2));

        // remove(key)
        tm1.remove(3);
        System.out.println("After remove(3): " + tm1);

        // containsKey()
        System.out.println("Contains key 1? " + tm1.containsKey(1));

        // containsValue()
        System.out.println("Contains value Python? " + tm1.containsValue("Python"));

        // size()
        System.out.println("Size of tm1: " + tm1.size());

        // isEmpty()
        System.out.println("Is tm2 empty? " + tm2.isEmpty());

        // keySet()
        System.out.println("Keys of tm1: " + tm1.keySet());

        // values()
        System.out.println("Values of tm1: " + tm1.values());

        // entrySet()
        System.out.println("Entry set of tm1: " + tm1.entrySet());

        // firstKey()
        System.out.println("First key of tm1: " + tm1.firstKey());

        // lastKey()
        System.out.println("Last key of tm1: " + tm1.lastKey());

        // ceilingKey()
        System.out.println("Ceiling key of 2: " + tm1.ceilingKey(2));

        // floorKey()
        System.out.println("Floor key of 2: " + tm1.floorKey(2));

        // clear()
        tm4.clear();
        System.out.println("After clear(), tm4: " + tm4);
    }
}
