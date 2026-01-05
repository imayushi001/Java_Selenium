package assignment3;
import java.util.*;

public class VectorDemo {
    public static void main(String[] args) {

        // 1. Vector()
        Vector<String> v1 = new Vector<>();
        v1.add("Java");
        v1.add("Python");
        v1.add("C++");
        System.out.println("v1: " + v1);

        // 2. Vector(int initialCapacity)
        Vector<String> v2 = new Vector<>(5);
        v2.add("HTML");
        v2.add("CSS");
        System.out.println("v2: " + v2);

        // 3. Vector(int initialCapacity, int capacityIncrement)
        Vector<String> v3 = new Vector<>(3, 2);
        v3.add("One");
        v3.add("Two");
        v3.add("Three");
        System.out.println("v3: " + v3);
        System.out.println("v3 Capacity: " + v3.capacity());

        // 4. Vector(Collection c)
        Vector<String> v4 = new Vector<>(v1);
        System.out.println("v4 (copy of v1): " + v4);

        // add(int, element)
        v1.add(1, "JavaScript");
        System.out.println("After add at index: " + v1);

        // addElement()
        v1.addElement("Spring");
        System.out.println("After addElement(): " + v1);

        // get()
        System.out.println("Element at index 2: " + v1.get(2));

        // elementAt()
        System.out.println("Element at index 1: " + v1.elementAt(1));

        // set()
        v1.set(0, "Core Java");
        System.out.println("After set(): " + v1);

        // setElementAt()
        v1.setElementAt("Hibernate", 2);
        System.out.println("After setElementAt(): " + v1);

        // remove(index)
        v1.remove(1);
        System.out.println("After remove(index): " + v1);

        // removeElement()
        v1.removeElement("Spring");
        System.out.println("After removeElement(): " + v1);

        // size()
        System.out.println("Size of v1: " + v1.size());

        // capacity()
        System.out.println("Capacity of v1: " + v1.capacity());

        // contains()
        System.out.println("Contains Python? " + v1.contains("Python"));

        // indexOf()
        System.out.println("Index of Hibernate: " + v1.indexOf("Hibernate"));

        // iterator()
        System.out.print("Using Iterator: ");
        Iterator<String> it = v1.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // clear()
        v4.clear();
        System.out.println("After clear(), v4: " + v4);
    }
}
