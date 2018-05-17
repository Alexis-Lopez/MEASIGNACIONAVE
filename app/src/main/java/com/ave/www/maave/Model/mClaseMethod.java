package com.ave.www.maave.Model;

import android.support.annotation.AnyRes;

import java.util.ArrayList;

/**
 * Created by trini on 16/04/18.
 */

public class mClaseMethod {

     private static int numFlas;
     private static int numColumnas;
     private static boolean tipoActionn;

    public String[][] getMatriz() {
        return Matriz;
    }

    public void setMatriz(String[][] matriz) {
        Matriz = matriz;
    }

    private String [][] Matriz = new String[numColumnas + 1 ][numFlas + 1];

    public mClaseMethod(int numFlas, int numColumnas, boolean tipoActionn) {
        this.numFlas = numFlas;
        this.numColumnas = numColumnas;
        this.tipoActionn = tipoActionn;
    }

    public int getNumFlas() {
        return numFlas;
    }

    public void setNumFlas(int numFlas) {
        this.numFlas = numFlas;
    }

    public int getNumColumnas() {
        return numColumnas;
    }

    public void setNumColumnas(int numColumnas) {
        this.numColumnas = numColumnas;
    }

    public boolean isTipoActionn() {
        return tipoActionn;
    }

    public void setTipoActionn(boolean tipoActionn) {
        this.tipoActionn = tipoActionn;
    }
}
