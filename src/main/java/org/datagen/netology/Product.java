package org.datagen.netology;

public class Product {
    String name;
    int count;
    int price;

    public Product() {
    }

    public Product(String name, int count, int price) {
        this.name = name;
        this.count = count;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " " + count + " шт " + (price / count) + " руб/шт " + price + " руб в сумме";
    }
}
