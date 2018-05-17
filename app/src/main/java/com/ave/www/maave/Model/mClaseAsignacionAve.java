package com.ave.www.maave.Model;

/**
 * Created by trini on 15/05/18.
 */

public class mClaseAsignacionAve {

    int NumeroAsignar;
    int CostUnitario;

    public int getNumeroAsignar() {
        return NumeroAsignar;
    }

    public void setNumeroAsignar(int numeroAsignar) {
        NumeroAsignar = numeroAsignar;
    }

    public int getCostUnitario() {
        return CostUnitario;
    }

    public void setCostUnitario(int costUnitario) {
        CostUnitario = costUnitario;
    }

    public mClaseAsignacionAve(int numeroAsignar, int costUnitario) {
        NumeroAsignar = numeroAsignar;
        CostUnitario = costUnitario;
    }
}
