package com.ave.www.maave.Adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ave.www.maave.Model.mdDetailsQuestion;
import com.ave.www.maave.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by trini on 9/04/18.
 */

public class AdapterQuestions extends RecyclerView.Adapter<AdapterQuestions.CardQuestions> {

    private ArrayList<mdDetailsQuestion> detailsQuestions;
    private int resources;
    private Activity activity;

    public AdapterQuestions(ArrayList<mdDetailsQuestion> detailsQuestions, int resources, Activity activity) {
        this.detailsQuestions = detailsQuestions;
        this.resources = resources;
        this.activity = activity;
    }

    @Override
    public CardQuestions onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resources,parent,false);

        return new AdapterQuestions.CardQuestions(view);
    }

    @Override
    public void onBindViewHolder(CardQuestions holder, int position) {
        mdDetailsQuestion mdDetailsQuestion = detailsQuestions.get(position);

        holder.res1.setText(mdDetailsQuestion.getRespues1());
        holder.tvquestion.setText(mdDetailsQuestion.getQuestion());
        holder.res2.setText(mdDetailsQuestion.getRespues2());
        holder.res3.setText(mdDetailsQuestion.getRespues3());
    }

    @Override
    public int getItemCount() {
        return detailsQuestions.size();
    }

    public class CardQuestions extends RecyclerView.ViewHolder{
        TextView tvquestion;
        TextView res1;
        TextView res2;
        TextView res3;

        public CardQuestions(View itemView) {
            super(itemView);

            tvquestion = (TextView) itemView.findViewById(R.id.tvQuest);
            res1 = (TextView) itemView.findViewById(R.id.tvQuestion1);
            res2 = (TextView) itemView.findViewById(R.id.tvQuestion12);
            res3 = (TextView) itemView.findViewById(R.id.tvQuestion3);
        }
    }
}
