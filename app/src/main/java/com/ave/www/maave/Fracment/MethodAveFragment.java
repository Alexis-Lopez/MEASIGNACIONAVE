package com.ave.www.maave.Fracment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.ave.www.maave.CantColumFilasActivity;
import com.ave.www.maave.Model.mClaseMethod;
import com.ave.www.maave.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MethodAveFragment  extends Fragment {

    public static mClaseMethod miMethod;
    CantColumFragment cantColumFragment = new CantColumFragment();


    TextInputEditText edtBodegas;
    TextInputEditText edtFabricas;
     String Bodega = " " ,  Fabrica = " ";
    public MethodAveFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_method_ave, container, false);

        onCell(view);
        // Inflate the layout for this fragment
        return view;
    }

    public void onCell(View view){

       Button btn = (Button) view.findViewById(R.id.idcontinuar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                edtBodegas = getActivity().findViewById(R.id.txtfilas);
                edtFabricas = getActivity().findViewById(R.id.txtColumns);
                Bodega = edtBodegas.getText().toString();
                Fabrica = edtFabricas.getText().toString().trim();
                Bundle bundle = new Bundle();

                if(Bodega.equals("") || Fabrica.equals("")){
                    Toast.makeText(getActivity(),"No dejas campos vacios Bodega  =  " + Bodega,Toast.LENGTH_SHORT).show();
                }
                else {
                    int Bodegas = Integer.parseInt(edtBodegas.getText().toString().trim());
                    int Fabricas = Integer.parseInt(edtFabricas.getText().toString().trim());
                    Intent intent = new Intent(getActivity(), CantColumFilasActivity.class);
                    intent.putExtra("my_key_bodegas", Bodegas);
                    intent.putExtra("my_key_fabricas" , Fabricas);
                   // intent.putExtra("my_key_fabricas",edtFabricas.getText().toString().trim());
                    startActivity(intent);
                }
            }});
    }


}
