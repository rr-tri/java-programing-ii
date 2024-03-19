
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rr
 */
public class StorageFacility {
    
    private HashMap<String, ArrayList<String>> storage;
    
    public StorageFacility() {
        this.storage = new HashMap<>();
    }
    
    public void add (String unit, String item){
        this.storage.putIfAbsent(unit, new ArrayList<>());
        this.storage.get(unit).add(item);
    }
    
    public ArrayList<String> contents(String storeUnit){
        return this.storage.getOrDefault(storeUnit, new ArrayList<>());
    }
    
    public void remove (String storeUnit, String item){
        
        if (this.storage.containsKey(storeUnit)) {
            ArrayList<String> items = storage.get(storeUnit);
            items.remove(item);
            if (items.isEmpty()) {
                storage.remove(storeUnit);
            }
        }
    }
    public ArrayList<String> storageUnits(){
       return new ArrayList<>(storage.keySet());
    }
}
