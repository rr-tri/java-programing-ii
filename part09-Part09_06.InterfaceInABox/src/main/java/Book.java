/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rr
 */
public class Book implements Packable{
    private final String Author;
    private final String name;
    private final Double weight;
    public Book(String Author, String name, double weight) {
        this.Author = Author;
        this.name = name;
        this.weight = weight;
    }
    

    @Override
    public double weight() {
       return this.weight;
    }
    @Override
    public String toString() {
        return this.Author+": "+this.name;
    }
}
