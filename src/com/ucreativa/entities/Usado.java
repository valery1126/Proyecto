package com.ucreativa.entities;

public class Usado extends Carro{


    private String placa;



    public Usado(String marca, String modelo, String color, int puertas, String placa) {
        super(marca, modelo, color, puertas);
        this.placa=placa;
    }


    public String getPlaca() {
        return placa;
    }
}
