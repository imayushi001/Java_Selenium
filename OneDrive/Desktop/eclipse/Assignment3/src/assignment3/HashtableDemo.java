package assignment3;
import java.util.*;

public class HashtableDemo {
    public static void main(String[] args) {

        // 1. Hashtable()
        Hashtable<Integer, String> ht1 = new Hashtable<>();
        ht1.put(1, "Java");
        ht1.put(2, "Python");
        ht1.put(3, "C++");
        System.out.println("ht1: " + ht1);

        // 2. Hashtable(int initialCapacity)
        Hashtable<Integer, String> ht2 = new Hashtable<>(5);
        ht2.put(10, "HTML");
        ht2.put(20, "CSS");
        System.out.println("ht2: " + ht2);

        // 3. Hashtable(int initialCapacity, float loadFactor)
        Hashtable<Integer, String> ht3 = new Hashtable<>(3, 0.75f);
        ht3.put(100, "One");
        ht3.put(200, "Two");
        ht3.put(300, "Three");
        System.out.println("ht3: " + ht3);

        // 4. Hashtable(Map m)
        Hashtable<Integer, String> ht4 = new Hashtable<>(ht1);
        System.out.println("ht4 (copy of ht1): " + ht4);

        // putIfAbsent()
        ht1.putIfAbsent(4, "JavaScript");
        System.out.println("After putIfAbsent(): " + ht1);

        // get()
        System.out.println("Value of key 2: " + ht1.get(2));

        // remove(key)
        ht1.remove(3);
        System.out.println("After remove(3): " + ht1);

        // containsKey()
        System.out.println("Contains key 1? " + ht1.containsKey(1));

        // containsValue()
        System.out.println("Contains value Python? " + ht1.containsValue("Python"));

        // size()
        System.out.println("Size of ht1: " + ht1.size());

        // isEmpty()
        System.out.println("Is ht2 empty? " + ht2.isEmpty());

        // keySet()
        System.out.println("Keys of ht1: " + ht1.keySet());

        // values()
        System.out.println("Values of ht1: " + ht1.values());

        // entrySet()
        System.out.println("Entry set of ht1: " + ht1.entrySet());

        // replace(key, value)
        ht1.replace(1, "Core Java");
        System.out.println("After replace(): " + ht1);

        // replace(key, oldValue, newValue)
        ht1.replace(2, "Python", "Django");
        System.out.println("After replace(key, oldValue, newValue): " + ht1);

        // clone()
        Hashtable<Integer, String> htClone = (Hashtable<Integer, String>) ht1.clone();
        System.out.println("Cloned ht1: " + htClone);

        // clear()
        ht3.clear();
        System.out.println("After clear(), ht3: " + ht3);
    }
}
