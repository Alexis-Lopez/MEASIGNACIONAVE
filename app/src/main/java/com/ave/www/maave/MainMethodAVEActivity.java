package com.ave.www.maave;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ave.www.maave.Fracment.AsignacionMethodAveFragment;

import java.nio.BufferUnderflowException;

public class MainMethodAVEActivity extends AppCompatActivity {

    public static final String MY_MATRIZCOMPLETA = "CUSTOM_MATRIZ_COMPLETA";
    public static final String MY_OFERTAS_DEMANDAS = "CUSTOM_OFERTAS_DEMANDAS";
    public static final String MY_CANTIDAD_BODEGAS = "CUSTOM_CANTIDAD_BODEGAS";
    public static final String MY_CANTIDAD_FABRICAS = "CUSTOM_CANTIDAD_FARICAS";

    int Fabricas;
    int Bodegas;
    int MatrizCostos [];
    int ArregloDemandasyOfertas [];
    private static int numero =  1;
    private static int numeroCost = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_method_ave);

        Bundle bundle = getIntent().getExtras();

        MatrizCostos = bundle.getIntArray("Matriz_Cost_Uni");
        ArregloDemandasyOfertas = bundle.getIntArray("Arreglo Matriz");
        Fabricas = bundle.getInt("Can_Fabricas");
        Bodegas = bundle.getInt("Can_Bodegas");


        AsignacionMethodAveFragment asignacionMethodAveFragment = new AsignacionMethodAveFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fracm_asignationmethod,myCustomInfo()).commit();

    }


    private Fragment myCustomInfo(){
        Bundle bundle =  new Bundle();
        bundle.putIntArray(MY_MATRIZCOMPLETA,MatrizCostos);
        bundle.putInt(MY_CANTIDAD_BODEGAS,Bodegas);
        bundle.putInt(MY_CANTIDAD_FABRICAS,Fabricas);
        bundle.putIntArray(MY_OFERTAS_DEMANDAS,ArregloDemandasyOfertas);

        AsignacionMethodAveFragment methodAveFragment =  new AsignacionMethodAveFragment();
        methodAveFragment.setArguments(bundle);
        return methodAveFragment;
    }
}
