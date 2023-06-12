/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author SEBAS
 */
public class ClassProveedor {
    String idproveedor;
    String sucursal;
    String nombre;
    String apellido;
    String empresa;
    String celular;
    String estado;

    public ClassProveedor() {
    }

    public ClassProveedor(String idproveedor, String sucursal, String nombre, String apellido, String empresa, String celular, String estado) {
        this.idproveedor = idproveedor;
        this.sucursal = sucursal;
        this.nombre = nombre;
        this.apellido = apellido;
        this.empresa = empresa;
        this.celular = celular;
        this.estado = estado;
    }

    public String getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(String idproveedor) {
        this.idproveedor = idproveedor;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
