package lesson_2;

public enum Price {

    ONE (100),
    TWO(200),
    THREE(300),
    FOUR(400),
    FIVE(500),
    SIX(600),
    SEVEN(700);


    int priceCount;
    public static Price getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }

    Price(int i) {
        priceCount = i;
    }

    public int getI() {
        return priceCount;
    }

}
