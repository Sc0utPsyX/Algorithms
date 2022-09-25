package lesson_3;

import java.util.concurrent.atomic.AtomicReference;

public class Homework {
    public static void main(String[] args) {

        int[] array = {1, 2 ,3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15, 16};
        int[] array0 = {1, 2 ,3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16};
        int[] array2 = {1, 2, 4, 5, 6};
        int[] array3 = {2, 3, 4, 5, 6, 7, 8};
        int[] array4 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        int[] array5 = {};
        System.out.println(missingNumber(array));
        System.out.println(missingNumber(array0));
        System.out.println(missingNumber(array2));
        System.out.println(missingNumber(array3));
        System.out.println(missingNumber(array4));
        System.out.println(missingNumber(array5));
        System.out.println();
        System.out.println(startBinaryMissing(array));
        System.out.println(startBinaryMissing(array0));
        System.out.println(startBinaryMissing(array2));
        System.out.println(startBinaryMissing(array3));
        System.out.println(startBinaryMissing(array4));
        System.out.println(startBinaryMissing(array5));
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

    public static int startBinaryMissing(int[] array){
        try {
            if (array[0] != 1) return 1;
        } catch (ArrayIndexOutOfBoundsException e){
            return 1;
        }
        return binaryMissing(array, 0, array.length - 1);
    }


    private static int binaryMissing(int[] array, int posHead, int posTail){
        if (posHead + 1 == posTail) {
            if (array[posHead] + 1 == array[posTail]) return array[posTail] + 1;
            return array[posHead] + 1;
        }
        int nextHead = ((posTail - posHead) / 2) + posHead;
        if (nextHead + 1 == array[nextHead]) {
            return binaryMissing(array, nextHead, posTail);
        } else {
            return binaryMissing(array, posHead, nextHead);
        }
        }

    }

