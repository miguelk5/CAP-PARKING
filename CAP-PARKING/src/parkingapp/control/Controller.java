/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingapp.control;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import parkingapp.domain.Bicycle;
import parkingapp.domain.Car;
import parkingapp.domain.MotorBike;
import parkingapp.domain.Parking;
import parkingapp.domain.Vehicle;
import parkingapp.utils.Constants;
import parkingapp.utils.Numbers;

/**
 *
 * @author mjaramin
 */
public class Controller {
    
    public static List<Vehicle> createRoster(int amount, String kind){
    List<Vehicle> vehicles = new ArrayList();
    int count = 0 ;
    
    while ( count < amount){
    String colour = Constants.COLOURS[Numbers.randomWithRange(0, 3)];
    if ("CAR".equals(kind)){
        Car car = new Car(colour);
        vehicles.add(car);
    }
    if ("MOTORBYKE".equals(kind)){
        String mark = Constants.MARKS[Numbers.randomWithRange(0, 1)];
        MotorBike motor = new MotorBike(colour, mark);
        vehicles.add(motor);
    }
    if ("BICYCLE".equals(kind)){
        Bicycle bicy = new Bicycle(colour);
        vehicles.add(bicy);
    }
    
    count ++;
    }
    
    return vehicles;
    }
    
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        Parking myParking;
        
        String ParkingName= "CAP-PARKING";
        int carSlots;
        int motorBikeSlots;
        int BicycleSlots;
        int overSizeAmount = 1;
        String targetColour;
        
        if(args.length == 5){
            System.out.println("VMARGS found proceed:");
            ParkingName = args[0];
            carSlots = Integer.valueOf(args[1]);
            motorBikeSlots = Integer.valueOf(args[2]);
            BicycleSlots = Integer.valueOf(args[3]);                        
            targetColour = args[4];
            myParking = new Parking(ParkingName , carSlots , motorBikeSlots, BicycleSlots);
        }
        else {                
                Scanner reader = new Scanner(System.in);

                System.out.println("Please select max cars slots (Number between 1 and X) " );
                carSlots = reader.nextInt(); 

                System.out.println("OPTIONAL select max motorbikes slots (Number between 1 and 15) if not just press 0" );
                motorBikeSlots = reader.nextInt(); 

                System.out.println("Please select max bicycles slots (Number between 1 and 10) " );
                BicycleSlots = reader.nextInt();             
                
                System.out.println("Please enter your favourite color : (1 = BLACK , 2= WHITE , 3 = BLUE , 4 = PINK) " );       
                
                 switch (reader.nextInt()) {
                case 1:  targetColour = "BLACK";
                         break;
                case 2:  targetColour = "WHITE";
                         break;
                case 3:  targetColour = "BLUE";
                         break;
                case 4:  targetColour = "PINK";
                         break;
                default: targetColour = "BLACK";
                         break;
                }

            if(motorBikeSlots==0)
            {
                myParking = new Parking(ParkingName , carSlots , BicycleSlots);
            }  else {
                myParking = new Parking(ParkingName , carSlots , motorBikeSlots, BicycleSlots);
            }        
        }
        
        vehicles.addAll(createRoster(carSlots+overSizeAmount , "CAR"));
        vehicles.addAll(createRoster(motorBikeSlots+overSizeAmount , "MOTORBYKE"));
        vehicles.addAll(createRoster(BicycleSlots+overSizeAmount , "BICYCLE"));
        
        Scanner reader = new Scanner(System.in);
        
        System.out.println("Do you want suffle the vechicles list ? if no order will be CAR -> MOTORBYKE -> BICYCLE: -1 yes -2 no");
        if(reader.nextInt()==1){Collections.shuffle(vehicles);}        

        for( Vehicle vehicle: vehicles){
            if(myParking.getBicycleSlots()!= 0){
                Boolean result = myParking.entryRequest(vehicle);
                if (result) {myParking.vehicles.add(vehicle);}                
                vehicle.enterParking(result);
            }
            else { System.out.println("No more Bicycle slots we stop the program");break;}                
        }
           
        myParking.announceColourCount(targetColour);
        
        System.out.println("Do you want see the vehicles list in the parking ? : 1- yes 2-no ");
        if(reader.nextInt()==1){System.out.println(myParking.vehicles.toString());}
    }
}
