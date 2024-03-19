
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rr
 */
public class ShoppingCart {

    private final Map<String, Item> items;

    public ShoppingCart() {
        this.items = new HashMap<>();
    }

    public void add(String product, int price) {
        if (this.items.containsKey(product)) {
            Item item = this.items.get(product);
            item.increaseQuantity();
            this.items.put(product, item);
        } else {
            Item item = new Item(product, 1, price);
            this.items.put(product, item);
        }

    }

    public int price() {
        int price = 0;
        return this.items.values().stream().map((value) -> value.price()).reduce(price, (accumulator, _item) -> accumulator + _item);
    }

    public void print() {
        this.items.values().forEach((value) -> {
            System.out.println(value);
        });
    }
}
