package com.ave.www.maave.Model;

/**
 * Created by trini on 8/04/18.
 */

public class mdSession {
    private  int        id_sesion;
    private  String     description;
    private  Boolean    avaible;
    private int         price;
    private int         id_algoritmo;

    public mdSession(String description) {
        this.description = description;
    }

    public int getId_sesion() {
        return id_sesion;
    }

    public void setId_sesion(int id_sesion) {
        this.id_sesion = id_sesion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvaible() {
        return avaible;
    }

    public void setAvaible(Boolean avaible) {
        this.avaible = avaible;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId_algoritmo() {
        return id_algoritmo;
    }

    public void setId_algoritmo(int id_algoritmo) {
        this.id_algoritmo = id_algoritmo;
    }
}
