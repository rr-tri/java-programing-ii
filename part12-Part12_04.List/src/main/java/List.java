/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rr
 * @param <T>
 */
public class List<T> {

    private T[] values;
    private int firstFreeIdx;

    public List() {
        this.values = (T[]) new Object[10];
        this.firstFreeIdx = 0;
    }

    public int indexOfValue(T value) {
        for (int i = 0; i < this.firstFreeIdx; i++) {
            if (this.values[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    private void moveToTheLeft(int fromIndex) {
        for (int i = fromIndex; i < this.firstFreeIdx - 1; i++) {
            this.values[i] = this.values[i + 1];
        }
    }

    public void add(T value) {
        if (this.firstFreeIdx == this.values.length) {
            grow();
        }

        this.values[this.firstFreeIdx] = value;
        this.firstFreeIdx++;
    }

    public void grow() {
        int newSize = this.values.length + this.values.length / 2;
        T[] newValues = (T[]) new Object[newSize];
        for (int i = 0; i < this.values.length; i++) {
            newValues[i] = this.values[i];
        }
        this.values = newValues;
    }

    public boolean contains(T value) {
        return indexOfValue(value) >= 0;
    }

    public void remove(T value) {
        int indexOfValue = indexOfValue(value);
        if (indexOfValue < 0) {
            return; // not found
        }
        moveToTheLeft(indexOfValue);
        this.firstFreeIdx--;
    }

    public T value(int index) {
        if (index < 0 || index >= this.firstFreeIdx) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " outside of [0, " + this.firstFreeIdx + "]");
        }
        return this.values[index];
    }

    public int size() {
        return this.firstFreeIdx;
    }

}
