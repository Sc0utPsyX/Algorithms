package lesson_5;

public class Item {

    private final int iWeight;
    private final int price;

    public Item() {
        this.iWeight = (int) (Math.random() * 10) + 1;
        this.price = (int) (Math.random() * 100);
    }

    @Override
    public String toString() {
        return "Thing{" +
                "Weight=" + iWeight +
                ", Price=" + price +
                '}';
    }
    public int getiWeight() {
        return iWeight;
    }

    public int getPrice() {
        return price;
    }
}
