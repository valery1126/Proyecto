package com.ucreativa.repositories;

import com.ucreativa.entities.Carro;
import com.ucreativa.entities.CatalogoCarros;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InMemoryRepository {
    private List<CatalogoCarros> db;

    public InMemoryRepository(){
        this.db = new ArrayList<>();
    }

    public void save(Carro carro, Date fechaIngreso){
        this.db.add(new CatalogoCarros(carro, fechaIngreso));
    }

    public List<String> get() {
        List<String> lines = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        for (CatalogoCarros item : db) {
            System.out.println(item.getCarro().getMarca() + " - " + item.getCarro().getModelo() + " - " + format.format(item.getFechaIngreso()));
        }

        return lines;
    }
}
