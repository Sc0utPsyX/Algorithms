package lesson_3;

import java.util.concurrent.atomic.AtomicReference;

public class Homework {
    public static void main(String[] args) {

        int[] array = {1, 2 ,3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16};
        int[] array0 = {1, 2 ,3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16};
        int[] array2 = {1, 2, 4, 5, 6};
        int[] array3 = {2, 3, 4, 5, 6, 7, 8};
        int[] array4 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        int[] array100 = new int[100000000];
        for (int i = 0; i < array100.length; i++) {
            array100[i] = i + 1;
        }
        array100[20000562] = 1666;
        int[] array5 = {};
        System.out.println(missingNumber(array));
        System.out.println(missingNumber(array0));
        System.out.println(missingNumber(array2));
        System.out.println(missingNumber(array3));
        System.out.println(missingNumber(array4));
        System.out.println(missingNumber(array5));
        System.out.println(missingNumber(array100));
        System.out.println();
        // Далее второй вариант: при больших массивах я попробовал искать с середины. Тут еще можно
        // реализовать разделение на большее количество потоков если нужно. И схему я вижу ту же,
        // что как только один из потоков находит верное число, он убивает остальных.
        // но тут по скорости, чтот-то у меня прироста не получилось..
        AtomicReference<Integer> number = new AtomicReference<>(0);
        Thread[] threads = new Thread[2];
        threads[0] = new Thread(() -> {
            if (array100[0] != 1) {
                try{
                    threads[1].interrupt();
                    number.set(1);
                }
                catch (RuntimeException e){
                    e.printStackTrace();
                }
            } else {
            number.set(missingNumberThreads(array100, true));
            if (number.get() > 1) {
                try{
                    threads[1].interrupt();
                }
                catch (RuntimeException e){
                    e.printStackTrace();
                }
            }
        }});
        threads[1] = new Thread(() -> {
            int miss = missingNumberThreads(array100, false);
            if (miss > array100.length) {
            } else {
            number.set(miss);
            if (number.get() > 1) {
                try {
                    threads[0].interrupt();
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
            }
        }});
        threads[0].start();
        threads[1].start();
        try {
            threads[0].join();
            threads[1].join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(number);
    }


    public static int missingNumber(int[] array){
        int missedNumber = 1, i = 0;
        try{
            while(array[i] == missedNumber){
                i++;
                missedNumber++;
            }
        }
        catch (ArrayIndexOutOfBoundsException e){
            if (missedNumber == array.length + 1) return missedNumber;
            return 1;
        }
        return missedNumber;
    }

    public static int missingNumberThreads(int[] array, boolean way) {
        int missedNumber = (array.length / 2) + 1, i = array.length / 2;
        if (way) {
            try {
                while (array[i] == missedNumber) {
                    i--;
                    missedNumber--;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                return 1;
            }
        }
        else {
            try {
            while (array[i] == missedNumber) {
                i++;
                missedNumber++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            if (missedNumber == array.length + 1) return missedNumber;
            return 1;
        }
        }
        return missedNumber;
    }
}

