package com.ave.www.maave.Fracment;


import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.ave.www.maave.Adapter.Adapter_Asignacion_Method_Ave;
import com.ave.www.maave.Model.mClaseAsignacionAve;
import com.ave.www.maave.R;


import java.util.ArrayList;
import java.util.List;


import static android.content.ContentValues.TAG;
import static com.ave.www.maave.MainMethodAVEActivity.MY_CANTIDAD_BODEGAS;
import static com.ave.www.maave.MainMethodAVEActivity.MY_CANTIDAD_FABRICAS;
import static com.ave.www.maave.MainMethodAVEActivity.MY_MATRIZCOMPLETA;
import static com.ave.www.maave.MainMethodAVEActivity.MY_OFERTAS_DEMANDAS;

/**
 * A simple {@link Fragment} subclass.
 */
public class AsignacionMethodAveFragment extends Fragment {

 //   int o = Integer.parseInt(" ");
    private static Adapter_Asignacion_Method_Ave adapter;
    private static ArrayList<mClaseAsignacionAve> mclase;
    private static  ArrayList<mClaseAsignacionAve> mclaseAsi;
    RecyclerView recyclerView;
    int MatrizCompleta[];
    int menorData[];
    int menorPos[];
    int OfertasyDemandas [];
    int Bodega;
    int Fabricas;
    int numDemyOfer = 1;
    int numCostUni = 0;
    int numPot = 1 ;
    int numCul = 1;
    int numRen = 1;
    int numBodega = 3;
    private static boolean bandera = true;
    int position;
    int initvalor;

    ArrayList<mClaseAsignacionAve> ARREGLOINFO;

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
         recyclerView =  (RecyclerView) view.findViewById(R.id.rvAsginacionMethod);

        //El adaptador que permite que un item de tipo design puede ser colocado en este Actividad
         adapter = new Adapter_Asignacion_Method_Ave(buildAsignacion(),R.layout.item_methocell,getActivity());
         ARREGLOINFO = buildAsignacion();

