/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingapp.domain;

/**
 *
 * @author mjaramin
 */
public class Car extends Vehicle{

    public Car() {
        //default constructor
    }

    public Car(String colour) {
        super(colour);
    }
    
    @Override
    public void enterParking(Boolean entered){
        if (entered) System.out.println("BROOM ! BROOM !, my colour is  :"+ this.getColour() +" and I can enter in to the Parking");
        else System.out.println("Dammit!, I can't enter the parking");
    }
    
}
