package Modelo;

/**
 *
 * @author
 */
public class ClassPersona {
    String nombres;
    String apellidos;
    String direccion;
    int edad;
    String correo;
    String genero;
    String celular;

    public ClassPersona(String nombres, String apellidos, String direccion, int edad, String correo, String genero, String celular) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.edad = edad;
        this.correo = correo;
        this.genero = genero;
        this.celular = celular;
    }

    public ClassPersona() {
    }
}
