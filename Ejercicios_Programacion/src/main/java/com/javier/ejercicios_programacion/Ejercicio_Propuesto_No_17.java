/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javier.ejercicios_programacion;

/**
 *
 * @author Jav
 */

class Radio {
    double r;
    
    public double area(){
        return Math.PI * Math.pow(r, 2);
    }
    public double longitud(){
        return 2 * Math.PI * r ;
    }
    
    public void mostrar(){
        System.out.println("Radio: " + r);
        System.out.println("Area: " + area());
        System.out.println("Longitud: " + longitud());
    }
}
public class Ejercicio_Propuesto_No_17 {
    
    public static void main(String[] args) {
        
        Radio radio_circulo = new Radio();
        radio_circulo.r = 2;
        radio_circulo.mostrar();
       
        
    }
    
}
