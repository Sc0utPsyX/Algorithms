package lesson_2;

public class Notebook {
    double price;
    int ram;
    Brand brand;

    public Notebook() {
        this.price = Price.getRandom().getI();
        this.ram = Ram.getRandom().getI();
        this.brand = Brand.getRandom();
    }

    public static Notebook[] makeArray(int size){
        Notebook[] notebooks = new Notebook[size];
        for (int i = 0; i < notebooks.length; i++) {
            notebooks[i] = new Notebook();
        }
        return notebooks;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "price=" + price +
                ", ram=" + ram +
                ", brand=" + brand +
                '}';
    }

}
