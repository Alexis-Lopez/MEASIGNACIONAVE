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
import static com.ave.www.maave.MainMethodAVEActivity.MY_BAN_FIC_DEMAN;
import static com.ave.www.maave.MainMethodAVEActivity.MY_BAN_FIC_OFERT;
import static com.ave.www.maave.MainMethodAVEActivity.MY_BAN_MAX_OR_MIN;
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
    private Button btninformation;
    RecyclerView recyclerView;
    int MatrizCompleta[];
    int menorData[];
    int menorPos[];
    int OfertasyDemandas [];
    int [] postionAsignados;
    int Bodega;
    int Fabricas;
    int numDemyOfer = 1;
    int numCostUni = 0;
    int numPot = 1 ;
    int numCul = 1;
    int numRen = 1;
    int numBodega = 3;
    int numAsignados = 0,numAsignadosRenglon;
    private static boolean bandera = true;
    int position;
    int initvalor;
    private boolean banMinorMax,banFicOfet,banFicDeman;
    int nummatriz;
    int  numeropostmayorRenglon = 0;
    static int valorZ = 0;
    int acumuladorZeta = 0 ;
    String acumuladorTextZeta = "";
    boolean banderaDatos = true;
    int [] numerosRenglones;
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
        bandera = true;
        Fabricas = bundle.getInt(MY_CANTIDAD_FABRICAS);
        Bodega = bundle.getInt(MY_CANTIDAD_BODEGAS);
        OfertasyDemandas = bundle.getIntArray(MY_OFERTAS_DEMANDAS);
        MatrizCompleta = bundle.getIntArray(MY_MATRIZCOMPLETA);
        banMinorMax = bundle.getBoolean(MY_BAN_MAX_OR_MIN);
        banFicOfet = bundle.getBoolean(MY_BAN_FIC_OFERT);
        banFicDeman = bundle.getBoolean(MY_BAN_FIC_DEMAN);

        if(Fabricas > Bodega){
            nummatriz = Fabricas - Bodega;
        }else if(Bodega > Fabricas){
            nummatriz = Bodega - Fabricas;
        }else{
            nummatriz = 0;
        }


        //Informacion del Recipiente que esta en espera del contenido
         recyclerView =  (RecyclerView) view.findViewById(R.id.rvAsginacionMethod);

        //El adaptador que permite que un item de tipo design puede ser colocado en este Actividad
         adapter = new Adapter_Asignacion_Method_Ave(buildAsignacion(),R.layout.item_methocell,getActivity());
         ARREGLOINFO = buildAsignacion();

        //Se le va el formato de tipo de GridLayourt y que va a medir lo que las tiene como valor las bodegas + 1 para la demostracion del Method
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),Bodega + 2));
        recyclerView.setAdapter(adapter);

        refresh(view);
        information(view);

        return view;


    }
    public void information(final View view){
        Button btninfort = (Button) view.findViewById(R.id.btnInformation);
        btninfort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getActivity()).setTitle("El valor de zeta "  + acumuladorZeta).setMessage("La sumatoria de z es = " + acumuladorTextZeta).setNegativeButton("No",null)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //  OptimizacionMODI();
                            }
                        }).create().show();
            }
        });
    }



    public void refresh(final View view){

        FloatingActionButton fabrefresh = (FloatingActionButton) view.findViewById(R.id.fabrefresh);

        fabrefresh.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                //sacarMenor();
                    if (bandera){
                AsignacionAve();
                numAsignacionRenglon();
                cantidaddeZ();
                        bandera = false;
                adapter.refresevent(ARREGLOINFO);



                    }else{


                    // Use the Builder class for convenient dialog construction
                    new AlertDialog.Builder(getActivity()).setTitle("Desea optimizar la asignacion" + numeropostmayorRenglon).setMessage("La optimizacion MODI").setNegativeButton("No",null)
                            .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                           OptimizacionMODI();
                            adapter.refresevent(ARREGLOINFO);
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
            //Primeras Columnas
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
            //PAra los renglones
            else if(((Bodega + 2) * numRen) == x ){
                if(((Bodega + 2 ) * (Fabricas+1)) == x){
                    mclase.add(new mClaseAsignacionAve("","","DEM" , "#64B5F6"));
                }else{
                    mclase.add(new mClaseAsignacionAve("","","R" +numRen,"#64B5F6" ));
                    numRen++;
                }
            }
            //Para las ofertas
            else if((((Bodega + 2) * (numDemyOfer+1) )-1) == x && x != (((Fabricas + 2) * (Bodega + 2)) -1) ){
              mclase.add(new mClaseAsignacionAve(String.valueOf(OfertasyDemandas[numDemyOfer-1]),"","","#F4F0FF"));
                numDemyOfer++;
            }
            else if (banFicOfet && x > (((Fabricas + 2 ) * (Bodega+1)) -1)){

                if(x != (((Fabricas + 2)  * (Bodega + 2))-1)){
                    if (banFicOfet){
                        mclase.add(new mClaseAsignacionAve(String.valueOf(OfertasyDemandas[numDemyOfer-1]),"","","#84FFFF"));
                    }else{
                        mclase.add(new mClaseAsignacionAve(String.valueOf(OfertasyDemandas[numDemyOfer]),"","","#84FFFF"));
                    }
                numDemyOfer++;
                }
                //Para el ultimo valor
                else{
                    mclase.add(new mClaseAsignacionAve(String.valueOf(OfertasyDemandas[numDemyOfer+1]),String.valueOf(OfertasyDemandas[numDemyOfer+1]),"","#b5cccc"));
                }
            }
            else if (x >= (((Fabricas + 2 ) * (Bodega+1)) -1)){

                if(x != (((Fabricas + 2)  * (Bodega + 2))-1)){
                    if (banFicOfet){
                        mclase.add(new mClaseAsignacionAve(String.valueOf(OfertasyDemandas[numDemyOfer-1]),"","","#84FFFF"));
                    }else{
                        mclase.add(new mClaseAsignacionAve(String.valueOf(OfertasyDemandas[numDemyOfer]),"","","#84FFFF"));
                    }
                    numDemyOfer++;
                }
                //Para el ultimo valor
                else{
                    mclase.add(new mClaseAsignacionAve(String.valueOf(OfertasyDemandas[numDemyOfer+1]),String.valueOf(OfertasyDemandas[numDemyOfer+1]),"","#b5cccc"));
                }
            }
            //Para las columnas normales
            else {
            mclase.add(new mClaseAsignacionAve("",String.valueOf(MatrizCompleta[numCostUni]),"","#b5cccc"));
                numCostUni++;
            }
        }
        return mclase;
    }

    public void  AsignacionAve(){
        int punterox;
        if (banFicDeman ){
            numPot = 0;
            punterox = ((((Fabricas + 2) * (Bodega +1 )) ) + numPot);
        }else if(banFicOfet){
            numPot = 2;
            punterox = ((((Fabricas + 2) * (Bodega +1 )) ) + numPot);
        }
        else{
            numPot = 1;
            punterox = ((((Fabricas + 2) * (Bodega +1 )) - nummatriz) + numPot);
        }

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
                        numAsignados++;
                    }
                    else{
                        numeroDiferencia = Integer.parseInt(ARREGLOINFO.get(( menorPos[numRen] + (Bodega - x))).getNumeroAsignar()) - Integer.parseInt(ARREGLOINFO.get(punterox).getNumeroAsignar());
                        ARREGLOINFO.get(menorPos[numRen]).setNumeroAsignar(ARREGLOINFO.get(punterox).getNumeroAsignar());
                        ARREGLOINFO.get(menorPos[numRen]).setColor("#FFFFFF");
                        ARREGLOINFO.get(punterox).setNumeroAsignar("0");
                        ARREGLOINFO.get(menorPos[numRen] + Bodega -x).setNumeroAsignar(String.valueOf(numeroDiferencia));
                        numAsignados++;
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

    public void OptimizacionMODI(){


        int reg1 = (Fabricas + Bodega) - 1;
        int numcolumnaopt = 0;
        int posinit = 0;
        int asigpost = 0;
        int post = 0;
        int postanterior = 0;
        int difernecia= 0 ;
        if (reg1 >= numAsignados){
            int postsupuestarenglon = (numeropostmayorRenglon+1) * (Bodega + 2);
            ARREGLOINFO.get(postsupuestarenglon).setNumeroAsignar("0");
            for (int x = 0 ; x < Bodega ; x ++ ){
                numcolumnaopt = 0 ;
                    numcolumnaopt = -1 * Integer.parseInt(ARREGLOINFO.get(postsupuestarenglon + (x + 1)).getCostUnitario());
                    ARREGLOINFO.get(x +1).setNumeroAsignar(String.valueOf(numcolumnaopt));
            }

            for (int y  = 0 ; y < Fabricas ; y ++){
                for (int p = 0  ; p < numerosRenglones[y];p++ ){
                    post = (y +1) * (Bodega + 2);
                    numcolumnaopt = 0;
                     if (ARREGLOINFO.get(postionAsignados[asigpost] - post).getNumeroAsignar().length() != 0 && ARREGLOINFO.get(post).getNumeroAsignar().length() == 0){
                        numcolumnaopt =   (-1* Integer.parseInt(ARREGLOINFO.get(postionAsignados[asigpost] - post).getNumeroAsignar())) + (-1 * Integer.parseInt(ARREGLOINFO.get(postionAsignados[asigpost]).getCostUnitario()));
                        ARREGLOINFO.get(post).setNumeroAsignar(String.valueOf(numcolumnaopt));
                     }

                    asigpost++;
                }
            }

            posinit = Bodega + 3;
            int valor = 0;
            for (int x = 0 ; x < Fabricas; x++){
                for(int y = 0 ; y < Bodega ; y ++ ){
                    if(ARREGLOINFO.get(posinit).getNumeroAsignar().length() == 0 ){
                                        //Valor de C , Vallor de R  + Valor del Costo unitario
                        valor  =  Integer.parseInt(ARREGLOINFO.get(y+1).getNumeroAsignar())+ Integer.parseInt(ARREGLOINFO.get((Bodega + 2) *(x+1)).getNumeroAsignar()) + Integer.parseInt(ARREGLOINFO.get(posinit).getCostUnitario());
                        ARREGLOINFO.get(posinit).setNumeroAsignar(String.valueOf(valor));

                    }
                    posinit++;
                }

                posinit = posinit + 2;
            }

        }else {
            //Agregar cerosnumeropostmayorRenglon
        }

    }

    public void agregarCero(){

    }

    public void numAsignacionRenglon(){
        int posinit = Bodega + 3;
        numerosRenglones  =  new int [Fabricas];
        int numeroRenglon = 0;
        postionAsignados = new int [numAsignados];
        int numeropost = 0;
        int numeromayor = 0;

        for (int x = 0 ; x < Fabricas; x++){
            for(int y = 0 ; y < Bodega ; y ++ ){
                if(ARREGLOINFO.get(posinit).getNumeroAsignar().length() != 0 ){
                    numeroRenglon++;
                    postionAsignados[numeropost] = posinit;
                    numeropost++;
                }
                posinit++;
            }
            numerosRenglones[x] = numeroRenglon;
            numeroRenglon = 0;
            posinit = posinit + 2;
        }

        for (int p = 0 ; p < Fabricas-1 ; p++){
            if (numerosRenglones[numeromayor] < numerosRenglones[p + 1 ]){
                numeropostmayorRenglon = p +1;
            }
        }
    }

    public void cantidaddeZ(){

        acumuladorZeta =0;
        acumuladorTextZeta ="";
        for (int x = 0 ; x < numAsignados ; x ++ ){
            if (x != 0){
            acumuladorTextZeta = acumuladorTextZeta + " + ";}
            acumuladorZeta = acumuladorZeta + Integer.parseInt( ARREGLOINFO.get(postionAsignados[x]).getNumeroAsignar()) * Integer.parseInt( ARREGLOINFO.get(postionAsignados[x]).getCostUnitario());
            acumuladorTextZeta = acumuladorTextZeta + " " + ARREGLOINFO.get(postionAsignados[x]).getNumeroAsignar() + " * " + ARREGLOINFO.get(postionAsignados[x]).getCostUnitario();
        }
    }


}
