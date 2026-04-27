/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javier.ejercicios_programacion;

/**
 *
 * @author Jav
 */
class Operacion {
    double suma;
    double x;
    double y;
        
    public void calcular(){
        suma = 0;
        x = 20;
        suma = suma + x;

        y = 40;
        x = x + Math.pow(y, 2);

        suma = suma + x/y;
    }
    public void mostrar () {

        System.out.print("El valor de la suma es: " + suma);
    }
}
public class Ejercicio_5 {
    

    
    public static void main(String[] args) {
        
        Operacion suma = new Operacion();
        
        suma.calcular();
        suma.mostrar();
    
    }
}
