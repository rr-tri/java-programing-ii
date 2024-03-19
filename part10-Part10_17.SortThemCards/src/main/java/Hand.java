
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rr
 */
public class Hand implements Comparable<Hand> {

    private List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }
    
    public void add(Card card){
        this.cards.add(card);
    }
    
    public void print(){
       this.cards.stream()
               .forEach(c->System.out.println(c));
    }
    public void sort(){
        Collections.sort(this.cards);
    }
    public int sum(){
       return  this.cards.stream()
               .mapToInt(c-> c.getValue())
               .sum();
    }
    @Override
    public int compareTo(Hand t) {
        return this.sum() - t.sum();
    }
    public void sortBySuit(){
        BySuitInValueOrder sortValue = new BySuitInValueOrder();
        Collections.sort(this.cards, sortValue);
    }
}
