package com.ave.www.maave.Adapter;

import android.app.Activity;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.ave.www.maave.Model.mClassNumro;
import com.ave.www.maave.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by trini on 17/04/18.
 */

public class AdapterFilasNumber  extends RecyclerView.Adapter<AdapterFilasNumber.myCardCanColums>{

    private ArrayList<mClassNumro> numros;
    private int resources;
    private Activity activity;
    String [] txtEscritos;

    public AdapterFilasNumber(ArrayList<mClassNumro> numros, int resources, Activity activity) {
        this.numros = numros;
        this.resources = resources;
        this.activity = activity;

        txtEscritos = new String[numros.size()];
    }

    @Override
    public myCardCanColums onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resources,parent,false);
        return new AdapterFilasNumber.myCardCanColums(view);
    }

    @Override
    public void onBindViewHolder(myCardCanColums holder, int position) {
        mClassNumro Numro = numros.get(position);

        holder.textInputEditText.setHint(Numro.getNumero());
    }

    @Override
    public int getItemCount() {
        return numros.size();
    }

    public class  myCardCanColums extends RecyclerView.ViewHolder {
       TextInputEditText textInputEditText;


        public myCardCanColums(View itemView) {
            super(itemView);
            textInputEditText = (TextInputEditText) itemView.findViewById(R.id.edtNuCoumna);

            textInputEditText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    txtEscritos[getAdapterPosition()] = s.toString();
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });


        }
    }

    public String[] getTxtEscritos() {
        return txtEscritos;
    }
}