        //Se le va el formato de tipo de GridLayourt y que va a medir lo que las tiene como valor las bodegas + 1 para la demostracion del Method
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),Bodega + 2));
        recyclerView.setAdapter(adapter);

        refresh(view);

        return view;


    }

    public void refresh(final View view){

        FloatingActionButton fabrefresh = (FloatingActionButton) view.findViewById(R.id.fabrefresh);

        fabrefresh.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                //sacarMenor();
                if(bandera){
                AsignacionAve();
                adapter.refresevent(ARREGLOINFO);
                    bandera = false;
                }
                else{
                    // Use the Builder class for convenient dialog construction
                    new AlertDialog.Builder(getActivity()).setTitle("Exit").setMessage("").setNegativeButton("No",null)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).create().show();

                }
            }
        });
    }


    public ArrayList<mClaseAsignacionAve> buildAsignacion(){
         numDemyOfer = 1;
         numCostUni = 0;
         numPot = 1 ;
         numCul = 1;
         numRen = 1;
         mclase = new ArrayList<>();

        for (int x = 0 ; x < ((Fabricas + 2)  * (Bodega + 2) ); x++){
            if(x < (Bodega + 2)){
                    if (x == 0){
                        mclase.add(new mClaseAsignacionAve("","","C/D","#64B5F6"));
                    } else if( x == Bodega + 1 ){
                        mclase.add(new mClaseAsignacionAve("","","OFE","#64B5F6"));
                    }else {
                        mclase.add(new mClaseAsignacionAve("","","C" + numCul, "#64B5F6"));
                        numCul++;
                    }
            }
            else if(((Bodega + 2) * numRen) == x ){
                if(((Bodega + 2 ) * (Fabricas+1)) == x){
                    mclase.add(new mClaseAsignacionAve("","","DEM" , "#64B5F6"));
                }else{
                    mclase.add(new mClaseAsignacionAve("","","R" +numRen,"#64B5F6" ));
                    numRen++;
                }
            }
            else if((((Bodega + 2) * (numDemyOfer+1) )-1) == x && x != (((Fabricas + 2) * (Bodega + 2)) -1) ){
              mclase.add(new mClaseAsignacionAve(String.valueOf(OfertasyDemandas[numDemyOfer -1]),"","","#84FFFF"));
                numDemyOfer++;
            }
            else if (x > (((Fabricas + 2 ) * (Bodega+1)) -1)){
                if(x != (((Fabricas + 2)  * (Bodega + 2))-1)){
                mclase.add(new mClaseAsignacionAve(String.valueOf(OfertasyDemandas[numDemyOfer-1]),"","","#84FFFF"));
                numDemyOfer++;
                }
                else{
                    mclase.add(new mClaseAsignacionAve(String.valueOf(OfertasyDemandas[numDemyOfer -1]),String.valueOf(OfertasyDemandas[numDemyOfer]),"","#b5cccc"));
                }
            }
            else {
            mclase.add(new mClaseAsignacionAve("",String.valueOf(MatrizCompleta[numCostUni]),"","#b5cccc"));
                numCostUni++;
            }
        }
        return mclase;

    }

    public void  AsignacionAve(){

            int punterox = ((Fabricas + 2) * (Bodega +1 ) + numPot);
            int numeroDiferencia;
        for (int x = 0 ; x < Bodega  ; x ++){
            numRen =0;
            sacarMenor();
            do{
                if(ARREGLOINFO.get((menorPos[numRen] + Bodega - x)).getNumeroAsignar() != "0" && numRen < Fabricas){
                    //Esta decision se hace para evitar numeros negativos
                    if(Integer.parseInt(ARREGLOINFO.get(punterox).getNumeroAsignar()) > Integer.parseInt(ARREGLOINFO.get((menorPos[numRen] + (Bodega - x))).getNumeroAsignar())){

                        //Para ver cuanta demanda queda se hace esta diferencia o  resta
                        numeroDiferencia  = Integer.parseInt(ARREGLOINFO.get(punterox).getNumeroAsignar()) - Integer.parseInt(ARREGLOINFO.get((menorPos[numRen] + Bodega - x)).getNumeroAsignar());
                        //Para ver cuanto poner el valor de la oferta en el numero de asignar
                        ARREGLOINFO.get(menorPos[numRen]).setNumeroAsignar(ARREGLOINFO.get(menorPos[numRen] + (Bodega - x)).getNumeroAsignar());
                        ARREGLOINFO.get(menorPos[numRen]).setColor("#FFFFFF");
                        //Como la demanda es mas grande que la oferta se regresa un cero
                        ARREGLOINFO.get((menorPos[numRen] + (Bodega - x))).setNumeroAsignar("0");
                        //Lo que le queda de manda se le manda con la resta anterior realizada
                        ARREGLOINFO.get(punterox).setNumeroAsignar(String.valueOf(numeroDiferencia));

                    }
                    else{
                        numeroDiferencia = Integer.parseInt(ARREGLOINFO.get(( menorPos[numRen] + (Bodega - x))).getNumeroAsignar()) - Integer.parseInt(ARREGLOINFO.get(punterox).getNumeroAsignar());
                        ARREGLOINFO.get(menorPos[numRen]).setNumeroAsignar(ARREGLOINFO.get(punterox).getNumeroAsignar());
                        ARREGLOINFO.get(menorPos[numRen]).setColor("#FFFFFF");
                        ARREGLOINFO.get(punterox).setNumeroAsignar("0");
                        ARREGLOINFO.get(menorPos[numRen] + Bodega -x).setNumeroAsignar(String.valueOf(numeroDiferencia));
                    }
                }
                numRen++;
            }while (ARREGLOINFO.get(punterox).getNumeroAsignar() != "0");
            numBodega++;
            punterox = punterox + 1;
        }
    }

    public void  sacarMenor(){
        int menor;
        int position;
        int valorinit = (Bodega + numBodega);
        menorData = new int [Fabricas];
        menorPos = new int  [Fabricas];
        for (int x = 0 ; x < Fabricas;x++) {
            menorData[x] = Integer.parseInt(ARREGLOINFO.get(valorinit).getCostUnitario().trim());
            menorPos[x] = valorinit;
            valorinit =  valorinit +Bodega + 2;
        }

        for (int w = 0 ; w < Fabricas ; w ++ ){
           for (int y = 1 ; y < (Fabricas - w); y++){
                if (menorData[y -1] > menorData[y]){
                    menor = menorData[y - 1];
                    menorData[y - 1] = menorData[y];
                    menorData[y] = menor;
                    position = menorPos[ y - 1];
                    menorPos[y-1] = menorPos[y];
                    menorPos[y] = position;
                }
           }
        }

        //Toast.makeText(getActivity(),"Posiciones " + menorPos[0] + menorPos[1]+ menorPos[2],Toast.LENGTH_LONG).show();
    }


}
