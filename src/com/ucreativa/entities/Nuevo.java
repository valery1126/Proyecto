package com.ucreativa.entities;

public class Nuevo extends Carro {

    private boolean garantia;


    public Nuevo(String marca, String modelo, String color, int puertas, boolean garantia) {
        super(marca, modelo, color, puertas);
        this.garantia = garantia;
    }


    public boolean isGarantia() {
        return garantia;
    }
}
