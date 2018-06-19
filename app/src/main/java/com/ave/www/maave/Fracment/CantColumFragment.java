package com.ave.www.maave.Fracment;


import android.accessibilityservice.GestureDescription;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ave.www.maave.Adapter.AdapterFilasNumber;
import com.ave.www.maave.Adapter.AdapterQuestions;
import com.ave.www.maave.MethoCeldasCostActivity;
import com.ave.www.maave.Model.mClaseMethod;
import com.ave.www.maave.Model.mClassNumro;
import com.ave.www.maave.Model.mdDetailsQuestion;
import com.ave.www.maave.R;

import java.util.ArrayList;

import static com.ave.www.maave.CantColumFilasActivity.MY_KEY_BAN_MINorMAX;
import static com.ave.www.maave.CantColumFilasActivity.MY_KEY_CANFABRICAS;
import static com.ave.www.maave.CantColumFilasActivity.MY_KEY_CANFILAS;


/**
 * A simple {@link Fragment} subclass.
 */
public class CantColumFragment extends Fragment {

    int  bodegas = 0;
    int fabricas = 0;
    boolean bandera ;
    public static String [] txtEscritos;
    private static int contadorOfertas = 0;
    private static int contadorDemandas = 0;
    private  int  banderaParaVacios = 0;
    private static int cantidaDif = 0 ;
    static boolean banderaOfertasFiticia = false;
    static boolean banderaDemandaFiticia = false;

    public CantColumFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view  = inflater.inflate(R.layout.fragment_cant_colum, container, false);

        Bundle bundle = getArguments();
        bodegas =  bundle.getInt(MY_KEY_CANFILAS);
        fabricas = bundle.getInt(MY_KEY_CANFABRICAS);
        bandera = bundle.getBoolean(MY_KEY_BAN_MINorMAX);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rvcanColumns);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);

        AdapterFilasNumber adapter = new AdapterFilasNumber(buildQuestions(),R.layout.item_columsvsfilas,getActivity());
        txtEscritos = adapter.getTxtEscritos();
        recyclerView.setAdapter(adapter);
        banderaOfertasFiticia = false;
        onCell(view);

        return view;

    }

    public void onCell(View view){


        final int [] Matriz  = new int[(bodegas + fabricas) + 4];
        FloatingActionButton btn = (FloatingActionButton) view.findViewById(R.id.fabcellcant);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int i = 0 ; i < ((bodegas + fabricas)); i++){
                    if (txtEscritos[i] != null){

                        if (i < fabricas ){
                            contadorOfertas = contadorOfertas + Integer.parseInt(txtEscritos[i].toString());
                            Matriz[i] = Integer.parseInt(txtEscritos[i].toString());
                        }else{
                            Matriz[i + 1] = Integer.parseInt(txtEscritos[i].toString());
                            contadorDemandas = contadorDemandas + Integer.parseInt(txtEscritos[i].toString());
                        }

                    }
                    else {
                        banderaParaVacios = 1;
                    }
                }

                if (banderaParaVacios != 1){
                    //Si las ofertas y  demandas son iguales se sigue la asignacion
                    Intent intent = new Intent(getActivity(), MethoCeldasCostActivity.class);
                    intent.putExtra("my_banMaxiorMin",bandera);
                    Matriz[bodegas + fabricas + 2 ] = contadorDemandas;
                    Matriz[bodegas + fabricas +  3] = contadorOfertas;
                    if (contadorOfertas == contadorDemandas){
                        intent.putExtra("my_matriz",Matriz);
                        intent.putExtra("my_bodega_cant",bodegas);
                        intent.putExtra("my_fabrica_cant",fabricas);
                        startActivity(intent);
                    }else if (contadorDemandas > contadorOfertas){
                        //Si la demanda es mayor que la oferta se agrega una oferta ficticia
                        cantidaDif = contadorDemandas - contadorOfertas;
                        Matriz[fabricas] = cantidaDif;
                        fabricas = fabricas + 1;
                        banderaOfertasFiticia  = true;
                        banderaDemandaFiticia = false;
                    }
                    else{
                        //Si la oferta es mayor que la demanda se agrega una demanda ficticia
                        cantidaDif = contadorOfertas - contadorDemandas;
                        Matriz[bodegas + fabricas + 1 ] = cantidaDif;
                        bodegas = bodegas + 1;
                        banderaDemandaFiticia = true;
                        banderaOfertasFiticia = false;

                    }

                    intent.putExtra("my_matriz",Matriz);
                    intent.putExtra("my_bodega_cant",bodegas);
                    intent.putExtra("my_fabrica_cant",fabricas);
                    intent.putExtra("mybandOfe_Ficticia",banderaOfertasFiticia);
                    intent.putExtra("mybanDem_Fict",banderaDemandaFiticia);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getActivity(),"No dejar campos de Demanda o Ofertas Vacio " ,Toast.LENGTH_SHORT).show();
                    banderaParaVacios = 0;
                }
            }});
    }

    public ArrayList<mClassNumro> buildQuestions(){

        ArrayList<mClassNumro> numeros = new ArrayList<>();
        for (int i = 0 ; i <  fabricas; i ++ ){
            numeros.add(new mClassNumro("OFERTA " + (i +1) ));
        }
        for (int x = 0; x < bodegas ; x++){
            numeros.add(new mClassNumro("DEMANDA " + ( x + 1)));
        }
        return numeros;
    }


}
