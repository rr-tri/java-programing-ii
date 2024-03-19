
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import javax.smartcardio.Card;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rr
 */
public class Employees {

    private List<Person> employees;

    public Employees() {
        this.employees = new ArrayList<>();
    }

    public void add(Person personToAdd) {
        this.employees.add(personToAdd);
    }

    public void add(List<Person> peopleToAdd) {
        peopleToAdd.stream()
                .forEach(person -> this.employees.add(person));
    }

    public void print() {
        Iterator<Person> iterator = this.employees.iterator();

        while (iterator.hasNext()) {
            Person nextInLine = iterator.next();
            System.out.println(nextInLine);
        }
    }

    public void print(Education education) {

        Iterator<Person> iterator = this.employees.iterator();

        while (iterator.hasNext()) {
            Person nextInLine = iterator.next();
            if(nextInLine.getEducation().equals(education)){
            System.out.println(nextInLine);
            }
        }

    }

    public void fire(Education education) {

        this.employees = this.employees.stream()
                .filter(p -> !p.getEducation().equals(education))
                .collect(Collectors.toList());
    }

}
