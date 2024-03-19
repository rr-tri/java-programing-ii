
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rr
 */
public class BoxWithMaxWeight extends Box {

    private int capacity;
    private ArrayList<Item> items;

    public BoxWithMaxWeight(int capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        int weight = 0;
        weight = items.stream().map((i) -> i.getWeight()).reduce(weight, Integer::sum);
        if (weight <= capacity && item.getWeight() + weight <= capacity) {
            
            items.add(item);
        }
    }

    @Override
    public boolean isInBox(Item item) {
        return items.contains(item);
    }
}
