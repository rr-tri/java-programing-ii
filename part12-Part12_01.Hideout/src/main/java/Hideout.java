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
public class Hideout<T> {
    private T obj;

    public Hideout() {
        this.obj = null;
    }
    
    public void putIntoHideout(T toHide){
        this.obj = toHide;
    }
    
    public T takeFromHideout(){
        T object = this.obj;
        this.obj = null;
        return object;
    }
    
    public boolean isInHideout(){
        return this.obj != null;
    }
}
