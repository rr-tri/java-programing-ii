
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
public class Box implements Packable{

    private final double capacity;
    private final ArrayList<Packable> items;

    public Box(double maximumCapacity) {
        this.capacity = maximumCapacity;
        this.items = new ArrayList<>();
    }

    public void add(Packable item) {
        if (item.weight() + this.weight() <= capacity) {
            this.items.add(item);
        }
    }

    @Override
    public double weight() {
        double weight = 0;
        weight = items.stream().map((item) -> item.weight()).reduce(weight, Double::sum);
        return weight;
    }

    @Override
    public String toString() {

        return "Box: " + this.items.size() + " items, total weight " + this.weight() + " kg";
    }

}
