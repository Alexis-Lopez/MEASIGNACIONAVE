package com.ave.www.maave.Adapter;

import android.app.Activity;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.ave.www.maave.Model.mClaseMethod;
import com.ave.www.maave.Model.mClassNumro;
import com.ave.www.maave.Model.numerosCeldas;
import com.ave.www.maave.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by trini on 17/04/18.
 */

public class AdapterCellCost extends RecyclerView.Adapter<AdapterCellCost.myCardCellCost> {
    private ArrayList<numerosCeldas> mClaseMethods;
    private int resources;
    private Activity activity;
    String txtDataset [] ;

    public AdapterCellCost(ArrayList<numerosCeldas> mClaseMethods, int resources, Activity activity) {
        this.mClaseMethods = mClaseMethods;
        this.resources = resources;
        this.activity = activity;

        txtDataset = new String[mClaseMethods.size()];
    }

    @Override
    public myCardCellCost onCreateViewHolder(ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(resources,parent,false);
        return new AdapterCellCost.myCardCellCost(view);
    }

    @Override
    public void onBindViewHolder(myCardCellCost holder, int position) {
        numerosCeldas mClase = mClaseMethods.get(position);
        holder.textView.setText((String.valueOf(mClase.getNumero())));

    }

    @Override
    public int getItemCount() {
        return mClaseMethods.size();
    }

    public class myCardCellCost extends RecyclerView.ViewHolder{

        EditText    editText;
        TextView textView;
        public myCardCellCost(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tvNumCel);
            editText = (EditText) itemView.findViewById(R.id.edtNumCellCost);

            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    txtDataset[getAdapterPosition()] = s.toString();
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

        }
    }

    public String[] getTxtDataset() {
        return txtDataset;
    }
}
