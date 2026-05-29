package ejercicio_3;

import java.util.Arrays;

public class Notas {

    double [] lista_notas;
  
    public Notas(int cantidad_notas){
        lista_notas = new double[cantidad_notas];
    }

    double calcular_promedio(){
        double suma = 0;

        for(int i = 0; i < lista_notas.length; i ++ ){            

            suma += lista_notas[i];

        }

        double promedio = suma / lista_notas.length;
        return promedio;


    }

    double desviacio_estandar(){
        double suma_elevacion = 0;
        double promedio = calcular_promedio(); 

        for(int i = 0; i < lista_notas.length; i++){
           
            suma_elevacion +=  Math.pow((lista_notas[i] - promedio), 2);
        }
        
        double desviacion_estandar = Math.sqrt(suma_elevacion / lista_notas.length);

        return desviacion_estandar;

    }

    double mayor_nota(){
        return Arrays.stream(lista_notas).max().getAsDouble();
    }

    double menor_nota(){
        return Arrays.stream(lista_notas).min().getAsDouble();
    }
}
