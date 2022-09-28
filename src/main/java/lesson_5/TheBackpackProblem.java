package lesson_5;

public class TheBackpackProblem {
    /**
     * Есть рюкзак, который вмещает x кг чего-то.
     * Есть n вещей. У каждой вещи есть ее вес p и стоимость q. p, q > 0.
     *
     * Требуется максимизировать сумарную стоимость с учетом не превышения сумарного веса.
     *
     * Найти самый дорогой вмещаемый набор.
     */
    public static void main(String[] args) {
        Item[] things = new Item[20];
        for (int i = 0; i < 20; i++) {
            things[i] = new Item();
        }
        for (int i = 0; i < 20 ; i++) {
            System.out.println(things[i].toString());
        }
        Bag bag = new Bag();
        System.out.println(bag);
        int i = backpack(things, things.length, bag.getWeight());
        System.out.println(i);
    }


    public static int backpack(Item[] items, int count, int bagWeight) {
        if (count <= 0) {
            return 0;
        } else if (items[count - 1].getiWeight() > bagWeight) {
            return backpack(items, count - 1, bagWeight);
        } else {
            return Math.max(backpack(items, count - 1, bagWeight),
                    items[count - 1].getPrice() + backpack(items, count - 1, bagWeight - items[count - 1].getiWeight()));
        }
    }

}
