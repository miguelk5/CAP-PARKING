/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingapp.domain;

import java.util.Objects;

/**
 *
 * @author mjaramin
 */
public class Vehicle {
    
    private String colour;

    public Vehicle() {
        // default constructor
    }    
    
    public Vehicle(String colour) {
        this.colour = colour;
    }
    
    public void enterParking(Boolean entered){
        if (entered) System.out.println("Great, I can enter in to the Parking");
        else System.out.println("Dammit!, I can't enter the parking");
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.colour);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehicle other = (Vehicle) obj;
        return true;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "colour=" + colour + '}';
    }
    
    
    
}
