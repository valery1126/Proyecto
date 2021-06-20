package com.ucreativa.ui;

public class ErrorEnCantPuertasException extends Exception{
    public ErrorEnCantPuertasException(String puertas) {
        super("La cantidad de puertas esta incorrecta: " + puertas);
    }
}
