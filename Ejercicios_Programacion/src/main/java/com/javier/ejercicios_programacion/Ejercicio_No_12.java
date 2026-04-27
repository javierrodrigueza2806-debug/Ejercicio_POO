/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javier.ejercicios_programacion;

/**
 *
 * @author Jav
 */
class Empleado {
    double horas_trabajo;
    double valor_hora;
    double retefuente;
    
    public double salario_bruto(){
        return horas_trabajo * valor_hora;
    }
    
    public double retencion_fuente(){
        return salario_bruto() * retefuente;
    }
    
    public double salario_neto(){
        return salario_bruto() - retencion_fuente();
    }
    
    public void mostrar(){
        System.out.println("Salario bruto " + salario_bruto());
        System.out.println("Retencion de fuente " + retencion_fuente());
        System.out.println("Salario Neto " + salario_neto());
    }
    
}
public class Ejercicio_No_12 {
   
    public static void main(String[] args) {
        
        Empleado empleado_1 = new Empleado();
            empleado_1.horas_trabajo = 48;
            empleado_1.valor_hora = 5000;
            empleado_1.retefuente = 0.125;
            
            empleado_1.mostrar();
        
    }

}
