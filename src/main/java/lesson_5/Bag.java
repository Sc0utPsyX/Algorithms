package lesson_5;

public class Bag {
    private final int weight;

    public Bag() {
        this.weight = (int) (Math.random() * 100);
    }

    @Override
    public String toString() {
        return "Bag{" +
                "weight=" + weight +
                '}';
    }

    public int getWeight() {
        return weight;
    }
}
