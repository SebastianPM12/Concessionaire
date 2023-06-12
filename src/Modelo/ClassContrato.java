package Modelo;

public class ClassContrato{
    String dni;
    String Contrato;
    String IDVendedor;
    String placa;
    String descripcion;
    String Fecha; 
    public ClassContrato(){
    }

    public ClassContrato(String dni, String Contrato, String IDVendedor, String placa, String descripcion, String Fecha) {
        this.dni = dni;
        this.Contrato = Contrato;
        this.IDVendedor = IDVendedor;
        this.placa = placa;
        this.descripcion = descripcion;
        this.Fecha = Fecha;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getContrato() {
        return Contrato;
    }

    public void setContrato(String Contrato) {
        this.Contrato = Contrato;
    }

    public String getIDVendedor() {
        return IDVendedor;
    }

    public void setIDVendedor(String IDVendedor) {
        this.IDVendedor = IDVendedor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }
  
    
}