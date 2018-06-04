package com.ave.www.maave.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ave.www.maave.Model.mDocuments;
import com.ave.www.maave.R;

import java.util.ArrayList;

/**
 * Created by trini on 25/05/18.
 */

public class AdapterDocuments extends RecyclerView.Adapter<AdapterDocuments.myCardDocument> {

    private ArrayList<mDocuments> mDocumentses;
    private int resources;
    private Activity activity;

    public AdapterDocuments(ArrayList<mDocuments> mDocumentses, int resources, Activity activity) {
        this.mDocumentses = mDocumentses;
        this.resources = resources;
        this.activity = activity;
    }

    @Override
    public myCardDocument onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resources,parent,false);
        return  new AdapterDocuments.myCardDocument(view);
    }

    @Override
    public void onBindViewHolder(myCardDocument holder, final int position) {
            final mDocuments  mDocumentses1 = mDocumentses.get(position);
            holder.tvTitle.setText(mDocumentses1.getTitle());
            holder.tvURL.setText(mDocumentses1.getURL());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(mDocumentses1.getURL()));
                    activity.startActivity(intent);
                }
            });
    }

    @Override
    public int getItemCount() {
        return mDocumentses.size();
    }

    public class myCardDocument  extends RecyclerView.ViewHolder{

        TextView tvTitle;
        TextView tvURL;
        public myCardDocument(View itemView) {
            super(itemView);

            tvTitle = (TextView) itemView.findViewById(R.id.tvTileUrl);
            tvURL = (TextView) itemView.findViewById(R.id.tvurl);
        }
    }
}
