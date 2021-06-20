package com.ucreativa.repositories;

import com.ucreativa.entities.Carro;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class FileRepository implements Repository{

    private final String FILE_PATH = "db.txt";


    @Override
    public void save(Carro carro, Date fechaIngreso) {

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

        String text = carro.getMarca() + " " + carro.getModelo() + " " + format.format(fechaIngreso) + "\n";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true));
            writer.append(text);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<String> get() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            return reader.lines().collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
