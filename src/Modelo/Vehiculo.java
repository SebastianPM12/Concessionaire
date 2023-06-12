/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author SEBAS
 */
public abstract class Vehiculo {
    protected String tipo;
    protected String placa;
    protected String marca;
    protected double precio;
    protected String color;
    protected int año;

    public Vehiculo() {
    }

    public Vehiculo(String tipo, String placa, String marca, double precio, String color, int año) {
        this.tipo = tipo;
        this.placa = placa;
        this.marca = marca;
        this.precio = precio;
        this.color = color;
        this.año = año;
    }

   


}
