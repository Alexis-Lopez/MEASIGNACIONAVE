package com.ave.www.maave;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ave.www.maave.Fracment.CellCostFragment;

public class MethoCeldasCostActivity extends AppCompatActivity {
    public static final String MY_MATRIZ_KEY = "CUSTOM_KEY_MATRIZ";
    public static final String MY_BODEGASCAN_KEY = "CUSTOM_KEYCAN_BODEGAS";
    public static final String My_FABRICACAN_KEY  = "CUSTOM_KEYCAN_FABRICAS";

    int [] Matriz;
    int Bodegas = 0;
    int Fabricas = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metho_celdas_cost);
        //Para resivir la Matriz
        Bundle bundle = getIntent().getExtras();
        Matriz = bundle.getIntArray("my_matriz");
        Bodegas = bundle.getInt("my_bodega_cant");
        Fabricas = bundle.getInt("my_fabrica_cant");
        showToolbar("COSTO UNITARIO" , true);

        CellCostFragment leccionesFragment = new CellCostFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.c_fracm_celdascost,myCustomMatriz()).commit();
    }

    public void showToolbar(String Titulo,boolean upBotton){
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(Titulo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upBotton);
    }

    private Fragment myCustomMatriz(){
       Bundle bundle = new Bundle();
        bundle.putIntArray(MY_MATRIZ_KEY,Matriz);
        bundle.putInt(MY_BODEGASCAN_KEY,Bodegas);
        bundle.putInt(My_FABRICACAN_KEY,Fabricas);

        CellCostFragment cellCostFragment = new CellCostFragment();
        cellCostFragment.setArguments(bundle);
        return cellCostFragment;
    }




}
