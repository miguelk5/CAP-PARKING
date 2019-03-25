/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingapp.utils;

/**
 *
 * @author mjaramin
 */
public class Numbers {
    
 public static int randomWithRange(int min, int max)
 {
    int range = (max - min) + 1;     
    return (int)(Math.random() * range) + min;
 }
 
}
