/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rr
 */
public class Book implements Comparable<Book> {

    private final String name;
    private final int age;

    public Book(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return this.name;
    }
    
    public int getAge(){
        return this.age;
    }
    @Override
    public String toString() {
        return this.name + " (recommended for " + this.age + " year-olds or older)";
    }

    @Override
    public int compareTo(Book t) {
       int ageCompare = this.age - t.getAge();
       if(ageCompare != 0){
           return ageCompare;
       }
       return this.name.compareTo(t.getName());
    }

}
