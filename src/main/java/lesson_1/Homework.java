package lesson_1;

import java.util.*;

public class Homework {
    static int c = 0;

    public static void main(String[] args) {
    Homework h = new Homework();
        System.out.println("a " + h.aAlgorithm(10000) + " vs " + h.aAlgorithm(100000));
        System.out.println("b " + h.bAlgorithm(10000) + " vs " + h.bAlgorithm(20000));
        System.out.println("c " + h.cAlgorithm(10000) + " vs " + h.cAlgorithm(100000));
        System.out.println(dAlgorithm(11));
        System.out.println(c);
        c = 0;
        System.out.println(dAlgorithm(12));
        System.out.println(c);
        c = 0;
        System.out.println(dAlgorithm(13));
        System.out.println(c);
    }


    public int aAlgorithm(int n){
        int counter = 0;
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j *= 2) {
                counter++;
                arrayList.add(i * j);
            }
        }
        return counter;
    }

    public int bAlgorithm(int n){
        int counter = 0;
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i += 2) {
            for (int j = i; j < n; j++) {
                counter++;
                arrayList.add(i * j);
            }
        }
        return counter;
    }

    public int cAlgorithm(int n){
        int counter = 0;
        int lastN = 0;
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j++) {
                arrayList.add(i * j);
                lastN = n;
                n--;
                counter++;
            }
            System.out.println(lastN);
        }
        System.out.println(arrayList.size());
        return counter;
    }

    public static int dAlgorithm(int n){
        if (n == 1) {
            c++;
            return n;
        }
        c++;
        return n * dAlgorithm(n - 1);
    }
}

