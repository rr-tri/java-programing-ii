/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rr
 */
public class CD implements Packable {

    private final String Artist;
    private final String name;
    private final int year;
    private final Double weight;

    public CD(String Artist, String name, int year) {
        this.Artist = Artist;
        this.name = name;
        this.year = year;
        this.weight = 0.1;
    }

    @Override
    public double weight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return this.Artist+": "+this.name+" ("+this.year+")";
    }
    
    
}
