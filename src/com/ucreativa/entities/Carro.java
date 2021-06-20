package com.ucreativa.entities;

public class Carro {


    private String marca;
    private String modelo;
    private String color;
    private int puertas;

    public Carro(String marca, String modelo, String color, int puertas) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.puertas = puertas;
    }


    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    public int getPuertas() {
        return puertas;
    }








}
