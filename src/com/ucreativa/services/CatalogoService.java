package com.ucreativa.services;

import com.ucreativa.entities.Carro;
import com.ucreativa.entities.Nuevo;
import com.ucreativa.entities.Usado;
import com.ucreativa.repositories.Repository;
import com.ucreativa.ui.ErrorEnCantPuertasException;

import java.util.Date;
import java.util.List;

public class CatalogoService {

    private Repository repository;


    public CatalogoService(Repository repository) {
        this.repository = repository;
    }

    public void save(String marca, String modelo, String color,Boolean isNuevo ,String txtPuertas,boolean garantia, String placa) throws ErrorEnCantPuertasException {
        int puertas;
        try {
            puertas = Integer.parseInt(txtPuertas);

        }catch (NumberFormatException x){
            throw new ErrorEnCantPuertasException(txtPuertas);
        }

        Carro carro;
        if (isNuevo){
            carro = new Nuevo(marca,modelo,color,puertas,garantia);
        }
        else{
            carro = new Usado(marca,modelo,color,puertas,placa);
        }

        this.repository.save(carro, new Date());
    }

    public List<String> get(){
        return this.repository.get();
    }



}
