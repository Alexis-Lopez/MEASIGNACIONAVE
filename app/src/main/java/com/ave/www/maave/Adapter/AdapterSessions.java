package com.ave.www.maave.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.media.audiofx.AudioEffect;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ave.www.maave.Details.DetailsSessionActivity;
import com.ave.www.maave.Model.mdSession;
import com.ave.www.maave.R;

import java.util.ArrayList;

/**
 * Created by trini on 8/04/18.
 */

public class AdapterSessions extends RecyclerView.Adapter<AdapterSessions.CardSession> {

    private ArrayList<mdSession> sessions;
    private int resources;
    private Activity activity;

    public AdapterSessions(ArrayList<mdSession> sessions, int resources, Activity activity) {
        this.sessions = sessions;
        this.resources = resources;
        this.activity = activity;
    }

    @Override
    public CardSession onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resources,parent,false);

        return new CardSession(view);
    }

    @Override
    public void onBindViewHolder(CardSession holder, int position) {
        mdSession session = sessions.get(position);
        holder.textView.setText(session.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, DetailsSessionActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return sessions.size();
    }

    public class CardSession extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView;

        public CardSession(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tvLecciones);
        }
    }
}
