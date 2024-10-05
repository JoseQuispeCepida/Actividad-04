package com.zonajava.proyecto01;

import Vista.Vista;

public class Main {

    public static void main(String[] args) {
        // Crear una instancia de Vista y hacerla visible
        java.awt.EventQueue.invokeLater(() -> {
            new Vista().setVisible(true);
        });
    }
}
