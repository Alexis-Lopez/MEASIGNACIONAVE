package com.ave.www.maave.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ave.www.maave.Details.QuestionActivity;
import com.ave.www.maave.Model.mdTest;
import com.ave.www.maave.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by trini on 8/04/18.
 */

public class AdapterTest extends RecyclerView.Adapter<AdapterTest.CardTest>{

    private ArrayList<mdTest> tests;
    private int resources;
    private Activity activity;

    public AdapterTest(ArrayList<mdTest> tests, int resources, Activity activity) {
        this.tests = tests;
        this.resources = resources;
        this.activity = activity;
    }

    @Override
    public CardTest onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resources,parent,false);
        return new AdapterTest.CardTest(view);
    }

    @Override
    public void onBindViewHolder(CardTest holder, int position) {
        mdTest test = tests.get(position);
        holder.textView.setText(test.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, QuestionActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tests.size();
    }

    public class CardTest extends RecyclerView.ViewHolder{
        private TextView  textView;
        private ImageView imageView;


        public CardTest(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tvLecciones);
        }
    }
}
