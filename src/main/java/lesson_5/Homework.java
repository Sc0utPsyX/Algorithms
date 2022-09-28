package lesson_5;

public class Homework {
    public static void main(String[] args) {
        System.out.println(powRecursion(2,5));
        System.out.println(powRecursion(2,6));
        System.out.println(powRecursion(2,7));
        System.out.println(powRecursion(2,8));

    }

    public static long powRecursion(long number, int degree){
        if (degree < 1){
            return 1;
        }
        return number * powRecursion(number, degree - 1);
    }

}

