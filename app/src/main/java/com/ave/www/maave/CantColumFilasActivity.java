package com.ave.www.maave;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ave.www.maave.Adapter.AdapterCellCost;
import com.ave.www.maave.Adapter.AdapterFilasNumber;
import com.ave.www.maave.Fracment.CantColumFragment;
import com.ave.www.maave.Model.mClaseMethod;
import com.ave.www.maave.R;

public class CantColumFilasActivity extends AppCompatActivity {

    public static final String MY_KEY_CANFILAS = "CUSTOM_KEY";
    public static final String MY_KEY_CANFABRICAS = "CUSTOM_KEY_2";

    int Bodegas  =  0;
    int Fabricas = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cant_colum_filas);
        Bundle bundle  = getIntent().getExtras();
        Bodegas = bundle.getInt("my_key_bodegas");
        Fabricas = bundle.getInt("my_key_fabricas");

        //Fabricas = bundle.getString("my_key_fabricas");
        showToolbar("OFERTAS y DEMANDAS",true);

        CantColumFragment leccionesFragment = new CantColumFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.con_canNumber,createCustom()).commit();
    }

    public void showToolbar(String Titulo,boolean upBotton){
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(Titulo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upBotton);
    }

    private Fragment createCustom(){
        Bundle bundle = new Bundle();
        bundle.putInt(MY_KEY_CANFILAS , Bodegas);
        bundle.putInt(MY_KEY_CANFABRICAS,Fabricas);

        CantColumFragment cantColumFragment = new CantColumFragment();
        cantColumFragment.setArguments(bundle);
        return  cantColumFragment;
    }


}
