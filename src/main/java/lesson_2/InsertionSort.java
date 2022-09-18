package lesson_2;

import java.util.Comparator;

public class InsertionSort {

    public static <T> void sort(T[] array, Comparator<T> comparator) {
        for (int i = 1; i < array.length; i++) {
            int j = i - 1;
            T value = array[i];
            while (j >= 0 && comparator.compare(array[j], value) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = value;
        }
    }
}



