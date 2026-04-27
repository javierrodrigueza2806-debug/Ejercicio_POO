/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javier.ejercicios_programacion;

/**
 *
 * @author Jav
 */

class Numero {
    double valor;
    
    public double cuadrado(){
        return Math.pow(valor, 2);
    }
    
    public double cubo(){
        return Math.pow(valor, 3);
    }
    
    public void mostrar(){
        System.out.println("Numero: " + valor);
        System.out.println("Cuadrado: " + cuadrado());
        System.out.println("Cubo: " + cubo());
    }
}
public class Ejercicio_Propuesto_No_14 {
    
    public static void main(String[] args) {
        
        Numero n = new Numero();
        n.valor = 2;
        n.mostrar();
    }
}
