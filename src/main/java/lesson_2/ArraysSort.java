package lesson_2;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysSort {
    public static void main(String[] args) {
        Notebook[] notebooks = Notebook.makeArray(10000);
        Arrays.sort(notebooks, new Comparator<Notebook>() {
            @Override
            public int compare(Notebook o1, Notebook o2) {
                return o1.price < o2.price ? -1 : o1.price == o2.price ? 0 : 1;
            }
        });
        Arrays.sort(notebooks, Comparator.comparingInt(o -> o.ram));
        Arrays.sort(notebooks, (o1, o2) -> o1.brand.compareTo(o2.brand));
        InsertionSort.sort(notebooks, Comparator.comparingInt(o -> o.ram));
        for (Notebook n: notebooks) {
            System.out.println(n.toString());
        }
    }
}
// Что-то как-то просто получилось.. Но сорт в классе Аррейс очень крутой

