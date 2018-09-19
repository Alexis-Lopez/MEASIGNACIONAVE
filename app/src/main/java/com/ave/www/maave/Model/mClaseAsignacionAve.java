package com.ave.www.maave.Model;

import android.support.annotation.NonNull;

/**
 * Created by trini on 15/05/18.
 */

public class mClaseAsignacionAve {

    String NumeroAsignar;
    String CostUnitario ;


    public mClaseAsignacionAve(String position, String color) {
        Position = position;
        Color = color;
    }

    String Position;
    String Color;

    public String getPosition() {
        return Position;
    }

    public void setPosition(@NonNull String position) {
        Position = position;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getNumeroAsignar() {
        return NumeroAsignar;
    }

    public void setNumeroAsignar(String numeroAsignar) {
        NumeroAsignar = numeroAsignar;
    }

    public String getCostUnitario() {
        return CostUnitario;
    }


    public void setCostUnitario(String costUnitario) {
        CostUnitario = costUnitario;
    }

    public mClaseAsignacionAve(String   numeroAsignar, String costUnitario, String position, String color) {
        NumeroAsignar = numeroAsignar;
        CostUnitario = costUnitario;
        Position = position;
        Color = color;
    }
}
