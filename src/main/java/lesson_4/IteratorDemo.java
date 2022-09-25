package lesson_4;

import java.util.*;

public class IteratorDemo {

    public static void main(String[] args) {
        Collection<Integer> coll = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        // [1 2 3 |4 5 6]

//        foreach(coll);
//        iterator(coll);
//        iteratorRemoveExample();
//        arrayForeach();

        LinkedList<Integer> customLinkedList = new LinkedListImpl<>();
        customLinkedList.addLast(1);
        customLinkedList.addLast(2);
        customLinkedList.addLast(3);
        customLinkedList.addLast(4);
        customLinkedList.addLast(5);
        // TODO: 22.09.2022 Реализовать итератор для связного списка.
        // TODO: 22.09.2022 Должно работать.
        for (Integer x : customLinkedList) {
            System.out.println(x);
        }

    }


}
