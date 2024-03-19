/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rr
 */
import java.util.Scanner;

public class Store {

    private final Warehouse warehouse;
    private final Scanner scanner;

    public Store(Warehouse warehouse, Scanner scanner) {
        this.warehouse = warehouse;
        this.scanner = scanner;
    }

    // the method that handles the customers visit to the store.
    public void shop(String customer) {
        ShoppingCart cart = new ShoppingCart();
        System.out.println("Welcome to the store " + customer);
        System.out.println("our selection:");

        this.warehouse.products().forEach((product) -> {
            System.out.println(product);
        });

        while (true) {
            System.out.print("What to put in the cart (press enter to go to the register): ");
            String product = scanner.nextLine();
            if (product.isEmpty()) {
                break;
            }

            int stock = this.warehouse.stock(product);
            if (stock > 0) {
                cart.add(product, this.warehouse.price(product));
                this.warehouse.take(product);
            }else{
                System.out.println("Sorry, Out of stock. You've selected available stock of "+ product);
            }

            // Add code here that adds the product to the cart,
            // If there is any in the warehouse, and reduces the stock in the warehouse
            // Don't touch any of the other code!
        }

        System.out.println("your shoppingcart contents:");
        cart.print();
        System.out.println("total: " + cart.price());
    }
}
