/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author SEBAS
 */
public class Carro extends Vehiculo {

    public Carro() {
    }

    public Carro(String tipo, String placa, String marca, double precio, String color, int año) {
        super(tipo, placa, marca, precio, color, año);
    }

   

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public double preciocolor(String color) {
        double precioC = 0;
        if (color.equals("NEGRO")) {
            precioC = 150.0;
            return precioC;
        } else if (color.equals("BLANCO")) {
            precioC = 170.0;
            return precioC;
        } else if (color.equals("GRIS")) {
            precioC = 190.0;
            return precioC;

        } else if (color.equals("ROJO")) {
            precioC = 220.0;
            return precioC;
        } else if (color.equals("AZUL")) {
            precioC = 220.0;
            return precioC;
        } else {
            return 0;
        }
    }

    public double year(int año) {
        double precioA = 0;
        if (año == 2020) {
            precioA = 220.0;
            return precioA;
        } else if (año == 2021) {
            precioA = 440.0;
            return precioA;

        } else {
            return precioA;
        }

    }

    public double tipo(String tipo) {
        double precioT = 0;
        if (tipo.equals("DEPORTIVO")) {
            precioT = 55000.0;
            return precioT;
        } else if (tipo.equals("AUTO")) {
            precioT = 25000.0;
            return precioT;
        } else if (tipo.equals("DESCAPOTABLE")) {
            precioT = 35000.0;
            return precioT;
        } else {
            return precioT;
        }

    }

    public double marca(String marcar) {
        double precioM = 0;
        if (marcar.equals("AUDI")) {
            precioM = 700.0;
            return precioM;
        } else if (marcar.equals("TESLA")) {
            precioM = 850.0;
            return precioM;
        } else if (marcar.equals("NISSAN")) {

            precioM = 690.0;
            return precioM;
        } else {
            return precioM;
        }
    }

}
