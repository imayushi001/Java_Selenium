package assignment3;
import java.util.*;

public class HashMapDemo {
    public static void main(String[] args) {

        // 1. HashMap()
        HashMap<Integer, String> map1 = new HashMap<>();
        map1.put(1, "Java");
        map1.put(2, "Python");
        map1.put(3, "C++");
        System.out.println("map1: " + map1);

        // 2. HashMap(int initialCapacity)
        HashMap<Integer, String> map2 = new HashMap<>(5);
        map2.put(10, "HTML");
        map2.put(20, "CSS");
        System.out.println("map2: " + map2);

        // 3. HashMap(int initialCapacity, float loadFactor)
        HashMap<Integer, String> map3 = new HashMap<>(3, 0.75f);
        map3.put(100, "One");
        map3.put(200, "Two");
        map3.put(300, "Three");
        System.out.println("map3: " + map3);

        // 4. HashMap(Map m)
        HashMap<Integer, String> map4 = new HashMap<>(map1);
        System.out.println("map4 (copy of map1): " + map4);

        // putIfAbsent()
        map1.putIfAbsent(4, "JavaScript");
        System.out.println("After putIfAbsent(): " + map1);

        // get()
        System.out.println("Value of key 2: " + map1.get(2));

        // remove(key)
        map1.remove(3);
        System.out.println("After remove(3): " + map1);

        // remove(key, value)
        map1.remove(4, "JavaScript");
        System.out.println("After remove(key,value): " + map1);

        // containsKey()
        System.out.println("Contains key 1? " + map1.containsKey(1));

        // containsValue()
        System.out.println("Contains value Python? " + map1.containsValue("Python"));

        // size()
        System.out.println("Size of map1: " + map1.size());

        // isEmpty()
        System.out.println("Is map2 empty? " + map2.isEmpty());

        // keySet()
        System.out.println("Keys of map1: " + map1.keySet());

        // values()
        System.out.println("Values of map1: " + map1.values());

        // entrySet()
        System.out.println("Entry set of map1: " + map1.entrySet());

        // replace(key, value)
        map1.replace(1, "Core Java");
        System.out.println("After replace(): " + map1);

        // putAll()
        map1.putAll(map2);
        System.out.println("After putAll(map2): " + map1);

        // clear()
        map3.clear();
        System.out.println("After clear(), map3: " + map3);
    }
}
