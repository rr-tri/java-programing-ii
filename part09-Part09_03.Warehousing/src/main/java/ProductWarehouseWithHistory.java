/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rr
 */
public class ProductWarehouseWithHistory extends ProductWarehouse {

    private final ChangeHistory history;

    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);
        this.history = new ChangeHistory();
        this.history.add(initialBalance);
        super.setBalance(initialBalance);
    }

    @Override
    public void addToWarehouse(double amount) {
        super.addToWarehouse(amount);
        this.history.add(getBalance());
    }

    @Override
    public double takeFromWarehouse(double amount) {
        double taken = super.takeFromWarehouse(amount);
        this.history.add(getBalance());
        return taken;
    }

    public void printAnalysis() {
        System.out.println("Product: "+ super.getName());
        System.out.println("History: " + this.history.toString());
        System.out.println("Largest amount of product: " + this.history.maxValue());
        System.out.println("Smallest amount of product: " + this.history.minValue());
        System.out.println("Average: "+ this.history.average());

    }

    public String history() {
        return this.history.toString();
    }
}
