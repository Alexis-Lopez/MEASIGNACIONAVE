package com.ave.www.maave.Fracment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ave.www.maave.Adapter.AdapterSessions;
import com.ave.www.maave.Model.mdSession;
import com.ave.www.maave.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SessionsFragment extends Fragment {


    public SessionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_sessions, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rvSessions);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);

        AdapterSessions adapterSessions = new AdapterSessions(builDescription(),R.layout.item_lecciones,getActivity());
        recyclerView.setAdapter(adapterSessions);
        return view;


    }

    public ArrayList<mdSession> builDescription(){
        ArrayList<mdSession> sessions = new ArrayList<>();
        sessions.add(new mdSession("Descripcion 1"));
        sessions.add(new mdSession("Descripcion 2"));
        sessions.add(new mdSession("Descripcion 3"));
        sessions.add(new mdSession("Descripcion 4"));
        sessions.add(new mdSession("Descripcion 5"));
        sessions.add(new mdSession("Descripcion 6"));
        sessions.add(new mdSession("Descripcion 7"));
        sessions.add(new mdSession("Descripcion 8"));
        sessions.add(new mdSession("Descripcion 9"));

        return sessions;
    }

}
