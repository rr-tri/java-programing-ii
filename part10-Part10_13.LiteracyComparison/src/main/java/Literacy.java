/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rr
 */
public class Literacy implements Comparable<Literacy> {

    private final String country;
    private final int year;
    private final double literacyRate;
    private final String gender;

    public Literacy(String country, String gender, int year, double literacyRate) {
        this.country = country;
        this.year = year;
        this.literacyRate = literacyRate;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return this.country + " (" + this.year
                + "), " + this.gender + ", " + this.literacyRate;
    }

    @Override
    public int compareTo(Literacy t) {
        return Double.compare(this.literacyRate, t.literacyRate);
    }

}
