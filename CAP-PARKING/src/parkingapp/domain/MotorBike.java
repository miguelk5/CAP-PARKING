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
public class MotorBike extends Vehicle{

    private String trademark;
    
    public MotorBike() {
        //default constructor
    }

    public MotorBike(String colour) {
        super(colour);
    }
    
    public MotorBike(String colour, String mark) {
        super(colour);
        this.trademark = mark;
    }
    
   @Override
    public void enterParking(Boolean entered){
        if (entered) System.out.println("YP! Mi colour is : "+ this.getColour() +" and I can enter in to the Parking");
        else System.out.println("Hey!, Im a " + this.getTrademark() + " and you will remember about this");
    }

    public String getTrademark() {
        return trademark;
    }

    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.trademark);
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
        final MotorBike other = (MotorBike) obj;
        if (!Objects.equals(this.trademark, other.trademark)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MotorBike{" + "trademark=" + trademark + " " + super.toString() + '}' + "\n";
    }
    
    
    
}
