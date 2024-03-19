
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rr
 */
public class BySuitInValueOrder implements Comparator<Card> {

    @Override
    public int compare(Card c1, Card c2) {
        int suitComparison = c1.getSuit().ordinal() - c2.getSuit().ordinal();
        if (suitComparison != 0) {
            return suitComparison;
        }
        return c1.getValue() - c2.getValue();
    }
    
}
