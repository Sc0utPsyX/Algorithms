package lesson_2;

public enum Brand {
    LENUVO,
    ASOS,
    MACNOTE,
    ESER,
    XAMIOU;

    public static Brand getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }

}
