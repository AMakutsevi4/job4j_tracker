package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        for (int i = index; i < products.length; i++) {
            if (i + 1 < products.length) {
                products[i] = products[i + 1];
            } else {
                products[products.length - 1] = null;
            }
        }
        return products;
    }
}