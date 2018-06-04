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
    public static final String MY_BAN_MAX_OR_MIN = "CUSTOM_FIT_FARICAS";
    public static final String MY_BAN_FIC_OFERT = "CUSTOM_DEma_FARICAS";
    public static final String MY_BAN_FIC_DEMAN = "CUSTOM_MAorMi_FARICAS";

    int Fabricas;
    int Bodegas;
    int MatrizCostos [];
    int ArregloDemandasyOfertas [];
    private static int numero =  1;
    private static int numeroCost = 0;
    boolean banMaxorMin, banFicOFet,banFicDeman;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_method_ave);

        Bundle bundle = getIntent().getExtras();

        MatrizCostos = bundle.getIntArray("Matriz_Cost_Uni");
        ArregloDemandasyOfertas = bundle.getIntArray("Arreglo Matriz");
        Fabricas = bundle.getInt("Can_Fabricas");
        Bodegas = bundle.getInt("Can_Bodegas");
        banMaxorMin = bundle.getBoolean("BanMaxorMin");
        banFicOFet = bundle.getBoolean("banFicOfert");
        banFicDeman = bundle.getBoolean("banFicDeman");


        showToolbar("Asignacion AVE",true);


        AsignacionMethodAveFragment asignacionMethodAveFragment = new AsignacionMethodAveFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fracm_asignationmethod,myCustomInfo()).commit();

    }

    public void showToolbar(String Titulo,boolean upBotton){
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(Titulo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upBotton);
    }


    private Fragment myCustomInfo(){
        Bundle bundle =  new Bundle();
        bundle.putIntArray(MY_MATRIZCOMPLETA,MatrizCostos);
        bundle.putInt(MY_CANTIDAD_BODEGAS,Bodegas);
        bundle.putInt(MY_CANTIDAD_FABRICAS,Fabricas);
        bundle.putIntArray(MY_OFERTAS_DEMANDAS,ArregloDemandasyOfertas);
        bundle.putBoolean(MY_BAN_MAX_OR_MIN,banMaxorMin);
        bundle.putBoolean(MY_BAN_FIC_OFERT,banFicOFet);
        bundle.putBoolean(MY_BAN_FIC_DEMAN,banFicDeman);

        AsignacionMethodAveFragment methodAveFragment =  new AsignacionMethodAveFragment();
        methodAveFragment.setArguments(bundle);
        return methodAveFragment;
    }
}
