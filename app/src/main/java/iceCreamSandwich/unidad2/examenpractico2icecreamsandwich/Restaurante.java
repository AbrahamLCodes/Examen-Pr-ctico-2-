package iceCreamSandwich.unidad2.examenpractico2icecreamsandwich;

/*
 * Autor: Abraham Luna Cázares
 * Carrera: Ingeniería Informática
 * Materia: Desarrollo de Aplicaciones Móviles I
 * Docente: Ing. Rubén Alonso Hernández Chávez
 * ---Instituto Tecnológico de Chihuahua II---
 * */

public class Restaurante {

    /*
        Clase restaurante con los campos de un restaurante en cuestión. Sirve para crear nuevos
        objetos de tipo Restaurante en la DatosActivity y posteriormente guardarse en el arreglo
        de Restaurantes.
    */

    String nombre, descripcion, dirytel;
    int calificacion, imagen;

    public Restaurante(String [] campos, int calificacion, int imagen){
        this.nombre = campos[0];
        this.descripcion = campos[1];
        this.dirytel = campos[2];
        this.calificacion = calificacion;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getDirytel() {
        return dirytel;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public int getImagen() {
        return imagen;
    }
}
