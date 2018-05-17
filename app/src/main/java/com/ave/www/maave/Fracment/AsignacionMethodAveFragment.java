package com.ave.www.maave.Fracment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ave.www.maave.Adapter.Adapter_Asignacion_Method_Ave;
import com.ave.www.maave.Model.mClaseAsignacionAve;
import com.ave.www.maave.R;

import java.util.ArrayList;

import static com.ave.www.maave.MainMethodAVEActivity.MY_CANTIDAD_BODEGAS;
import static com.ave.www.maave.MainMethodAVEActivity.MY_CANTIDAD_FABRICAS;
import static com.ave.www.maave.MainMethodAVEActivity.MY_MATRIZCOMPLETA;
import static com.ave.www.maave.MainMethodAVEActivity.MY_OFERTAS_DEMANDAS;

/**
 * A simple {@link Fragment} subclass.
 */
public class AsignacionMethodAveFragment extends Fragment {


    int MatrizCompleta[];
    int OfertasyDemandas [];
    int Bodega;
    int Fabricas;
    int numDemyOfer = 1;
    int numCostUni = 0;

    ArrayList<mClaseAsignacionAve> matriz;

    public AsignacionMethodAveFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_asignacion_method_ave, container, false);
        //Informacion mandada por la normatica llave - Valor
        Bundle bundle = getArguments();
        Fabricas = bundle.getInt(MY_CANTIDAD_FABRICAS);
        Bodega = bundle.getInt(MY_CANTIDAD_BODEGAS);
        OfertasyDemandas = bundle.getIntArray(MY_OFERTAS_DEMANDAS);
        MatrizCompleta = bundle.getIntArray(MY_MATRIZCOMPLETA);


        //Informacion del Recipiente que esta en espera del contenido
        RecyclerView recyclerView =  (RecyclerView) view.findViewById(R.id.rvAsginacionMethod);

        //El adaptador que permite que un item de tipo design puede ser colocado en este Actividad
        Adapter_Asignacion_Method_Ave adapter = new Adapter_Asignacion_Method_Ave(buildAsignacion(),R.layout.item_methocell,getActivity());

        //Se le va el formato de tipo de GridLayourt y que va a medir lo que las tiene como valor las bodegas + 1 para la demostracion del Method
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),Bodega + 1));
        recyclerView.setAdapter(adapter);
        return view;

    }

    public ArrayList<mClaseAsignacionAve> buildAsignacion(){
        ArrayList<mClaseAsignacionAve> mclase = new ArrayList<>();

        for (int x = 0 ; x < ((Fabricas + 1)  * (Bodega + 1) ); x++){

            if((((Bodega + 1) * numDemyOfer )-1) == x && x != (((Fabricas + 1) * (Bodega + 1)) -1) ){
              mclase.add(new mClaseAsignacionAve(OfertasyDemandas[numDemyOfer -1],-1));
                numDemyOfer++;
            }else if (x > (((Fabricas + 1 ) * Bodega) -1)){
                if(x != (((Fabricas + 1)  * (Bodega + 1))-1)){
                mclase.add(new mClaseAsignacionAve(OfertasyDemandas[numDemyOfer-1],-1));
                numDemyOfer++;
                }
                else{
                    mclase.add(new mClaseAsignacionAve(OfertasyDemandas[numDemyOfer -1],OfertasyDemandas[numDemyOfer]));
                }
            }
            else {
            mclase.add(new mClaseAsignacionAve(0,MatrizCompleta[numCostUni]));
                numCostUni++;
            }
        }

        return mclase;
    }

}
