/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingapp.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mjaramin
 */
public class Parking {
    
    private String name;
    private int carSlots;
    private int motorbikeSlots = 15;
    private int bicycleSlots;

    public List<Vehicle> vehicles;
    
    public Parking(){
    //default constructor
    }
    
    public Parking(String name, int carSlots, int bicycleSlots) {
        this.vehicles = new ArrayList();
        this.name = name;
        this.carSlots = carSlots;
        this.bicycleSlots = bicycleSlots;
    }    
    
    public Parking(String name, int carSlots, int motorbikeSlots, int bicycleSlots) {
        this.vehicles = new ArrayList();
        this.name = name;
        this.carSlots = carSlots;
        this.motorbikeSlots = motorbikeSlots;
        if(bicycleSlots>10){ System.out.println("Your didnt enter allowed amount for bicycle slots, we setup 10"); this.bicycleSlots = 10; }
        else {this.bicycleSlots = bicycleSlots;}        
    }

    public boolean entryRequest(Vehicle vehicle){
        boolean result = false;
        if ( vehicle.getClass().isAssignableFrom(Car.class) ) {
            if( this.carSlots!=0 )
            {
                this.carSlots--;  
                announceCorrectResult(Car.class.getName() , this.carSlots);
                return true;
            } else {
            announceIncorrectResult(Car.class.getName());
            }
        } 
        
        if ( vehicle.getClass().isAssignableFrom(Bicycle.class) ) {
            if( this.bicycleSlots!=0 )
            {
                this.bicycleSlots--;
                announceCorrectResult(Bicycle.class.getName() , this.bicycleSlots);
                return true;
            } else {
            announceIncorrectResult(Bicycle.class.getName());
            }
        } 
        
        if ( vehicle.getClass().isAssignableFrom(MotorBike.class) ) {
            if( this.motorbikeSlots!=0 )
            { 
                this.motorbikeSlots--; 
                announceCorrectResult(MotorBike.class.getName() , this.motorbikeSlots);
                return true;
            } else {
            announceIncorrectResult(MotorBike.class.getName());
            }
        } 
        
        return result;
    }    
        
    public void announceCorrectResult(String kind , int currentSlots){      
        System.out.println("Im the parking : " + this.getName() + " and I just let enter a vehicle of kind : " + kind.substring(kind.lastIndexOf('.') + 1) + ". Only "+ currentSlots +" slots for this kind of vehicle");
    }
    
    public void announceIncorrectResult(String kind){
       System.out.println("Im the parking : " + this.getName() + " and I just kicked a vehicle of kind : " + kind.substring(kind.lastIndexOf('.') + 1));        
    }
 
    public void announceColourCount(String colour){
        System.out.println("Im the parking : " + this.getName() + " and i have "+ countColour(colour) + " of colour " + colour);
    }
    
    public long countColour(String colour){
    return vehicles.stream().filter( (Vehicle vehicle) -> { return colour.equals(vehicle.getColour());} ).count();    
    }
    
    public String getName() {
        return name;
    }

    public int getCarSlots() {
        return carSlots;
    }

    public int getMotorbikeSlots() {
        return motorbikeSlots;
    }

    public int getBicycleSlots() {
        return bicycleSlots;
    }
    
    
    
}
