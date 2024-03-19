
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rr
 */
public class ChangeHistory {

    private final ArrayList<Double> history;

    public ChangeHistory() {
        this.history = new ArrayList<>();
    }

    public void add(double status) {
        history.add(status);
    }

    public void clear() {
        history.clear();
    }

    public double maxValue() {
        if (this.history.isEmpty()) {
            return 0;
        }
        double max = this.history.get(0);
        for (Double d : history) {
            if (d > max) {
                max = d;
            }
        }
        return max;
    }

    public double minValue() {
        if (this.history.isEmpty()) {
            return 0;
        }
        double min = this.history.get(0);
        for (Double d : history) {
            if (d < min) {
                min = d;
            }
        }
        return min;
    }

    public double average() {
        if (this.history.isEmpty()) {
            return 0;
        }
        double sum = 0;
        
        sum = history.stream().map((d) -> d).reduce(sum, (accumulator, _item) -> accumulator + _item);
        
        return sum/this.history.size();
    }

    @Override
    public String toString() {
        return history.toString();
    }

}
