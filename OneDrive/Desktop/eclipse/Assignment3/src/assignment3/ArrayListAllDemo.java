package assignment3;
import java.util.*;

public class ArrayListAllDemo {
    public static void main(String[] args) {

        // 1. Constructor: ArrayList()
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("Java");
        list1.add("Python");
        list1.add("C++");
        System.out.println("List1: " + list1);

        // 2. Constructor: ArrayList(int capacity)
        ArrayList<String> list2 = new ArrayList<>(5);
        list2.add("HTML");
        list2.add("CSS");
        System.out.println("List2: " + list2);

        // 3. Constructor: ArrayList(Collection c)
        ArrayList<String> list3 = new ArrayList<>(list1);
        System.out.println("List3 (copy of list1): " + list3);

        // 1. add(index, element)
        list1.add(1, "JavaScript");
        System.out.println("After add at index: " + list1);

        // 2. addAll()
        list1.addAll(list2);
        System.out.println("After addAll(): " + list1);

        // 3. get()
        System.out.println("Element at index 2: " + list1.get(2));

        // 4. set()
        list1.set(0, "Core Java");
        System.out.println("After set(): " + list1);

        // 5. remove(index)
        list1.remove(1);
        System.out.println("After remove(index): " + list1);

        // 6. remove(object)
        list1.remove("CSS");
        System.out.println("After remove(object): " + list1);

        // 7. size()
        System.out.println("Size of list: " + list1.size());

        // 8. isEmpty()
        System.out.println("Is list empty? " + list1.isEmpty());

        // 9. contains()
        System.out.println("Contains Python? " + list1.contains("Python"));

        // 10. indexOf()
        System.out.println("Index of Python: " + list1.indexOf("Python"));

        // 11. lastIndexOf()
        list1.add("Python");
        System.out.println("Last index of Python: " + list1.lastIndexOf("Python"));

        // 12. iterator()
        System.out.print("Using Iterator: ");
        Iterator<String> it = list1.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // 13. toArray()
        Object[] arr = list1.toArray();
        System.out.print("Using toArray(): ");
        for (Object o : arr) {
            System.out.print(o + " ");
        }
        System.out.println();

        // 14. clear()
        list3.clear();
        System.out.println("After clear(), list3: " + list3);

        // 15. isEmpty() after clear (already counted above, but shown again)
        System.out.println("Is list3 empty? " + list3.isEmpty());
    }
}
