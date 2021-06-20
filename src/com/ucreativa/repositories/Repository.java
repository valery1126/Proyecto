package com.ucreativa.repositories;

import com.ucreativa.entities.Carro;

import java.util.Date;
import java.util.List;

public interface Repository {

    void save(Carro carro, Date fechaIngreso);

    List<String> get();

}
