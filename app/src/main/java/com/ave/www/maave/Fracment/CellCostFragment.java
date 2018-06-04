package com.ave.www.maave.Fracment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ave.www.maave.Adapter.AdapterCellCost;
import com.ave.www.maave.Adapter.AdapterQuestions;
import com.ave.www.maave.MainMethodAVEActivity;
import com.ave.www.maave.Model.mClaseMethod;
import com.ave.www.maave.Model.mClassNumro;
import com.ave.www.maave.Model.mdDetailsQuestion;
import com.ave.www.maave.Model.numerosCeldas;
import com.ave.www.maave.R;

import java.util.ArrayList;

import static com.ave.www.maave.MethoCeldasCostActivity.MY_BANDERA_FICDEM;
import static com.ave.www.maave.MethoCeldasCostActivity.MY_BANDERA_FICOFT;
import static com.ave.www.maave.MethoCeldasCostActivity.MY_BANDERA_MIN_OR_MAX;
import static com.ave.www.maave.MethoCeldasCostActivity.MY_BODEGASCAN_KEY;
import static com.ave.www.maave.MethoCeldasCostActivity.MY_MATRIZ_KEY;
import static com.ave.www.maave.MethoCeldasCostActivity.My_FABRICACAN_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class CellCostFragment extends Fragment {

    int DDemyOfert [];
    int Bodegas = 0;
    int Fabricas = 0;
    int Matriz  [];
    int MatrizCompleta [];
    String txtDataSet [];
    private int numeroPosicion = 1;
    private int numpara = 0;
    private boolean banCamVacios = false;
    private boolean banMinorMax,banFicOfet,banFicDeman;


    public CellCostFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view =inflater.inflate(R.layout.fragment_cell_cost, container, false);
        Bundle bundle = getArguments();
        DDemyOfert = bundle.getIntArray(MY_MATRIZ_KEY);
        Bodegas = bundle.getInt(MY_BODEGASCAN_KEY);
        Fabricas = bundle.getInt(My_FABRICACAN_KEY);
        banMinorMax = bundle.getBoolean(MY_BANDERA_MIN_OR_MAX);
        banFicOfet = bundle.getBoolean(MY_BANDERA_FICOFT);
        banFicDeman = bundle.getBoolean(MY_BANDERA_FICDEM);
        if(banFicOfet) {
            Matriz = new int[(Bodegas) * (Fabricas - 1)];
        }
        else if(banFicDeman){
            Matriz = new int[(Bodegas -1) * (Fabricas)];
        }else {
            Matriz = new int[(Bodegas) * (Fabricas)];
        }
        MatrizCompleta = new int[(Bodegas) * Fabricas];

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rvmethocell);
        if (banFicDeman){
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(),Bodegas -1));
        }else{
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),Bodegas));
        }
        AdapterCellCost adapter = new AdapterCellCost(buildMethod(),R.layout.item_meth,getActivity());
        txtDataSet = adapter.getTxtDataset();


        recyclerView.setAdapter(adapter);

        onCellViewCostUnitario(view);

        return view;
    }

    public void onCellViewCostUnitario(View view){

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fabcellcost);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                for (int x = 0; x < txtDataSet.length; x++) {
                    if(txtDataSet[x].toString().length() != 0 ){
                            Matriz[x] = Integer.parseInt(txtDataSet[x].toString());
                    }
                    else{
                        banCamVacios = true;
                    }
                }

                if (banCamVacios != true){
                    llenarmatrizcompleta();
                    Intent intent = new Intent(getActivity(), MainMethodAVEActivity.class);
                    intent.putExtra("Matriz_Cost_Uni",MatrizCompleta);
                    intent.putExtra("Arreglo Matriz",DDemyOfert);
                    intent.putExtra("Can_Bodegas",Bodegas);
                    intent.putExtra("Can_Fabricas" , Fabricas);
                    intent.putExtra("BanMaxorMin" , banMinorMax);
                    intent.putExtra("banFicOfert",banFicOfet);
                    intent.putExtra("banFicDeman",banFicDeman);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getActivity(),"Agregar valor unitario difente de 0 " ,Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void llenarmatrizcompleta(){
        int numero = 1;
        int numeromatriz = 0;
        for (int x = 0 ; x < (Bodegas * Fabricas);x++){
            if(banFicDeman){
                if (((Bodegas * numero)-1 == x)){
                    MatrizCompleta[x] =  60;
                    numero++;
                }else{
                    MatrizCompleta[x] = Matriz[numeromatriz];
                    numeromatriz++;
                }
            }else if (banFicOfet){
                if (x >= (Bodegas * (Fabricas -1)) ){
                    MatrizCompleta[x] = 500;
                }
                else{
                    MatrizCompleta[x] = Matriz[numeromatriz];
                    numeromatriz++;
                }
            }
            else{
                MatrizCompleta = Matriz;
            }
        }
    }

    public ArrayList<numerosCeldas> buildMethod(){

        ArrayList<numerosCeldas> method = new ArrayList<>();
            for ( int  i = 0 ; i < Matriz.length  ; i++){
                method.add(new numerosCeldas(0));
            }
        return method;
    }

}
