package lesson_4;

import lesson_4.LinkedListImpl.CustomListIterator;

import java.util.Iterator;

public class CustomLinkedListDemo {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedListImpl<>();
        System.out.println("Empty: " + list);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        System.out.println("Filled: " + list);
        list.addFirst(1);
        System.out.println("Filled: " + list);
        list.delete(2);
        System.out.println("Filled: " + list);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.addLast(8);
        System.out.println("Filled: " + list);
        System.out.printf("List last : %d, " +
                "List first: %d, " +
                "List index 5: %d\n", list.getLast(), list.getFirst(), list.get(5));
        for (Integer node : list) {
            System.out.println(node);
        }
        System.out.println("Filled: " + list);
        CustomListIterator customListIterator = (CustomListIterator) list.iterator();
        while (customListIterator.hasNext()) {
            customListIterator.remove(5);
        }
        System.out.println("Filled: " + list);
        CustomListIterator customListIterator2 = (CustomListIterator) list.iterator();
        while (customListIterator2.hasNext()) {
            customListIterator2.remove();
        }
        System.out.println("Filled: " + list);
    }

}
