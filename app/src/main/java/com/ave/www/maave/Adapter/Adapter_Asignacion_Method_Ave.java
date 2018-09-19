package com.ave.www.maave.Adapter;

import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ave.www.maave.Model.mClaseAsignacionAve;
import com.ave.www.maave.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by trini on 15/05/18.
 */

public class Adapter_Asignacion_Method_Ave extends RecyclerView.Adapter<Adapter_Asignacion_Method_Ave.myCardViewholder>  {

    private ArrayList<mClaseAsignacionAve> mClaseAsignacionAves;
    private int resources;
    private Activity activity;

    public Adapter_Asignacion_Method_Ave(ArrayList<mClaseAsignacionAve> mClaseAsignacionAves, int resources, Activity activity) {
        this.mClaseAsignacionAves = mClaseAsignacionAves;
        this.resources = resources;
        this.activity = activity;
    }

    @Override
    public myCardViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resources,parent,false);


        return new Adapter_Asignacion_Method_Ave.myCardViewholder(view);
    }

    @Override
    public void onBindViewHolder(myCardViewholder holder, int position) {
        final mClaseAsignacionAve mClase = mClaseAsignacionAves.get(position) ;

        holder.tvNumeroAsignar.setText(String.valueOf(mClase.getNumeroAsignar())  );
        holder.tvCostUnitario.setText(String.valueOf(mClase.getCostUnitario()));
        holder.tvPosition.setText(mClase.getPosition());
        holder.LlColorCell.setBackgroundColor(Color.parseColor(mClase.getColor()));
    }

    @Override
    public int getItemCount() {
        return mClaseAsignacionAves.size();
    }

    public void refresevent(ArrayList<mClaseAsignacionAve> mclase) {
        this.mClaseAsignacionAves.clear();
        this.mClaseAsignacionAves.addAll(mclase);
        this.notifyDataSetChanged();
    }

    public class myCardViewholder extends RecyclerView.ViewHolder {
        TextView tvNumeroAsignar;
        TextView tvCostUnitario;
        TextView tvPosition;
        LinearLayout LlColorCell;

        public myCardViewholder(View itemView) {
            super(itemView);

            tvNumeroAsignar = (TextView) itemView.findViewById(R.id.tvNumCelMethod);
            tvCostUnitario = (TextView) itemView.findViewById(R.id.tvCostUni);
            tvPosition = (TextView) itemView.findViewById(R.id.tvPosition);
            LlColorCell = (LinearLayout) itemView.findViewById(R.id.colorCell);

        }
    }

}
