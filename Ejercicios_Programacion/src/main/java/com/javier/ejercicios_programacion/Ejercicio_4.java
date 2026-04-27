/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.javier.ejercicios_programacion;

/**
 *
 * @author Jav
 */
class familiar {
    String nombre;
    double edad;
    public void mostrar(){
        System.out.println(nombre + ": " + edad + " anios");
    }
} 
    
    
public class Ejercicio_4 {

    public static void main(String[] args) {
        familiar juan = new familiar();
            juan.nombre = "Juan";
            juan.edad = 9;
        
        familiar alberto = new familiar();
            alberto.nombre = "Alberto";
            alberto.edad = juan.edad * 2.0/3.0;
        
        familiar ana = new familiar();
            ana.nombre = "Ana";
            ana.edad = juan.edad * 4.0/3.0;
            
        familiar madre = new familiar();
            madre.nombre = "Maria";
            madre.edad = juan.edad + alberto.edad + ana.edad;
        
        juan.mostrar();
        alberto.mostrar();
        ana.mostrar();
        madre.mostrar();
        
            
            
    }
    

}
