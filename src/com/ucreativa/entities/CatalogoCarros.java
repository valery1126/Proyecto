package com.ucreativa.entities;

import java.util.Date;

public class CatalogoCarros {

    private Carro carro;
    private Date fechaIngreso;


    public CatalogoCarros(Carro carro, Date fechaIngreso) {
        this.carro = carro;
        this.fechaIngreso = fechaIngreso;
    }

    public Carro getCarro() {
        return carro;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }



}
