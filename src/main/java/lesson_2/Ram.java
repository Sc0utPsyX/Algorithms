package lesson_2;

public enum Ram {

    FOURTH (4),
    EIGHT(8),
    SIXTEEN(16),
    TWENTY(20),
    TWENTYFOUR(24);


    int ramCount;
    public static Ram getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }

    Ram(int i) {
        ramCount = i;
    }

    public int getI() {
        return ramCount;
    }

}
