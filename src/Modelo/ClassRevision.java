/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author SEBAS
 */
public class ClassRevision {
     int idrevision;
     String placa;
     String deescripcion;
     String fecha;

    public ClassRevision() {
    }

    public ClassRevision(int idrevision, String placa, String deescripcion, String fecha) {
        this.idrevision = idrevision;
        this.placa = placa;
        this.deescripcion = deescripcion;
        this.fecha = fecha;
    }

    public int getIdrevision() {
        return idrevision;
    }

    public void setIdrevision(int idrevision) {
        this.idrevision = idrevision;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getDeescripcion() {
        return deescripcion;
    }

    public void setDeescripcion(String deescripcion) {
        this.deescripcion = deescripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
        
      
 }
