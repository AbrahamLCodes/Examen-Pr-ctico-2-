package iceCreamSandwich.unidad2.examenpractico2icecreamsandwich;

/*
* Autor: Abraham Luna Cázares, Mario Andres Tejada Morales, bla
* Carrera: Ingeniería Informática
* Materia: Desarrollo de Aplicaciones Móviles I
* Docente: Ing. Rubén Alonso Hernández Chávez
* ---Instituto Tecnológico de Chihuahua II---
* */

import java.util.ArrayList;

public class ArrayRestaurante {
    /*
        Una pequeña clase basada en la API ArrayList la cual solo tiene los métodos necesarios
        para almacenar y obtener los Restaurantes en un ArrayList.
     */

    private Restaurante restaurante;
    /* Variable estática para no crear nuevos objetos. Si se creara un nuevo objeto se "Reiniciaría"
    el ArrayList. Y no queremos que pase eso puesto que se perdería la información almacenada */

    private static ArrayList<Restaurante> arrayRestaurante = new ArrayList<Restaurante>();

    //Método para agregar Restaurantes.
    public static void add(Restaurante dato){
        arrayRestaurante.add(dato);
    }
    public static Restaurante getpeek(){
        return arrayRestaurante.get(arrayRestaurante.size()-1);
    }
    //Método para verificar si hay o no hay elementos. Para validaciones más fáciles dentro del código.
    public static boolean isEmpty(){
        if (arrayRestaurante.isEmpty()){
            return true;
        }else {
            return false;
        }
    }

    /*
    Retorna el ArrayList de Restaurantes. Con este método podemos obtener los atributos de los
    Restaurantes almacenados
    */
    public static ArrayList<Restaurante> getArrayRestaurante() {
        return arrayRestaurante;
    }
}
