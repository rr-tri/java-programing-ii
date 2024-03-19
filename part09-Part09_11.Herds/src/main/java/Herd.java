
import java.util.ArrayList;
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
public class Herd implements Movable {

    private List<Movable> organisms;

    public Herd() {
        this.organisms = new ArrayList<>();
    }

    @Override
    public String toString() {
        String l = "";
        l = organisms.stream().map((organism) -> organism.toString() + "\n").reduce(l, String::concat);
        return l;

    }

    public void addToHerd(Movable movable) {
        this.organisms.add(movable);
    }

    @Override
    public void move(int dx, int dy) {
        this.organisms.forEach((organism) -> {
            organism.move(dx, dy);
        });
    }

}
