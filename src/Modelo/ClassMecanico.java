/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author SEBAS
 */
public class ClassMecanico extends ClassPersona{
    String idmecanico;
    String estado;
    String turno;

    public ClassMecanico() {
    }

    public ClassMecanico(String idmecanico, String estado, String turno, String nombres, String apellidos, String direccion, int edad, String correo, String genero, String celular) {
        super(nombres, apellidos, direccion, edad, correo, genero, celular);
        this.idmecanico = idmecanico;
        this.estado = estado;
        this.turno = turno;
    }

    public String getIdmecanico() {
        return idmecanico;
    }

    public void setIdmecanico(String idmecanico) {
        this.idmecanico = idmecanico;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
}
