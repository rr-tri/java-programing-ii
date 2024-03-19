
import java.util.HashMap;
import java.util.HashSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rr
 */
public class VehicleRegistry {

    private HashMap<LicensePlate, String> owners;

    public VehicleRegistry() {
        this.owners = new HashMap<>();
    }

    public boolean add(LicensePlate liPlate, String owner) {
        if (!this.owners.containsKey(liPlate)) {
            this.owners.put(liPlate, owner);
            return true;
        }
        return false;
    }

    public String get(LicensePlate liPlate) {
        return this.owners.getOrDefault(liPlate, null);
    }

    public boolean remove(LicensePlate liPlate) {
        if (this.owners.containsKey(liPlate)) {
            this.owners.remove(liPlate);
            return true;
        }
        return false;
    }

    public void printLicensePlates() {
        for (LicensePlate key : this.owners.keySet()) {
            System.out.println(key);
        }
    }

    public void printOwners() {
        HashSet<String> printedOwners = new HashSet<>();
        for (String value : this.owners.values()) {
            if (!printedOwners.contains(value)) {
                System.out.println(value);
                printedOwners.add(value);
            }
        }
    }

}
